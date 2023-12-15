/*
 * Copyright (c) 2023 Damien FREMONT.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.damienfremont.mapstruct.example.getstarted;

import com.damienfremont.mapstruct.example.getstarted.source.Car;
import com.damienfremont.mapstruct.example.getstarted.source.CarType;
import com.damienfremont.mapstruct.example.getstarted.target.CarDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * source: https://mapstruct.org/#get-started
 */
class CarMapperTest {

  @Test
  void shouldMapCarToDto() {
    // given
    Car car = new Car("Morris", 5, CarType.SEDAN);
    // when
    CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);
    // then
    assertThat(carDto).isNotNull();
    assertThat(carDto.getMake()).isEqualTo("Morris");
    assertThat(carDto.getSeatCount()).isEqualTo(5);
    assertThat(carDto.getType()).isEqualTo("SEDAN");
  }
}