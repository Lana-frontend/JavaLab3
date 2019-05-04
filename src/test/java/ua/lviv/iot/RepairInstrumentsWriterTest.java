package ua.lviv.iot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.repair.manager.RepairInstrumentsWriter;
import ua.lviv.iot.repair.model.*;

class repairsWriterTest {

  private List<RepairInstruments> repairs;

  public void setUp() {
    repairs = new ArrayList<>();
  }
  
  @BeforeEach
  public void beforeEach() {
    repairs = new ArrayList<>();
    repairs.add(new RepairInstruments(300, RatingInstruments.HIGH_RATING , Fix.DOOR , 9));
    repairs.add(new Hammer(155, RatingInstruments.LOW_RATING, Fix.DOOR, 5, 7, "Metal"));
    repairs.add(new Drill(13, RatingInstruments.HIGH_RATING, Fix.ROSETTE, 3, Type.ELECTRONIC , 6));
    repairs.add(new Screws(150, RatingInstruments.MIDLE_RATING, Fix.ROSETTE, 88, 7));
    
  }
  
  @Test
  public void testWriteToFile() throws FileNotFoundException, IOException {
    RepairInstrumentsWriter.writeToFile(repairs);
    File myFile = new File("out.csv");
    try (FileInputStream fis = new FileInputStream(myFile);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader bufReader = new BufferedReader(isr);) {
      String line = null;
      String lines = "";
      while ((line = bufReader.readLine()) != null) {
        lines += line + "\n";
      }
      lines = lines.substring(0, lines.length() - 1);
      System.out.println(lines);
      Assertions.assertEquals(
        
           "price,rating,repair,producer\n" + 
          "300,HIGH_RATING,DOOR,9\n" + 
          "price,rating,repair,producer\n" + 
          "155,LOW_RATING,DOOR,5\n" + 
          "price,rating,repair,producer,drillType,power\n" + 
          "13,HIGH_RATING,ROSETTE,3,ELECTRONIC,6.0\n" + 
          "price,rating,repair,producer,size\n" + 
          "150,MIDLE_RATING,ROSETTE,88,88",lines);
    } finally {
      System.out.println();
    }
  }

}