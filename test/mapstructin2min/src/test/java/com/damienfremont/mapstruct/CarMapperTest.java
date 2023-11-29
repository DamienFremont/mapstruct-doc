package com.damienfremont.mapstruct;

import com.damienfremont.mapstruct.source.Car;
import com.damienfremont.mapstruct.source.CarType;
import com.damienfremont.mapstruct.target.CarDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * source: https://mapstruct.org/#get-started
 */
class CarMapperTest {

  @Test
  public void shouldMapCarToDto() {
    //given
    Car car = new Car("Morris", 5, CarType.SEDAN);

    //when
    CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);

    //then
    assertThat(carDto).isNotNull();
    assertThat(carDto.getMake()).isEqualTo("Morris");
    assertThat(carDto.getSeatCount()).isEqualTo(5);
    assertThat(carDto.getType()).isEqualTo("SEDAN");
  }
}