package com.damienfremont.mapstruct.parser;

import com.damienfremont.mapstruct.model.MapperModel;
import com.damienfremont.mapstruct.model.MappingModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapstructDocParserTest {

  MapstructDocParser classUnderTest = new MapstructDocParser();

  @Test
  void parse() throws Exception {
    // GIVEN
    ClassLoader cl = this.getClass().getClassLoader();
    Class<?> c0 = cl.loadClass("com.damienfremont.mapstruct.example.getstarted.CarMapper");
    // WHEN
    List<MapperModel> res = classUnderTest.parse(c0);
    // THEN
    MapperModel res0 = res.get(0);
    assertEquals("CarMapper", res0.getName());
    assertEquals_MappingModel("carToCarDto", null, res0.getMappings().get(0));
  }

  private void assertEquals_MappingModel(String carToCarDto, String expected, MappingModel res0map0) {
    assertEquals(carToCarDto, res0map0.getSource());
    assertEquals(expected, res0map0.getTarget());
  }
}