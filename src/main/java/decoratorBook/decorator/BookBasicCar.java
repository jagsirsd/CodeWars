package decoratorBook.decorator;

public class BookBasicCar extends BookCar {
    @Override
    public double getCost() {
        return 130_000;
    }

    @Override
    public String getDescription() {
        return "Book Basic Car";
    }
}
