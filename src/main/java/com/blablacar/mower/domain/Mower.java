package com.blablacar.mower.domain;

import com.blablacar.mower.enumeration.EOrientation;
import com.blablacar.mower.utils.CoordinatesUtils;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@ToString
public class Mower {

  private final String id;
  private Coordinates coordinates;
  private EOrientation orientation;
  private final Lawn lawn;

  public Mower(String id, Coordinates coordinates, EOrientation orientation, Lawn lawn) {
    this.id = id;
    this.coordinates = coordinates;
    this.orientation = orientation;
    this.lawn = lawn;
    lawn.insertOccupiedPosition(coordinates);
  }

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
      } else {
        log.warn("Mower id {} forward discard because position {} was occupied ", id,
            nextCoordinates);
      }
    } else {
      log.warn("Mower id {} next position {}, {} exceed lawn limit {}", id, nextCoordinates,
          orientation,
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
