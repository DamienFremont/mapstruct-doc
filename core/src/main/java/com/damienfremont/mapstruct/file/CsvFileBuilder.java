/*
 * Copyright (c) 2023 Damien FREMONT.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.damienfremont.mapstruct.file;

import com.damienfremont.mapstruct.model.MapperModel;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.WRITE;
import static java.util.Arrays.asList;

public class CsvFileBuilder {

  static final Charset UTF_8 = Charset.forName("UTF-8");

  public static Path writeCsvFile(MapperModel model, Path dir) {
    Path file = createdFile(model.getName(), dir);
    writeHeader(file);
    writeLines(file, model
            .getMappings().stream()
            .map(i -> i.getName())
            .collect(Collectors.toList()));
    return file;
  }

  static Path createdFile(String name, Path dir) {
    try {
      String filename = format("%s.csv", name);
      Path file = Paths.get(dir.toString(), filename);
      Files.createDirectories(dir);
      if (file.toFile().exists()) {
        Files.deleteIfExists(file);
      }
      return Files.createFile(file);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  static void writeHeader(Path file) {
    writeLine(file, "SOURCE,TARGET");
  }

  static void writeLines(Path file, List<String> lines) {
    for (String l : lines) {
      writeLine(file, l);
    }
  }

  static void writeLine(Path file, String line) {
    try {
      Files.write(file, asList(line), UTF_8, WRITE, APPEND);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
