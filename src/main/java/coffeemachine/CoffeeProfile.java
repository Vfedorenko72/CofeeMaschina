package coffeemachine;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Класс, представляющий профиль кофе
class CoffeeProfile {
    private String name;
    private int coffeeAmount;
    private int waterAmount;
    private int milkAmount;

    public CoffeeProfile(String name, int coffeeAmount, int waterAmount, int milkAmount) {
        this.name = name;
        this.coffeeAmount = coffeeAmount;
        this.waterAmount = waterAmount;
        this.milkAmount = milkAmount;
    }

    public String getName() {
        return name;
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public int getMilkAmount() {
        return milkAmount;
    }

    @Override
    public String toString() {
        return "Название: " + name +
                ", Количество кофе: " + coffeeAmount +
                ", Количество воды: " + waterAmount +
                ", Количество молока: " + milkAmount;
    }
}

