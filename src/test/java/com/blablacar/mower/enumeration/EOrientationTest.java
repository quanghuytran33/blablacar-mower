package com.blablacar.mower.enumeration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EOrientationTest {

  @Test
  public void shouldReturnLeftIsWest_whenOrientationIsNorth() {
    Assertions.assertEquals(EOrientation.WEST, EOrientation.NORTH.getLeftOrientation());
  }

  @Test
  public void shouldReturnRightIsEast_whenOrientationIsNorth() {
    Assertions.assertEquals(EOrientation.EAST, EOrientation.NORTH.getRightOrientation());
  }

  @Test
  public void shouldReturnLeftIsNorth_whenOrientationIsEast() {
    Assertions.assertEquals(EOrientation.NORTH, EOrientation.EAST.getLeftOrientation());
  }

  @Test
  public void shouldReturnRightIsSouth_whenOrientationIsEast() {
    Assertions.assertEquals(EOrientation.SOUTH, EOrientation.EAST.getRightOrientation());
  }

  @Test
  public void shouldReturnLeftIsEast_whenOrientationIsSouth() {
    Assertions.assertEquals(EOrientation.EAST, EOrientation.SOUTH.getLeftOrientation());
  }

  @Test
  public void shouldReturnRightIsWest_whenOrientationIsSouth() {
    Assertions.assertEquals(EOrientation.WEST, EOrientation.SOUTH.getRightOrientation());
  }

  @Test
  public void shouldReturnLeftIsSouth_whenOrientationIsWest() {
    Assertions.assertEquals(EOrientation.SOUTH, EOrientation.WEST.getLeftOrientation());
  }

  @Test
  public void shouldReturnRightIsNorth_whenOrientationIsWest() {
    Assertions.assertEquals(EOrientation.NORTH, EOrientation.WEST.getRightOrientation());
  }

}