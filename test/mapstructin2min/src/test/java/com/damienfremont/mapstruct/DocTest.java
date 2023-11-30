package com.damienfremont.mapstruct;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class DocTest {

  @Test
  void test() {
    Path res = Paths.get("target/classes/CarMapper.csv");
    Path exp = Paths.get("src/test/resources/testdatas/CarMapper.csv");
    assertThat(res).hasSameTextualContentAs(exp);
  }
}
