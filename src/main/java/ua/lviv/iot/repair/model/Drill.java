package ua.lviv.iot.repair.model;

public class Drill extends RepairInstruments {

    private Type drillType;
    private double power;

    public Drill(int price, RatingInstruments lowRating, Fix rosette, int producer, Type electronic, int j) {
        super(price, lowRating, rosette, producer);
        this.drillType = electronic;
        this.power = j;
    }

    public Type getDrillType() {
        return drillType;
    }

    public void setDrillType(Type drillType) {
        this.drillType = drillType;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "Drill: drillType=" + drillType + ", power=" + power ;
    }

}
