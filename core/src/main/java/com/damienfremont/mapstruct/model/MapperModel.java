package com.damienfremont.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MapperModel {
  String name;
  Class clazz;
  List<MappingModel> mappings = new ArrayList<>();
}
