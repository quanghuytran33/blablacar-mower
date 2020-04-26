package com.blablacar.mower.enumeration;

import lombok.Getter;

@Getter
public enum EOrientation {

  NORTH,
  EAST,
  SOUTH,
  WEST;

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
}
