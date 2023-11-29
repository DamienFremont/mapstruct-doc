package com.damienfremont.mapstruct;

import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@AutoService(Processor.class)
@SupportedAnnotationTypes("org.mapstruct.Mapper")
public class MappingDocProcessor extends AbstractProcessor {

  Messager messager;

  @Override
  public synchronized void init(ProcessingEnvironment env) {
    messager = env.getMessager();
  }

  @Override
  public boolean process(Set<? extends TypeElement> annoations, RoundEnvironment env) {
    try {
      // TODO
      System.out.println("MappingDocProcessor.process(...)");
    } catch (Exception e) {
      error(null, e.getMessage());
    }
    return true;
  }

  void error(Element e, String msg) {
    messager.printMessage(Diagnostic.Kind.ERROR, msg, e);
  }
}
