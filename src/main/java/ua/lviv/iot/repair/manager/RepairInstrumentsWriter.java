package ua.lviv.iot.repair.manager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import ua.lviv.iot.repair.model.RepairInstruments;;

public class RepairInstrumentsWriter {

  public static void writeToFile(List<RepairInstruments> repairs)
      throws FileNotFoundException, IOException {
    File myFile = new File("out.csv");
    try (FileOutputStream fos = new FileOutputStream(myFile);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bufWriter = new BufferedWriter(osw);) {
      for (RepairInstruments repair:repairs) {
        bufWriter.write(
            repair.getHeaders() + "\n"
            + repair.toCSV() + "\n"
        );
      }
    } finally {
      System.out.println();
    }
  }
} 