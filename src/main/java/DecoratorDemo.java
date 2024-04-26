import multidecorator.Coffee;
import multidecorator.CoffeeDecoratorBuilder;

public class DecoratorDemo {
    public static void main(String[] args) {
        Coffee myCoffee = CoffeeDecoratorBuilder.buildCoffee();
        System.out.println(myCoffee.getDescription() + " Cost: $" + myCoffee.cost());
    }
}
