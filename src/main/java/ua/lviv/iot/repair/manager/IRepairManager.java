package ua.lviv.iot.repair.manager;

import ua.lviv.iot.repair.model.RatingInstruments;
import ua.lviv.iot.repair.model.RepairInstruments;

import java.util.List;

public interface IRepairManager {

    public List<RepairInstruments> sortByProducer(boolean ascending);

    public List<RepairInstruments> searchByRating(RatingInstruments rating);

    public List<RepairInstruments> sortByPrice(boolean ascending);

}
