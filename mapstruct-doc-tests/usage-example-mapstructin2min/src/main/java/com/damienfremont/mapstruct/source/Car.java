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

