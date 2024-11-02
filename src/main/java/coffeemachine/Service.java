package coffeemachine;

import java.util.Scanner;

public class Service {

    private Scanner sc;
    private int coffee;
    private int water;
    private int milk;
    private static final int volumeCoffee = 500;
    private static final int volumeWater = 1000;
    private static final int volumeMilk = 500;

    public Service(Scanner sc, int coffee, int water, int milk) {
        this.sc = sc;
        this.coffee = coffee;
        this.water = water;
        this.milk = milk;
    }

    public int canAcceptCoffee() {

    }


    public void addCoffee(int qty) {
        String addCoffee = "Введите вес добавляемого кофе в граммах";

        if (sc.nextInt() )
    }
}
