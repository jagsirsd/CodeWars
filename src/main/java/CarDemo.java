import decorator.*;
import decoratorBook.decorator.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class CarDemo {
    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        jDecorator();
        System.out.println();
        System.out.println();
        bookDecorator();
        System.out.println();
        System.out.println();
    }

    private static void jDecorator() {
        ICar order = new BasicCar();
        order = new SunroofDecorator(order);
        order = new GPSDecorator(order);
        order = new PremiumSoundDecorator(order);

        System.out.println("Order: " + order.getDescription() + ", Cost: " + order.getCost());
    }

    private static void bookDecorator() {
        BookCar order = new BookBasicCar();
        order = new BookSunroofDecorator(order);
        order = new BookGPSDecorator(order);
        order = new BookPremiumSoundDecorator(order);

        System.out.println("Order: " + order.getDescription() + ", Cost: " + order.getCost());
    }

    public static List<Integer> sqInRect(int lng, int wdth) {
        // your code
        int sSide = wdth;
        int lSide = lng;
        if(lng < wdth) {
            sSide = lng;
            lSide = wdth;
        }
        int totalArea = lng * wdth;
        int combinedArea = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = wdth; combinedArea < totalArea; )  {
            combinedArea = i*i;
            if(combinedArea <= totalArea) {
                result.add(i);
            }
            if(i > 1) {
                i--;
            }
        }
        return result;
    }
}
