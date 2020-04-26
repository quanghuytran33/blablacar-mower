package com.blablacar.mower.domain;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Getter;

public class Lawn {

  @Getter
  private Coordinates coordinatesLimit;
  private Set<Coordinates> occupiedPosition;

  public Lawn(Coordinates coordinatesLimit) {
    this.coordinatesLimit = coordinatesLimit;
    //It's useful to use ConcurrentHashMap here?
    this.occupiedPosition = ConcurrentHashMap.newKeySet();
  }

  public synchronized boolean isPositionUpdatable(Coordinates previousCoordinates,
      Coordinates nextCoordinates) {
    if (isPositionNotOccupied(nextCoordinates)) {
      occupiedPosition.remove(previousCoordinates);
      occupiedPosition.add(nextCoordinates);
      return true;
    }
    return false;
  }

  private boolean isPositionOccupied(Coordinates coordinates) {
    return occupiedPosition.contains(coordinates);
  }

  private boolean isPositionNotOccupied(Coordinates coordinates) {
    return !isPositionOccupied(coordinates);
  }
}
