/*
 * Copyright (c) 2023 Damien FREMONT.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.damienfremont.mapstruct.parser;

import com.damienfremont.mapstruct.model.MapperModel;
import com.damienfremont.mapstruct.model.MappingModel;
import org.mapstruct.Mapping;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class MapstructDocParser {

  public List<MapperModel> parse(Class include) {
    try {

      MapperModel m0 = new MapperModel();
      m0.setName(include.getSimpleName());
      m0.setClazz(include);
      m0.setMappings(parseMethods(include.getMethods()));
      return Arrays.asList(m0);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  List<MappingModel> parseMethods(Method[] methods) {
    return stream(methods)
// FIXME:           .filter(this::hasMappingAnnotation)
            .map(this::toMappingModel)
            .collect(toList());
  }

  MappingModel toMappingModel(Method m) {
    return new MappingModel(m.getName(), null);
  }

  boolean hasMappingAnnotation(Method m) {
    return stream(m.getAnnotations())
            .filter(a -> Mapping.class == a.getClass())
            .findAny()
            .isPresent();
  }
}
