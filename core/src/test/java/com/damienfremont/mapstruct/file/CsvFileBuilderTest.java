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
            .exists()
            .hasSameTextualContentAs(
                    get("src/test/resources/example/getstarted/CarMapper.csv"));
  }

  private MapperModel buildMapperModel() {
    return new MapperModel(
            "CarMapper",
            null,
            asList(
                    new MappingModel("make", "make"),
                    new MappingModel("numberOfSeats", "seatCount"),
                    new MappingModel("type", "type")));
  }
}