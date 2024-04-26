package multidecorator;


// Concrete Decorator B
public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee, int priority) {
        super(coffee, priority);
    }

    @Override
    public boolean apply() {
        // Check other conditions, perhaps based on description or other state
        return !decoratedCoffee.getDescription().contains("milk");
    }

    @Override
    public String getDescription() {
        return apply() ? super.getDescription() + ", with sugar" : super.getDescription();
    }

    @Override
    public double cost() {
        return apply() ? super.cost() + 0.2 : super.cost();
    }
}
