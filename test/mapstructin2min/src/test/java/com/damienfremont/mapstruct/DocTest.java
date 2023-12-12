/*
 * Copyright (c) 2023 Damien FREMONT.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.damienfremont.mapstruct;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

class DocTest {

  @Test @Disabled("TODO") // TODO:
  void test() {
    Path res = Paths.get("target/classes/CarMapper.csv");
    Path exp = Paths.get("src/test/resources/testdatas/CarMapper.csv");
    assertThat(res).hasSameTextualContentAs(exp);
  }
}
