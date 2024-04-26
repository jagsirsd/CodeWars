package decorator;

public class PremiumSoundDecorator implements ICar {
    ICar car;
    public PremiumSoundDecorator(ICar car) {
        this.car=car;
    }

    @Override
    public double getCost() {
        return car.getCost() + 6000;
    }

    @Override
    public String getDescription() {
        return car.getDescription() + ", Premium Sound System";
    }
}
