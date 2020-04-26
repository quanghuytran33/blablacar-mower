package com.blablacar.mower.processor;

import com.blablacar.mower.domain.Mower;
import com.blablacar.mower.enumeration.EMowerCommand;
import java.util.List;

public class MowerCommandsProcessor {

  public void processMowerCommands(Mower mower, List<EMowerCommand> commands) {
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
  }

}
