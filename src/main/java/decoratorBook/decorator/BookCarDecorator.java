package decoratorBook.decorator;

abstract public class BookCarDecorator extends BookCar {
    BookCar car;
    public BookCarDecorator(BookCar car) {
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
