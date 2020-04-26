package com.blablacar.mower.domain;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Getter;

public class Lawn {

  @Getter
  private final Coordinates coordinatesLimit;
  private final Set<Coordinates> occupiedPosition;

  public Lawn(Coordinates coordinatesLimit) {
    this.coordinatesLimit = coordinatesLimit;
    //It seems that it's unnecessary to use ConcurrentHashMap because it's called inside synchronized block
    this.occupiedPosition = ConcurrentHashMap.newKeySet();
  }

  public synchronized void insertOccupiedPosition(final Coordinates coordinates) {
    if (isPositionNotOccupied(coordinates)) {
      occupiedPosition.add(coordinates);
    } else {
      throw new IllegalArgumentException("Position " + coordinates + " already occupied");
    }
  }

  public synchronized boolean isPositionUpdatable(final Coordinates previousCoordinates,
      final Coordinates nextCoordinates) {
    if (isPositionNotOccupied(nextCoordinates)) {
      occupiedPosition.add(nextCoordinates);
      occupiedPosition.remove(previousCoordinates);
      return true;
    }
    return false;
  }

  private boolean isPositionOccupied(final Coordinates coordinates) {
    return occupiedPosition.contains(coordinates);
  }

  private boolean isPositionNotOccupied(final Coordinates coordinates) {
    return !isPositionOccupied(coordinates);
  }
}
