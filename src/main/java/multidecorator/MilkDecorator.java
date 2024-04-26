package multidecorator;


// Concrete Decorator A
public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee, int priority) {
        super(coffee, priority);
    }

    @Override
    public boolean apply() {
        // Check some conditions, e.g., coffee cost is under a certain amount
        return decoratedCoffee.cost() < 2.0;
    }

    @Override
    public String getDescription() {
        return apply() ? super.getDescription() + ", with milk" : super.getDescription();
    }

    @Override
    public double cost() {
        return apply() ? super.cost() + 0.5 : super.cost();
    }
}
