package com.damienfremont.mapstructdoc;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE)
public interface CarMapper {

  CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

  @Mapping(source = "make", target = "make")
  @Mapping(source = "numberOfSeats", target = "seatCount")
  @Mapping(source = "type", target = "type")
  CarDto carToCarDto(Car car);
}
