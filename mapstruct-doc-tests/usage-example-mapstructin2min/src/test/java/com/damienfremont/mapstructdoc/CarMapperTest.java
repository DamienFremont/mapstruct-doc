package com.damienfremont.mapstructdoc;

import com.damienfremont.mapstructdoc.source.CarSourcePojo;
import com.damienfremont.mapstructdoc.target.CarTargetPogo;
import org.junit.jupiter.api.Test;

import static com.damienfremont.mapstructdoc.source.CarSourceType.SEDAN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CarMapperTest {

  CarMapper classUnderTest = CarMapper.INSTANCE;

  @Test // TODO: @ParameterizedTest(..."param.json"..."expected.json"...)
  public void shouldMapCarToDto() {
    // GIVEN
    CarSourcePojo arg = new CarSourcePojo( // TODO: readJson(...))
            "Morris",
            5,
            SEDAN);
    // WHEN
    CarTargetPogo res = classUnderTest.carToCarDto(arg);
    // THEN
    assertNotNull(res);
    assertEquals("Morris", res.getMake()); // TODO: assertObjectEquals(res, readJson(...))
    assertEquals(5, res.getSeatCount());
    assertEquals("SEDAN", res.getType());
  }
}