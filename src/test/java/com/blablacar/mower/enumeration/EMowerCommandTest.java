package com.blablacar.mower.enumeration;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EMowerCommandTest {

  @Test
  public void shouldReturnListOfCommandsLeftRightForward_whenStringIsLRF() {
    List<EMowerCommand> commands = EMowerCommand.convertStringToListCommand("LRF");
    Assertions.assertEquals(EMowerCommand.TURN_LEFT, commands.get(0));
    Assertions.assertEquals(EMowerCommand.TURN_RIGHT, commands.get(1));
    Assertions.assertEquals(EMowerCommand.FORWARD, commands.get(2));
  }

}