/*
 * Copyright (c) 2023 Damien FREMONT.
 *
 * Licensed under the Apache License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package com.damienfremont.mapstruct.source;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * source: https://mapstruct.org/#get-started
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

  private String make;
  private int numberOfSeats;
  private CarType type;

  //constructor, getters, setters etc.
}

