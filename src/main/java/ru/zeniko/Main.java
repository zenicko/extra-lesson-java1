package ru.zeniko;

import static java.lang.String.format;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car);

        Car car1 = new Car(2.13f, 70, Boby.sedan);
        System.out.println(car1);

        Car car2 = new Car(new Car(4.13f, 175, Boby.crossover));
        System.out.println(car2);

        System.out.println("\n+++++++++++++++++++++");
        Car.Drawing.printConstantsCar();
        System.out.println("\nCreate car with values which are bigger than max values");
        Car car3 = new Car(new Car(99.13f, 5000, Boby.crossover));

        System.out.println("\nChanging max values");
        Car.Drawing.setMaxEngineVolume(100.13f);
        Car.Drawing.setMaxPower(10000);
        Car.Drawing.printConstantsCar();
        Car car4 = new Car(new Car(99.13f, 5000, Boby.crossover));
        System.out.println(car4);
        System.out.println(format("The Max distance is %s km.", car4.calculateDistance()));

    }
}
