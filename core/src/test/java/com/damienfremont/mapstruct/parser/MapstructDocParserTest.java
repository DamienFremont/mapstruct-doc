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
    assertEquals("CarMapper", getMappingName(res));
    assertEquals_MappingModel("make", "make", getMappingModel(res, 0));
    assertEquals_MappingModel("numberOfSeats", "seatCount", getMappingModel(res, 1));
    assertEquals_MappingModel("type", "type", getMappingModel(res, 2));
  }

  private void assertEquals_MappingModel(String expSrc, String expTgt, MappingModel act) {
    assertEquals(expSrc, act.getSource());
    assertEquals(expTgt, act.getTarget());
  }

  private String getMappingName(List<MapperModel> res) {
    return res.get(0).getName();
  }

  private MappingModel getMappingModel(List<MapperModel> res, int index) {
    return res.get(0).getMappings().get(index);
  }
}