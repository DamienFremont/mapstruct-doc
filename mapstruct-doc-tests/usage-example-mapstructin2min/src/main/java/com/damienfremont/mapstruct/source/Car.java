package com.damienfremont.mapstruct.source;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarSourcePojo {

  private String make;
  private int numberOfSeats;
  private CarSourceType type;

  //constructor, getters, setters etc.
}

