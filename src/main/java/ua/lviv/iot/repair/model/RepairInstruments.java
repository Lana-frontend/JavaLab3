package ua.lviv.iot.repair.model;

public class RepairInstruments {

    private int price;
    private RatingInstruments rating;
    private Fix repair;
    private int producer;

    public RepairInstruments() {

    }

    public RepairInstruments(int price, RatingInstruments rating, Fix repair, int producer) {
        this.price = price;
        this.rating = rating;
        this.repair = repair;
        this.producer = producer;
    }
    
    public String getHeaders() {
        return "price" + ","
                + "rating" + ","
                + "repair" + ","
                + "producer";
    }

    public String toCSV() {
        return this.price + ","
                + this.rating + ","
                + this.repair + ","
                + this.producer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public RatingInstruments getRating() {
        return rating;
    }

    public void setRating(RatingInstruments rating) {
        this.rating = rating;
    }

    public Fix getRepair() {
        return repair;
    }

    public void setRepair(Fix repair) {
        this.repair = repair;
    }

    public int getProducer() {
        return producer;
    }

    public void setProducer(int producer) {
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "RepairInstruments [price=" + price + ", rating=" + rating + ", repair=" + repair + ", producer="
                + producer + "]";
    }

}
