package com.blablacar.mower.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.blablacar.mower.enumeration.EOrientation;
import org.junit.jupiter.api.Test;

class MowerTest {

  public Coordinates coordinates2x2() {
    return new Coordinates(2, 2);
  }

  public Coordinates coordinates0x0() {
    return new Coordinates(0, 0);
  }

  public Lawn law5x5() {
    return new Lawn(coordinates2x2());
  }

  @Test
  public void shouldnChangeCoordinate_whenNextHorizontalExceedLimit() {
    Mower mower = new Mower("test", coordinates2x2(), EOrientation.EAST, law5x5());
    mower.forward();
    assertEquals(coordinates2x2(), mower.getCoordinates());
  }

  @Test
  public void shouldnChangeCoordinate_whenNextVerticalExceedLimit() {
    Mower mower = new Mower("test", coordinates2x2(), EOrientation.NORTH, law5x5());
    mower.forward();
    assertEquals(coordinates2x2(), mower.getCoordinates());
  }

  @Test
  public void shouldnChangeCoordinate_whenNextHorizontalIsNegative() {
    Mower mower = new Mower("test", coordinates0x0(), EOrientation.WEST, law5x5());
    mower.forward();
    assertEquals(coordinates0x0(), mower.getCoordinates());
  }

  @Test
  public void shouldnChangeCoordinate_whenNextVerticalIsNegative() {
    Mower mower = new Mower("test", coordinates0x0(), EOrientation.SOUTH, law5x5());
    mower.forward();
    assertEquals(coordinates0x0(), mower.getCoordinates());
  }

  @Test
  public void shouldChangeCoordinate_whenNextVerticalBelowThanLimit() {
    Mower mower = new Mower("test", coordinates0x0(), EOrientation.NORTH, law5x5());
    mower.forward();
    assertEquals(new Coordinates(0, 1), mower.getCoordinates());
  }

  @Test
  public void shouldChangeCoordinate_whenNextHorizontalBelowThanLimit() {
    Mower mower = new Mower("test", coordinates0x0(), EOrientation.EAST, law5x5());
    mower.forward();
    assertEquals(new Coordinates(1, 0), mower.getCoordinates());
  }


}