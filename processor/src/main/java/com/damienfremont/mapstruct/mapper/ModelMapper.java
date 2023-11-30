package com.damienfremont.mapstruct.mapper;

import com.damienfremont.mapstruct.model.MapperModel;
import com.damienfremont.mapstruct.model.MappingModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

public class ModelMapper {

  public static MapperModel toModel(RoundEnvironment env, ProcessingEnvironment pEnv) {
    Element clazzEl = toCLass(env);
    System.out.println("class: " + clazzEl);
    for (Element m : clazzEl.getEnclosedElements()) {
      Mapping a = m.getAnnotation(Mapping.class);
      if (a != null && m.getKind() == ElementKind.METHOD) {
        ExecutableElement method = (ExecutableElement) m;
//        System.out.println("a.source(): " + a.source());
//        System.out.println("a.target(): " + a.target());
        System.out.println("method: " + method.getSimpleName());
        TypeMirror returnType = method.asType();
        System.out.println("method.returnType: " + returnType);
        System.out.println("method.returnType.getClass: " + returnType.getClass());
        List<? extends VariableElement> parameters = method.getParameters();
        parameters.forEach(p -> {
          String paramName = p.getSimpleName().toString();
          TypeMirror paramType = p.asType();
          System.out.println("method.param:paramName: " + paramName);
        });
        TypeMirror param0 = parameters.get(0).asType();
        extracted(pEnv, param0);
      }
    }

    List<Element> methEls = toCLass(env)
            .getEnclosedElements()
            .stream()
            .filter(i -> ElementKind.METHOD == i.getKind())
            .collect(toList());
    MapperModel model = new MapperModel(
            toCLassName(env),
            null, // getClass(toCLass(env), pEnv),
            toMappingModels(env));
    return model;
  }

  private static void extracted(ProcessingEnvironment pEnv, TypeMirror tm) {
    TypeElement te = (TypeElement) pEnv.getTypeUtils().asElement(tm);
    System.out.println("type: " + te);
    for (VariableElement ee : ElementFilter.fieldsIn(te.getEnclosedElements())) {
      System.out.println("field: " + ee);
    }
  }

  public static boolean isMapper(RoundEnvironment env) {
    return env.getElementsAnnotatedWith(Mapper.class)
            .stream()
            .findAny()
            .isPresent();
  }

  public static String toCLassName(RoundEnvironment env) {
    return env.getElementsAnnotatedWith(Mapper.class)
            .stream()
            .findFirst()
            .get()
            .getSimpleName()
            .toString();
  }

  public static Element toCLass(RoundEnvironment env) {
    return env.getElementsAnnotatedWith(Mapper.class)
            .stream()
            .findFirst()
            .get();
  }

  public static List<MappingModel> toMappingModels(RoundEnvironment env) {
    return env.getElementsAnnotatedWith(Mapping.class)
            .stream()
            .map(i -> new MappingModel(
                    i.getSimpleName().toString(),
                    toSubMappingModels(i)))
            .collect(toList());
  }

  private static List<String> toSubMappingModels(Element el) {
    Mapping a = el.getAnnotation(Mapping.class);
    String s = format("%s,%s", a.source(), a.target());
    return Arrays.asList(s);
  }

  private static Class getClass(Element el, ProcessingEnvironment pEnv) {
    try {
      String claStr = el.getSimpleName().toString();
      PackageElement ePak = pEnv.getElementUtils().getPackageOf(el);
      String pakStr = ePak.getQualifiedName().toString();
      Class clazz = Class.forName(pakStr + "." + claStr);
      return clazz;
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
}
