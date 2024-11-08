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

    public String contains() {
        for (String key : profiles.keySet()) {
            System.out.println(profiles.get(key));
        }
        String nameProfileStr = "Введите имя профиля: \n";
        Decorator.print(nameProfileStr);
        String nameProfile = ScanClass.scStr();
        if (profiles.containsKey(nameProfile)) {
            return nameProfile;
        } else {
            return "Нет профиля";
        }
    }

    // Метод для создания нового профиля
    public void createProfile(String name, int coffeeAmount, int waterAmount, int milkAmount) {
       /* System.out.print("Введите название профиля: ");
        String name = ScanClass.scStr();
        System.out.print("Введите количество порций кофе: ");
        int coffeeAmount = ScanClass.sc();

        System.out.print("Введите количество воды: ");
        int waterAmount = ScanClass.sc();
        System.out.print("Введите количество молока: ");
        int milkAmount = ScanClass.sc();*/


        CoffeeProfile profile = new CoffeeProfile(name, coffeeAmount, waterAmount, milkAmount);
        profiles.put(name, profile);
        System.out.println("Профиль создан успешно!");
        Making.addCoffeeLog("Создан профиль " + name);
    }

    // отдаю профиль
    public CoffeeProfile getProfile(String nameProfile) {



        return  profiles.get(nameProfile);


    }
    public int profilesSize() {
        return profiles.size();
    }
}