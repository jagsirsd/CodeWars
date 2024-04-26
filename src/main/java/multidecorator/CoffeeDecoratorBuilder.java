package multidecorator;

import java.util.Arrays;
import java.util.Comparator;

public class CoffeeDecoratorBuilder {
    public static Coffee buildCoffee() {
        Coffee coffee = new SimpleCoffee();
        CoffeeDecorator[] decorators = new CoffeeDecorator[]{
                new MilkDecorator(coffee, 1),
                new SugarDecorator(coffee, 2)  // Higher priority, applied first if condition is true
        };

        // Sort decorators by priority
        Arrays.sort(decorators, Comparator.comparingInt(CoffeeDecorator::getPriority).reversed());

        for (CoffeeDecorator decorator : decorators) {
            if (decorator.apply()) {
                coffee = decorator;
            }
        }

        return coffee;
    }
}
