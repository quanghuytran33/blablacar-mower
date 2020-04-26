package com.blablacar.mower.enumeration;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

public enum EMowerCommand {

  TURN_LEFT,
  TURN_RIGHT,
  FORWARD;

  public static EMowerCommand convertStringToCommand(String command) {
    switch (command) {
      case "L":
        return TURN_LEFT;
      case "R":
        return TURN_RIGHT;
      case "F":
        return FORWARD;
      default:
        throw new IllegalArgumentException("Command not supported: " + command);
    }
  }

  public static List<EMowerCommand> convertStringToListCommand(String commands) {
    return Stream.of(commands.split(""))
        .map(EMowerCommand::convertStringToCommand)
        .collect(toList());
  }
}
