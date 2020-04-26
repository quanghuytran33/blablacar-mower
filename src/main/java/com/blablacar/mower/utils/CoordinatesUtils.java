package com.blablacar.mower.utils;

import com.blablacar.mower.domain.Coordinates;
import com.blablacar.mower.enumeration.EOrientation;
import java.util.Arrays;

public class CoordinatesUtils {

  private CoordinatesUtils() {

  }

  public static Coordinates computeNextCoordinateWithOrientation(
      final Coordinates previousCoordinates,
      EOrientation orientation) {
    switch (orientation) {
      case NORTH:
        return new Coordinates(previousCoordinates.getHorizontal(),
            previousCoordinates.getVertical() + 1);
      case EAST:
        return new Coordinates(previousCoordinates.getHorizontal() + 1,
            previousCoordinates.getVertical());
      case SOUTH:
        return new Coordinates(previousCoordinates.getHorizontal(),
            previousCoordinates.getVertical() - 1);
      case WEST:
        return new Coordinates(previousCoordinates.getHorizontal() - 1,
            previousCoordinates.getVertical());
      default:
        throw new IllegalArgumentException(
            "Orientation " + orientation + " not supported in enum " + Arrays
                .toString(EOrientation.values()));
    }
  }

}
