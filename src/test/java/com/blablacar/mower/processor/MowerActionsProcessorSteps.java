package com.blablacar.mower.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.blablacar.mower.domain.Coordinates;
import com.blablacar.mower.domain.Lawn;
import com.blablacar.mower.domain.Mower;
import com.blablacar.mower.enumeration.EMowerCommand;
import com.blablacar.mower.utils.EMowerCommandTestUtils;
import com.blablacar.mower.utils.OrientationTestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MowerActionsProcessorSteps {

  MowerCommandsProcessor mowerCommandsProcessor = new MowerCommandsProcessor();
  Lawn lawn;
  Mower mower;
  List<EMowerCommand> mowerCommands;
  Coordinates finalCoordinates;

  @Given("the lawn have horizontal {int} and vertical {int}")
  public void theLawnHaveHorizontalAndVertical(int lawnHorizontal, int lawnVertical) {
    lawn = new Lawn(new Coordinates(lawnHorizontal, lawnVertical));
  }

  @Given("the mower start at {int} {int} {word}")
  public void theMowerStartAt(int mowerHorizontal, int mowerVertical, String orientation) {
    mower = new Mower("", new Coordinates(mowerHorizontal, mowerVertical),
        OrientationTestUtils.convertCharToOrientation(orientation), lawn);
  }

  @Given("list of commands is: {word}")
  public void listOfCommands(String commands) {
    mowerCommands = Stream.of(commands.split("")).map(EMowerCommandTestUtils::convertCharToCommand)
        .collect(
            Collectors.toList());
  }

  @When("process the actions")
  public void processTheActions() {
    mowerCommandsProcessor.processMowerCommands(mower, mowerCommands);
  }

  @Then("the final position is: {int} {int} {word}")
  public void theFinalPositionIs(int mowerHorizontal, int mowerVertical, String orientation) {
    assertEquals(mowerHorizontal, mower.getCoordinates().getHorizontal());
    assertEquals(mowerVertical, mower.getCoordinates().getVertical());
    assertEquals(OrientationTestUtils.convertCharToOrientation(orientation),
        mower.getOrientation());
  }

}
