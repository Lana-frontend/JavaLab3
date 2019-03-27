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
          "pricePerUnit,currency,riskLevel,trend,duration,emitent,owner\n"
          + "300.0,$,LOW,UP,0.0,Ukraine,I\n"
          + "pricePerUnit,currency,riskLevel,trend,duration,emitent,owner,"
          + "company,percentOfCompany\n"
          + "2000.0,₴,MEDIUM,DOWN,100.0,Russia,I,Roshen,0.5\n"
          + "pricePerUnit,currency,riskLevel,trend,duration,emitent,owner,asset,secutity\n"
          + "10.0,€,HIGH,UP,3000.0,Belarus,I,null,Security: \n"
          + "[\n"
          + "  pricePerUnit,currency,riskLevel,trend,duration,emitent,owner\n"
          + "  0.0,null,null,null,0.0,null,null\n"
          + "]\n"
          + "\n"
          + "pricePerUnit,currency,riskLevel,trend,duration,emitent,owner,asset\n"
          + "0.0,$,DANGER,UP,0.0,Moldova,I,house\n"
          + "pricePerUnit,currency,riskLevel,trend,duration,emitent,owner\n"
          + "20.0,$,LOW,DOWN,10.0,Ukraine,I",lines);
    } finally {
      System.out.println();
    }
  }

}