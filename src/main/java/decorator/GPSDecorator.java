package decorator;

public class GPSDecorator implements ICar {
    ICar car;
    public GPSDecorator(ICar car) {
        this.car=car;
    }

    @Override
    public double getCost() {
        return car.getCost() + 2500;
    }

    @Override
    public String getDescription() {
        return car.getDescription() + ", GPS";
    }
}
