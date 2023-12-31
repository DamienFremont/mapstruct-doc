/*
 * Copyright (c) 2023 Damien FREMONT.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.damienfremont.mapstruct.parser;

import com.damienfremont.mapstruct.model.MapperModel;
import com.damienfremont.mapstruct.model.MappingModel;
import org.mapstruct.Mapping;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodNode;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class MapstructDocParser {

  public List<MapperModel> parse(Class<?> include) {
    try {
      Method m0 = include.getMethods()[0];
      MapperModel mm0 = new MapperModel();
      mm0.setName(include.getSimpleName());
      mm0.setClazz(include);
      mm0.setMappings(parseMappings(m0));
      return Arrays.asList(mm0);
    } catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }

  private List<MappingModel> parseMappings(Method m0) throws IOException {
    return Stream
            .concat(
                    parseDefaultMappings(m0).stream(),
                    parseAnnotatMappings(m0).stream())
            .sorted(Comparator.comparing(s -> s.getTarget().toLowerCase()))
            .collect(toList());
  }

  List<MappingModel> parseDefaultMappings(Method method) {
    Class<?> defTgt = method.getReturnType();
    Class<?> defSrc = method.getParameterTypes()[0];
    Field[] defTgtFs = defTgt.getDeclaredFields();
    Field[] defSrcFs = defSrc.getDeclaredFields();
    return stream(defTgtFs)
            .filter(i -> sourceFieldExists(i, defSrcFs))
            .map(this::toMappingModel)
            .collect(toList());
  }

  // ASM Tree API https://www.javacodegeeks.com/2012/02/manipulating-java-class-files-with-asm_22.html
  List<MappingModel> parseAnnotatMappings(Method m0) throws IOException {
    List<MappingModel> res = new ArrayList<>();
    Class<Mapping> mappingClass = Mapping.class;
    String name = m0.getDeclaringClass().getName().replace(".", "/") + ".class";
    String path = m0.getDeclaringClass().getProtectionDomain().getCodeSource().getLocation().getPath();
    String name1 = path.substring(1) + name;
    InputStream in = new FileInputStream(name1);
    ClassReader cr = new ClassReader(in);
    ClassNode classNode = new ClassNode();
    cr.accept(classNode, 0);
    for (MethodNode methodNode : classNode.methods) {
      if (methodNode.invisibleAnnotations != null) {
        for (AnnotationNode annotationNode : methodNode.invisibleAnnotations) {
          if (annotationNode.desc.equals("L" + mappingClass.getName().replace(".", "/") + ";")) {
            String srcVal = annotationNode.values.get(1).toString();
            String tgtVal = annotationNode.values.get(3).toString();
            res.add(new MappingModel(srcVal, tgtVal));
          }
        }
      }
    }
    return res;
  }

  boolean sourceFieldExists(Field field, Field[] defSrcFs) {
    Predicate<Field> hasSameName = f -> f.getName().equals(field.getName());
    Predicate<Field> ignoreJacocoData = f -> !f.isSynthetic();
    return stream(defSrcFs)
            .anyMatch(hasSameName
                    .and(ignoreJacocoData));
  }

  MappingModel toMappingModel(Field f) {
    return new MappingModel(f.getName(), f.getName());
  }
}
