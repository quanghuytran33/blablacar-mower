package com.blablacar.mower.processor;

import static com.blablacar.mower.utils.EMowerCommandUtils.convertStringToListCommand;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.blablacar.mower.domain.Coordinates;
import com.blablacar.mower.domain.Lawn;
import com.blablacar.mower.domain.Mower;
import com.blablacar.mower.enumeration.EOrientation;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.jupiter.api.Test;

public class MowerActionsProcessorConcurrentTest {

  ExecutorService executorService = Executors.newWorkStealingPool();

  @Test
  public void shouldnHaveMoveDiscarded_when2MowersDontTakeSamePlace()
      throws InterruptedException, ExecutionException {
    Lawn lawn = new Lawn(new Coordinates(5, 5));
    Mower mower1 = new Mower("Mower 1", new Coordinates(1, 2), EOrientation.NORTH, lawn);
    Mower mower2 = new Mower("Mower 2", new Coordinates(3, 3), EOrientation.EAST, lawn);

    List<Future<Mower>> futures = executorService.invokeAll(
        Arrays.asList(new MowerCommandsProcessor(mower1, convertStringToListCommand("LFLFLFLFF")),
            new MowerCommandsProcessor(mower2, convertStringToListCommand("FFRFFRFRRF"))));

    mower1 = futures.get(0).get();
    assertEquals(1, mower1.getCoordinates().getHorizontal());
    assertEquals(3, mower1.getCoordinates().getVertical());
    assertEquals(EOrientation.NORTH, mower1.getOrientation());

    mower2 = futures.get(1).get();
    assertEquals(5, mower2.getCoordinates().getHorizontal());
    assertEquals(1, mower2.getCoordinates().getVertical());
    assertEquals(EOrientation.EAST, mower2.getOrientation());
  }

//  @Test
//  public void shouldHaveMoveDiscarded_when2MowersTakeSamePlace()
//      throws InterruptedException, ExecutionException {
//    Lawn lawn = new Lawn(new Coordinates(5, 5));
//    Mower mower1 = new Mower("Mower 1", new Coordinates(1, 2), EOrientation.NORTH, lawn);
//    Mower mower2 = new Mower("Mower 2", new Coordinates(1, 3), EOrientation.NORTH, lawn);
//
//    List<Future<Mower>> futures = executorService.invokeAll(
//        Arrays.asList(new MowerCommandsProcessor(mower1, convertStringToListCommand("FFF")),
//            new MowerCommandsProcessor(mower2, convertStringToListCommand("FFF"))));
//
//    mower1 = futures.get(0).get();
//    assertEquals(1, mower1.getCoordinates().getHorizontal());
//    assertEquals(4, mower1.getCoordinates().getVertical());
//    assertEquals(EOrientation.NORTH, mower1.getOrientation());
//
//    mower2 = futures.get(1).get();
//    assertEquals(1, mower2.getCoordinates().getHorizontal());
//    assertEquals(5, mower2.getCoordinates().getVertical());
//    assertEquals(EOrientation.NORTH, mower2.getOrientation());
//  }

}
