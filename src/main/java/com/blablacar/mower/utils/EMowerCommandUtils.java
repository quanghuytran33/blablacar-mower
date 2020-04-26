package com.blablacar.mower.utils;

import static java.util.stream.Collectors.toList;

import com.blablacar.mower.enumeration.EMowerCommand;
import java.util.List;
import java.util.stream.Stream;

public class EMowerCommandUtils {

  public static List<EMowerCommand> convertStringToListCommand(String commands) {
    return Stream.of(commands.split(""))
        .map(EMowerCommandUtils::convertStringToCommand)
        .collect(toList());
  }

  public static EMowerCommand convertStringToCommand(String command) {
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
