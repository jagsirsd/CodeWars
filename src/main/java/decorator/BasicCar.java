package decorator;

public class BasicCar implements ICar {
    @Override
    public double getCost() {
        return 30_000;
    }

    @Override
    public String getDescription() {
        return "Basic Car";
    }
}
