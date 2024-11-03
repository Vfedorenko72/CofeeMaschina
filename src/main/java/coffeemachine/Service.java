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
        int cenAdd = volumeCoffee - coffee;
        String msgAddCoffee = "Введите вес добавляемого кофе в граммах";
        String coffeeDoesntFit = "в данный момент вы можете добавить не более " + cenAdd + " грамм кофе."
        String
        while (true) {
            Decorator.border(msgAddCoffee);
            int addCoffee = sc.nextInt();
            if (addCoffee >= volumeCoffee - coffee) {
                Decorator.border(coffeeDoesntFit);
            } else {

            }

        }





    }
}
