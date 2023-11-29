package com.damienfremont.mapstruct;

import com.google.auto.service.AutoService;
import org.mapstruct.Mapper;

import javax.annotation.processing.*;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import java.io.PrintWriter;
import java.util.Set;

import static java.lang.String.format;

@AutoService(Processor.class)
@SupportedAnnotationTypes("org.mapstruct.Mapper")
public class MappingDocProcessor extends AbstractProcessor {

  Messager messager;
  Filer filer;

  @Override
  public synchronized void init(ProcessingEnvironment env) {
    messager = env.getMessager();
    filer = env.getFiler();
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
    try {
      for (TypeElement annotation : annotations) {
        Set<? extends Element> annotatedElements = env.getElementsAnnotatedWith(Mapper.class);
        Element clazz = annotatedElements.stream().findFirst().get();
        String filename = format("%s.csv", clazz.getSimpleName());
        System.out.println(filename);
        FileObject builderFile = filer.createResource(
                StandardLocation.CLASS_OUTPUT,
                "",
                filename);
        try (PrintWriter out = new PrintWriter(builderFile.openWriter())) {
          out.print("");
        }
      }
    } catch (Exception e) {
      error(e);
    }
    return true;
  }

  private void error(Exception e) {
    e.printStackTrace();
    messager.printMessage(Diagnostic.Kind.ERROR, e.getMessage(), null);
  }
}
