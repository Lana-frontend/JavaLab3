package ua.lviv.iot.repair.model;

public class Hammer extends RepairInstruments {

    private String handleMaterial;
    private int weight;

    public Hammer(int price, RatingInstruments lowRating, Fix rosette, int producer, int weight,
            String handleMaterial) {
        super(price, lowRating, rosette, producer);
        this.weight = weight;
        this.handleMaterial = handleMaterial;
    }
    
    

    public String getHandleMaterial() {
        return handleMaterial;
    }

    public void setHandleMaterial(String handleMaterial) {
        this.handleMaterial = handleMaterial;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Hammer: handleMaterial=" + handleMaterial + ", weight=" + weight;
    }

}
