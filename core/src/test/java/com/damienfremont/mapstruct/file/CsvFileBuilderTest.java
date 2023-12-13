package com.damienfremont.mapstruct.file;

import com.damienfremont.mapstruct.model.MapperModel;
import com.damienfremont.mapstruct.model.MappingModel;
import org.junit.jupiter.api.Test;

import static java.nio.file.Paths.get;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class CsvFileBuilderTest {

  @Test
  void writeCsvFile() {
    assertThat(CsvFileBuilder
            .writeCsvFile(
                    buildMapperModel(),
                    get("target/classes/")))
            .hasSameTextualContentAs(
                    get("src/test/resources/testdatas/CarMapper.csv"));
  }

  private MapperModel buildMapperModel() {
    return new MapperModel(
            "CarMapper",
            null,
            asList(
                    new MappingModel("make,make", null),
                    new MappingModel("numberOfSeats,seatCount", null),
                    new MappingModel("type,type", null)));
  }
}