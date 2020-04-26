package com.blablacar.mower.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.blablacar.mower.enumeration.EMowerCommand;
import com.blablacar.mower.enumeration.EOrientation;
import com.blablacar.mower.processor.MowerCommandsProcessor;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

class MowerFileParserTest {

  MowerFileParser parser = new MowerFileParser();

  @Test
  public void shouldReturnListProcessors_whenParseFile() throws IOException {
    List<MowerCommandsProcessor> processorList = parser
        .parseFileToProcessor("src/test/resources/BlaBlaCarMower.txt");

    MowerCommandsProcessor processor1 = processorList.get(0);
    assertEquals(1, processor1.getMower().getCoordinates().getHorizontal());
    assertEquals(2, processor1.getMower().getCoordinates().getVertical());
    assertEquals(EOrientation.NORTH, processor1.getMower().getOrientation());
    assertEquals(EMowerCommand.convertStringToListCommand("LFLFLFLFF"),
        processor1.getCommands());

    MowerCommandsProcessor processor2 = processorList.get(1);
    assertEquals(3, processor2.getMower().getCoordinates().getHorizontal());
    assertEquals(3, processor2.getMower().getCoordinates().getVertical());
    assertEquals(EOrientation.EAST, processor2.getMower().getOrientation());
    assertEquals(EMowerCommand.convertStringToListCommand("FFRFFRFRRF"),
        processor2.getCommands());
  }

}