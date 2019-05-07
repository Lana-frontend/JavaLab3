package ua.lviv.iot.repair.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "hammer")
public class Hammer extends RepairInstruments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "handleMaterial")
    private String handleMaterial;
    
    @Column(name = "weight")
    private int weight;
    
    public Hammer() {
        super();
    }
    
    public Hammer(String handleMaterial , int weight) {
        this.handleMaterial = handleMaterial;
        this.weight = weight;
        
    }

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
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Hammer: handleMaterial=" + handleMaterial + ", weight=" + weight;
    }

}
