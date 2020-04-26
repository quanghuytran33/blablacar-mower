package com.blablacar.mower.processor;

import com.blablacar.mower.domain.Mower;
import com.blablacar.mower.enumeration.EMowerCommand;
import java.util.List;
import java.util.concurrent.Callable;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class MowerCommandsProcessor implements Callable<Mower> {

  private final Mower mower;
  private final List<EMowerCommand> commands;

  public Mower call() {
    for (EMowerCommand command : commands) {
      switch (command) {
        case TURN_LEFT:
          mower.turnLeft();
          break;
        case TURN_RIGHT:
          mower.turnRight();
          break;
        case FORWARD:
          mower.forward();
          break;
        default:
          throw new IllegalArgumentException();
      }
    }
    log.info("The final position of Mower {} : {} {} {}",
        mower.getId(),
        mower.getCoordinates().getHorizontal(),
        mower.getCoordinates().getVertical(),
        mower.getOrientation());
    return mower;
  }

}
