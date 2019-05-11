package ua.lviv.iot.repair.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RepairInstruments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private int price;

    @Column
    private RatingInstruments rating;

    @Column
    private Fix repair;

    @Column
    private int producer;

    public RepairInstruments() {
        super();
    }

    public RepairInstruments(int price, RatingInstruments rating, Fix repair, int producer) {
         
        this.price = price;
        this.rating = rating;
        this.repair = repair;
        this.producer = producer;
    }

    public String getHeaders() {
        return "price" + "," + "rating" + "," + "repair" + "," + "producer";
    }

    public String toCSV() {
        return this.price + "," + this.rating + "," + this.repair + "," + this.producer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
