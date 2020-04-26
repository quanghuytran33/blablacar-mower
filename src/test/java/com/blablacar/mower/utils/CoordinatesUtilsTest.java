package com.blablacar.mower.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.blablacar.mower.domain.Coordinates;
import com.blablacar.mower.enumeration.EOrientation;
import org.junit.jupiter.api.Test;

class CoordinatesUtilsTest {

  public Coordinates dummyCoordinates() {
    return new Coordinates(1, 1);
  }

  @Test
  public void shouldReturnVerticalPlus1_whenOrientationIsNorth() {
    assertEquals(new Coordinates(1, 2),
        CoordinatesUtils
            .computeNextCoordinateWithOrientation(dummyCoordinates(), EOrientation.NORTH));
  }

  @Test
  public void shouldReturnHorizontalPlus1_whenOrientationIsEast() {
    assertEquals(new Coordinates(2, 1),
        CoordinatesUtils
            .computeNextCoordinateWithOrientation(dummyCoordinates(), EOrientation.EAST));
  }

  @Test
  public void shouldReturnVerticalMinus1_whenOrientationIsSouth() {
    assertEquals(new Coordinates(1, 0),
        CoordinatesUtils
            .computeNextCoordinateWithOrientation(dummyCoordinates(), EOrientation.SOUTH));
  }

  @Test
  public void shouldReturnHorizontalMinus1_whenOrientationIsWest() {
    assertEquals(new Coordinates(0, 1),
        CoordinatesUtils
            .computeNextCoordinateWithOrientation(dummyCoordinates(), EOrientation.WEST));
  }

}