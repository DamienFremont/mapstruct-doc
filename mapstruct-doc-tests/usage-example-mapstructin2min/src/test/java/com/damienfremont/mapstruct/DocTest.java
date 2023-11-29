package com.damienfremont.mapstruct;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DocTest {

  @Test
  void test() {
    Path docPath = Paths.get("target/classes/CarMapper.csv");
    assertTrue(Files.exists(docPath));
  }
}
