package decoratorBook.decorator;

public class BookPremiumSoundDecorator extends BookCarDecorator {
    public BookPremiumSoundDecorator(BookCar car) {
        super(car);
    }

    @Override
    public double getCost() {
        return super.getCost() + 16000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", B Premium Sound System";
    }
}
