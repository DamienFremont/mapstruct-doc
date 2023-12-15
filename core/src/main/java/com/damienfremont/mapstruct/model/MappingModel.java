/*
 * Copyright (c) 2023 Damien FREMONT.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.damienfremont.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * see org.mapstruct.Mapping
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MappingModel {
  String source;
  String target;
}
