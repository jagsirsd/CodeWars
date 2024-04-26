package decoratorBook.decorator;

public class BookGPSDecorator extends BookCarDecorator {

    public BookGPSDecorator(BookCar car) {
        super(car);
    }

    @Override
    public double getCost() {
        return super.getCost() + 12500;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", B GPS";
    }
}
