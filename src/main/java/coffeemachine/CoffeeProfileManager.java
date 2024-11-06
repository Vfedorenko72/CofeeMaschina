package coffeemachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class CoffeeProfileManager {
    private Map<String, CoffeeProfile> profiles;
    private Scanner scanner;

    public CoffeeProfileManager() {
        this.profiles = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }

    // Метод для создания нового профиля
    public void createProfile() {
        System.out.print("Введите название профиля: ");
        String name = ScanClass.scStr();
        System.out.print("Введите количество кофе: ");
        int coffeeAmount = ScanClass.sc();
        System.out.print("Введите количество воды: ");
        int waterAmount = ScanClass.sc();
        System.out.print("Введите количество молока: ");
        int milkAmount = ScanClass.sc();


        CoffeeProfile profile = new CoffeeProfile(name, coffeeAmount, waterAmount, milkAmount);
        profiles.put(name, profile);
        System.out.println("Профиль создан успешно!");
    }

    // Метод для вывода профиля по названию
    public List<Integer> getProfile() {
        String nameProfileStr = "Введите имя профиля: \n";

        for (String key : profiles.keySet()) {
            System.out.println(profiles.get(key));
        }
        Decorator.print(nameProfileStr);
        String nameProfile = ScanClass.scStr();
        int coffee = profiles.get(nameProfile).getCoffeeAmount();
        int water = profiles.get(nameProfile).getWaterAmount();
        int milk = profiles.get(nameProfile).getMilkAmount();


        return List.of(coffee, water, milk);


    }

}