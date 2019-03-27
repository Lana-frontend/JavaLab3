package ua.lviv.iot.repair.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ua.lviv.iot.repair.model.RatingInstruments;
import ua.lviv.iot.repair.model.RepairInstruments;

public class RepairManager {
 
    private List<RepairInstruments> repairInstrumentsList = new ArrayList<>();

    public void toAdd(RepairInstruments repairInstruments) {
        repairInstrumentsList.add(repairInstruments);
    }

    public RepairManager() {
    }

    public RepairManager(List<RepairInstruments> repairInstrumentsList) {
        this.repairInstrumentsList = repairInstrumentsList;
    }

    public static void sortByProducer(List<RepairInstruments> instruments, boolean ascending) {
        if (ascending) {
            Collections.sort(instruments, Comparator.comparing(RepairInstruments::getProducer).reversed());
        } else {
            Collections.sort(instruments, Comparator.comparing(RepairInstruments::getProducer));
        }
    }

    public List<RepairInstruments> searchByRating(RatingInstruments rating) {
        return repairInstrumentsList.stream().filter(vessel -> vessel.getRating() == rating)
                .collect(Collectors.toList());

    }
    

    public static void sortByPrice(List<RepairInstruments> instruments, boolean ascending) {
        if (ascending) {
            Collections.sort(instruments, Comparator.comparing(RepairInstruments::getPrice).reversed());
        } else {
            Collections.sort(instruments, Comparator.comparing(RepairInstruments::getPrice));
        }

    }

    public List<RepairInstruments> getRepairInstrumentsList() {
        return repairInstrumentsList;
    }

    public void setRepairInstrumentsList(List<RepairInstruments> repairInstrumentsList) {
        this.repairInstrumentsList = repairInstrumentsList;
    }

}
