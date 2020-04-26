package com.blablacar.mower;

import com.blablacar.mower.domain.Mower;
import com.blablacar.mower.parser.MowerFileParser;
import com.blablacar.mower.processor.MowerCommandsProcessor;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.junit.jupiter.api.Assertions;

public class BlaBlaCarMowerApplication {

  public static void main(String[] args)
      throws IOException, InterruptedException, ExecutionException {

    MowerFileParser parser = new MowerFileParser();
    String fileName = System.getProperty("fileName");
    Assertions.assertNotNull(fileName, "fileName must be specified");

    String poolSize = System.getProperty("poolSize");
    int threadPoolSize = Integer.parseInt(poolSize != null ? poolSize : "5");
    ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

    List<MowerCommandsProcessor> processors = parser.parseFileToProcessor(fileName);
    List<Future<Mower>> result = executorService.invokeAll(processors);

    for (Future<Mower> mowerFuture : result) {
      Mower mower = mowerFuture.get();
      System.out.println(
          mower.getCoordinates().getHorizontal() + " "
              + mower.getCoordinates().getVertical() + " "
              + mower.getOrientation());
    }
  }

}
