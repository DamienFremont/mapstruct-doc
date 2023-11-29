package com.damienfremont.mapstruct;

import com.damienfremont.mapstruct.source.Car;
import com.damienfremont.mapstruct.target.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * source: https://mapstruct.org/#get-started
 */
@Mapper
public interface CarMapper {

  CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

  @Mapping(source = "numberOfSeats", target = "seatCount")
  CarDto carToCarDto(Car car);
}


