package multidecorator;



// Abstract Decorator
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;
    protected int priority;

    public CoffeeDecorator(Coffee coffee, int priority) {
        this.decoratedCoffee = coffee;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }

    abstract public boolean apply();
}
