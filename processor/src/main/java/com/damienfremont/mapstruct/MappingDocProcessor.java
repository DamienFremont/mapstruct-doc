package com.damienfremont.mapstruct;

import com.damienfremont.mapstruct.file.CsvFileBuilder;
import com.damienfremont.mapstruct.mapper.ModelMapper;
import com.damienfremont.mapstruct.model.MapperModel;
import com.google.auto.service.AutoService;

import javax.annotation.processing.*;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@AutoService(Processor.class)
@SupportedAnnotationTypes({
        "org.mapstruct.Mapper",
        "org.mapstruct.Mapping",
        "org.mapstruct.Mappings",
})
public class MappingDocProcessor extends AbstractProcessor {

  ProcessingEnvironment env;
  Messager messager;

  @Override
  public synchronized void init(ProcessingEnvironment env) {
    this.env = env;
    this.messager = env.getMessager();
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
    try {
      if (!ModelMapper.isMapper(env))
        return true;
      MapperModel model = ModelMapper.toModel(env, this.env);
      CsvFileBuilder.writeCsvFile(model, this.env);
    } catch (Exception e) {
      error(e);
    }
    return true;
  }

  void error(Exception e) {
    e.printStackTrace();
    messager.printMessage(Diagnostic.Kind.ERROR, e.getMessage(), null);
  }
}
