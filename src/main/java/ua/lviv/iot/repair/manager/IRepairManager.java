package ua.lviv.iot.repair.manager;

import ua.lviv.iot.repair.model.RatingInstruments;
import ua.lviv.iot.repair.model.RepairInstruments;

import java.util.List;

public interface IRepairManager {

    List<RepairInstruments> sortByProducer(boolean ascending);

    List<RepairInstruments> searchByRating(RatingInstruments rating);

    List<RepairInstruments> sortByPrice(boolean ascending);

}
