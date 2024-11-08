package coffeemachine;

public class CoffeeMachine {

    private int coffee;
    private int water;
    private int milk;
    private int clearing;
    static final int volumeCoffee = 500;
    static final int volumeWater = 1000;
    static final int volumeMilk = 1000;

    public CoffeeMachine(int coffee, int water, int milk) {
        this.coffee = coffee;
        this.water = water;
        this.milk = milk;
        this.clearing = 0;
    }

    public int getCoffee() {
        return coffee;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getClearing() {
        return clearing;
    }

    public void setClearing(int clearing) {
        this.clearing = clearing;
    }

}
