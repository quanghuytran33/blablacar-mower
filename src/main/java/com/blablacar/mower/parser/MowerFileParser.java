package com.blablacar.mower.parser;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.blablacar.mower.domain.Coordinates;
import com.blablacar.mower.domain.Lawn;
import com.blablacar.mower.domain.Mower;
import com.blablacar.mower.enumeration.EMowerCommand;
import com.blablacar.mower.enumeration.EOrientation;
import com.blablacar.mower.processor.MowerCommandsProcessor;
import com.blablacar.mower.utils.EMowerCommandUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MowerFileParser {

  public List<MowerCommandsProcessor> parseFileToProcessor(String fileName) throws IOException {

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      String line = reader.readLine();
      String[] coordinates = line.split(" ");
      Lawn lawn = new Lawn(new Coordinates(coordinates[0], coordinates[1]));

      int indexLine = 2;
      List<Mower> mowers = new ArrayList<>();
      List<List<EMowerCommand>> mowersCommands = new ArrayList<>();

      while (true) {
        line = reader.readLine();
        if (line == null) {
          break;
        }
        if (indexLine % 2 == 0) {
          String[] coordinatesAndOrientation = line.split(" ");
          mowers.add(new Mower(String.valueOf(indexLine / 2),
              new Coordinates(coordinatesAndOrientation[0], coordinatesAndOrientation[1]),
              EOrientation.convertSymbolToOrientation(coordinatesAndOrientation[2]), lawn));
        } else {
          mowersCommands.add(EMowerCommandUtils.convertStringToListCommand(line));
        }
        indexLine++;
      }
      assertEquals(mowers.size(), mowersCommands.size(),
          "Mower's list must have same size with mowers commands list");
      return IntStream.range(0, mowers.size())
          .mapToObj(i -> new MowerCommandsProcessor(mowers.get(i), mowersCommands.get(i)))
          .collect(toList());
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    }
  }

}
