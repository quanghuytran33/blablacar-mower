package com.blablacar.mower.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
public class Coordinates {

  private final int horizontal;
  private final int vertical;

  public Coordinates(String horizontal, String vertical) {
    this.horizontal = Integer.parseInt(horizontal);
    this.vertical = Integer.parseInt(vertical);
  }

}
