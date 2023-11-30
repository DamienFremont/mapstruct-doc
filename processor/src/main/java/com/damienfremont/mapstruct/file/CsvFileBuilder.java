package com.damienfremont.mapstruct.file;

import com.damienfremont.mapstruct.model.MapperModel;
import com.damienfremont.mapstruct.model.MappingModel;

import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import java.io.IOException;
import java.io.PrintWriter;

import static java.lang.String.format;

public class CsvFileBuilder {

  public static void writeCsvFile(MapperModel model, ProcessingEnvironment env) throws IOException {
    Filer filer = env.getFiler();
    FileObject builderFile = buildFile(model.getName(), filer);
    try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {
      out.println("SOURCE,TARGET");
      for (MappingModel m : model.getMappings()) {
        for (String ms : m.getMappings()) {
          out.println(ms);
        }
      }
    }
  }

  private static FileObject buildFile(String name, Filer filer) throws
          IOException {
    String filename = format("%s.csv", name);
    FileObject builderFile = filer.createResource(
            StandardLocation.CLASS_OUTPUT,
            "",
            filename);
    return builderFile;
  }
}
