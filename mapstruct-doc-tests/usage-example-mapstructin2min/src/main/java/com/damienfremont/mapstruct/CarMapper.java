package com.damienfremont.mapstructdoc;

import com.damienfremont.mapstructdoc.source.CarSourcePojo;
import com.damienfremont.mapstructdoc.target.CarTargetPogo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE)
public interface CarMapper {

  CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

  @Mappings({
          @Mapping(source = "make", target = "make"),
          @Mapping(source = "numberOfSeats", target = "seatCount"),
          @Mapping(source = "type", target = "type")
  })
  CarTargetPogo carToCarDto(CarSourcePojo carSourcePojo);

}
