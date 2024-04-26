package decoratorBook.decorator;

public class BookSunroofDecorator extends BookCarDecorator {

    public BookSunroofDecorator(BookCar car) {
        super(car);
    }

    @Override
    public double getCost() {
        return super.getCost() + 15000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", B Sunroof";
    }
}
