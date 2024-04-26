package decorator;

public class SunroofDecorator implements ICar {
    ICar car;
    public SunroofDecorator(ICar car) {
        this.car=car;
    }

    @Override
    public double getCost() {
        return car.getCost() + 5000;
    }

    @Override
    public String getDescription() {
        return car.getDescription() + ", Sunroof";
    }
}
