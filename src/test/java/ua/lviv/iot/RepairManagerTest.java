package ua.lviv.iot;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.repair.manager.RepairManager;
import ua.lviv.iot.repair.model.*;

public class RepairManagerTest {
    
    private List<RepairInstruments> instruments;
    
    private RepairManager iRepairManager;
    
  
    
    @BeforeEach
    public void beforeEach() {
        instruments = new ArrayList<>();
        instruments.add(new Drill(300, RatingInstruments.HIGH_RATING , Fix.FLOOR , 30 , Type.ELECTRONIC , 56));
        instruments.add(new Hammer(400, RatingInstruments.LOW_RATING , Fix.DOOR , 76 , 6 , "dfd"));
        instruments.add(new Screws(30, RatingInstruments.MIDLE_RATING , Fix.ROSETTE , 36 , 56));
        instruments.add(new RepairInstruments(300, RatingInstruments.HIGH_RATING , Fix.DOOR , 36));
        iRepairManager = new RepairManager(instruments);
    }
    
    @Test
    void testSortPriceAscending() {
        RepairManager.sortByPrice(instruments , true);
        Assertions.assertEquals(300, instruments.get(2).getPrice());
    }
    
    @Test
    void testSortPriceAscendingR() {
        RepairManager.sortByPrice(instruments , false);
        Assertions.assertEquals(300, instruments.get(2).getPrice());
    }
    
    @Test
    void testSortProducerAscending() {
        RepairManager.sortByProducer(instruments , true);
        Assertions.assertEquals(36, instruments.get(1).getProducer());
    }
    
    @Test
    void testSortProducerAscendingR() {
        RepairManager.sortByProducer(instruments , false);
        Assertions.assertEquals(36, instruments.get(2).getProducer());
    }
    
    @Test
    void testFilterByRating() {
        Assertions.assertEquals(2, iRepairManager.searchByRating(RatingInstruments.HIGH_RATING).size());
        Assertions.assertEquals(1, iRepairManager.searchByRating(RatingInstruments.LOW_RATING).size());
        Assertions.assertEquals(1, iRepairManager.searchByRating(RatingInstruments.MIDLE_RATING).size());
    }
    
  
}


