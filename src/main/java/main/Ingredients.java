package main;

public class Ingredients {

    private int coffee;
    private int water;
    private int milk;

    public Ingredients(int coffee, int water, int milk) {
        this.coffee = coffee;
        this.water = water;
        this.milk = milk;
    }
    public int getCoffee() {
        return coffee;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public void checkCoffee() {
        System.out.println("ОСТАТОК\nБокс для кофе: " + coffee);
    }

    public void checkWater() {
        System.out.println("ОСТАТОК\nЕмкомть для воды: " + water);
    }

    public void checkMilk() {
        System.out.println("ОСТАТОК\nЕмкомть для молока: " + milk);
    }


}
