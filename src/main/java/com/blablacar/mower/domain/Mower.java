package com.blablacar.mower.domain;

import com.blablacar.mower.enumeration.EOrientation;
import com.blablacar.mower.utils.CoordinatesUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Getter
@Slf4j
@ToString
public class Mower {

  private String id;
  private Coordinates coordinates;
  private EOrientation orientation;
  private Lawn lawn;

  public void turnLeft() {
    orientation = orientation.getLeftOrientation();
  }

  public void turnRight() {
    orientation = orientation.getRightOrientation();
  }

  public void forward() {
    Coordinates nextCoordinates = CoordinatesUtils
        .computeNextCoordinateWithOrientation(coordinates, orientation);

    if (isCoordinatesInside(nextCoordinates)) {
      if (lawn.isPositionUpdatable(coordinates, nextCoordinates)) {
        coordinates = nextCoordinates;
      }
    } else {
      log.warn("Mower id {} next move {} touch the lawn limit {}", id, nextCoordinates,
          lawn.getCoordinatesLimit());
    }
  }

  public boolean isCoordinatesOutside(Coordinates coordinates) {
    return coordinates.getHorizontal() > lawn.getCoordinatesLimit().getHorizontal()
        || coordinates.getVertical() > lawn.getCoordinatesLimit().getVertical()
        || coordinates.getHorizontal() < 0 || coordinates.getVertical() < 0;
  }

  public boolean isCoordinatesInside(Coordinates coordinates) {
    return !isCoordinatesOutside(coordinates);
  }

}
