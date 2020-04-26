package com.blablacar.mower.utils;

import com.blablacar.mower.enumeration.EOrientation;

public class OrientationTestUtils {

  public static EOrientation convertCharToOrientation(String orientation) {
    switch (orientation) {
      case "N":
        return EOrientation.NORTH;
      case "E":
        return EOrientation.EAST;
      case "S":
        return EOrientation.SOUTH;
      case "W":
        return EOrientation.WEST;
      default:
        throw new IllegalArgumentException();
    }
  }

}
