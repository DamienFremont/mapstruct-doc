/*
 * Copyright (c) 2023 Damien FREMONT.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.damienfremont.mapstruct.file;

import com.damienfremont.mapstruct.model.MapperModel;
import com.damienfremont.mapstruct.model.MappingModel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.lang.String.format;
import static java.lang.String.join;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.createDirectories;
import static java.nio.file.Files.write;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.WRITE;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class CsvFileBuilder {

  public static Path writeCsvFile(MapperModel model, Path dir) {
    Path file = createdFile(model.getName(), dir);
    writeHeader(file);
    writeLines(file, model
            .getMappings().stream()
            .map(CsvFileBuilder::formatMapping)
            .collect(toList()));
    return file;
  }

  static Path createdFile(String name, Path dir) {
    try {
      String filename = format("%s.csv", name);
      Path file = get(dir.toString(), filename);
      createDirectories(dir);
      if (file.toFile().exists()) {
        Files.deleteIfExists(file);
      }
      return Files.createFile(file);
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }

  static void writeHeader(Path file) {
    writeLine(file, formatHeader());
  }

  static void writeLines(Path file, List<String> lines) {
    for (String l : lines) {
      writeLine(file, l);
    }
  }

  static void writeLine(Path file, String line) {
    try {
      write(file, asList(line), UTF_8, WRITE, APPEND);
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
  }

  static String formatHeader() {
    return join(",", asList("SOURCE", "TARGET"));
  }

  static String formatMapping(MappingModel i) {
    return join(",", asList(i.getSource(), i.getTarget()));
  }
}
