package com.blablacar.mower.enumeration;

import lombok.Getter;

@Getter
public enum EOrientation {

  NORTH('N'),
  EAST('E'),
  SOUTH('S'),
  WEST('W');

  static {
    NORTH.leftOrientation = WEST;
    NORTH.rightOrientation = EAST;

    EAST.leftOrientation = NORTH;
    EAST.rightOrientation = SOUTH;

    SOUTH.leftOrientation = EAST;
    SOUTH.rightOrientation = WEST;

    WEST.leftOrientation = SOUTH;
    WEST.rightOrientation = NORTH;
  }

  private EOrientation leftOrientation;
  private EOrientation rightOrientation;
  private char symbol;

  EOrientation(char symbol) {
    this.symbol = symbol;
  }

  public static EOrientation convertSymbolToOrientation(String orientation) {
    switch (orientation) {
      case "N":
        return NORTH;
      case "E":
        return EAST;
      case "S":
        return SOUTH;
      case "W":
        return WEST;
      default:
        throw new IllegalArgumentException();
    }
  }
}
