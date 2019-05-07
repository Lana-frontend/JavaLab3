package ua.lviv.iot.repair.model;




public class Screws extends RepairInstruments {

    private int size;

    public Screws(int price, RatingInstruments lowRating, Fix rosette, int producer) {

    }

    public Screws(int price, RatingInstruments rating, Fix repair, int producer, int size) {
        super(price, rating, repair, producer);
        this.size = producer;
    }
    
    public String getHeaders() {
        return super.getHeaders() + ","
                + "size";
    }

    public String toCSV() {
        return super.toCSV() + ","
                + this.size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {

        return "Screws: size=" + size;
    }

}
