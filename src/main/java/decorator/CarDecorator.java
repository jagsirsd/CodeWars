package decorator;

public class CarDecorator implements ICar {
    ICar car;
    public CarDecorator(ICar car) {
        this.car=car;
    }

    @Override
    public double getCost() {
        return car.getCost();
    }

    @Override
    public String getDescription() {
        return car.getDescription();
    }
}
