package coffeemachine;

import java.util.HashMap;
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
        Making.addCoffeeLog("Создан профиль " + name);
    }

    // Метод для вывода профиля по названию
    public CoffeeProfile getProfile() {
        String nameProfileStr = "Введите имя профиля: \n";

        for (String key : profiles.keySet()) {
            System.out.println(profiles.get(key));
        }
        Decorator.print(nameProfileStr);
        String nameProfile = ScanClass.scStr();

        return  profiles.get(nameProfile);


    }

}