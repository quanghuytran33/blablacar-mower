package com.blablacar.mower.utils;

import com.blablacar.mower.enumeration.EMowerCommand;

public class EMowerCommandTestUtils {

  public static EMowerCommand convertCharToCommand(String command) {
    switch (command) {
      case "L":
        return EMowerCommand.TURN_LEFT;
      case "R":
        return EMowerCommand.TURN_RIGHT;
      case "F":
        return EMowerCommand.FORWARD;
      default:
        throw new IllegalArgumentException();
    }
  }

}
