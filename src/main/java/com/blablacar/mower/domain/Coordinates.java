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

}
