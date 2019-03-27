import ua.lviv.iot.repair.manager.RepairManager;
import ua.lviv.iot.repair.model.Drill;
import ua.lviv.iot.repair.model.Fix;
import ua.lviv.iot.repair.model.Hammer;
import ua.lviv.iot.repair.model.RatingInstruments;
import ua.lviv.iot.repair.model.Screws;
import ua.lviv.iot.repair.model.Type;


public class Main {

    public static void main(String[] args) {

        RepairManager manager = new RepairManager();

        Drill drill = new Drill(13, RatingInstruments.HIGH_RATING, Fix.ROSETTE, 3, Type.ELECTRONIC, 4);
        Screws screws = new Screws(150, RatingInstruments.MIDLE_RATING, Fix.ROSETTE, 88, 7);
        Hammer hammer = new Hammer(155, RatingInstruments.LOW_RATING, Fix.DOOR, 5, 7, "Metal");

        manager.toAdd(hammer);
        manager.toAdd(drill);
        manager.toAdd(screws);
        
        RepairManager.sortByPrice(manager.getRepairInstrumentsList() ,true);
        RepairManager.sortByProducer(manager.getRepairInstrumentsList() ,true);

        System.out.println("Sort by Producer: " + manager.getRepairInstrumentsList() +  "\n");

        System.out.println("Sort by price: "  + manager.getRepairInstrumentsList() + "\n");

        System.out.println("Search by rating: " + manager.searchByRating(RatingInstruments.HIGH_RATING).toString() + "\n");
        
        
    }

}