package coffeemachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Making {
    public static List<String> coffeeLog = new ArrayList<>();
    private Map<String, CoffeeProfile> coffeeProfiles = new HashMap<>();


    Map<String, Double> hashMap = new HashMap<>();

    String notEnoughCoffee = """
            Не достаточно кофе.
            Для добавления кофе перейдите:
            Главное меню -> Обслуживание -> Добавить кофе
            """;
    String notEnoughWater = """
            Не достаточно воды.
            Для добавления воды перейдите:
            Главное меню -> Обслуживание -> Добавить воды
            """;
    String notEnoughMilk = """
            Не достаточно молока.
            Для добавления молока перейдите:
            Главное меню -> Обслуживание -> Добавить молока
            """;
    String take = "Заберите пожалуйста ваш кофе: ";
    String clearingStr = """
            Необходимо очистить емкость с отходами кофе.
            Главное меню -> Обслуживание -> Очистка""";
    String maxServings = "Максимальное количество порций - 10";

    // Приготовить эспрессо
    public void espresso(int qty, Service service) {
        int quantityCoffee = qty * 10;
        int quantityWater = qty * 40;
        int quantityMilk = 0;
        int clearing = service.needsClearing(qty);


        // Не больше 10 кружек за раз
        if (qty > 10) {
            Decorator.print(maxServings);
            return;

        }
        // проверка на прибраться
        if (clearing == -1) {
            Decorator.print(clearingStr);
            return;
        }
        // Проверка, что не закончились ингредиенты
        int ingredientsCode = service.decreaseIngredients(quantityCoffee, quantityWater, quantityMilk);
        switch (ingredientsCode) {
            case -1 -> {
                Decorator.print(notEnoughCoffee);
                return;
            }
            case -2 -> {
                Decorator.print(notEnoughWater);
                return;
            }
        }

        Decorator.print(take + qty + " Эспрессо");
        System.out.println();
        Decorator.print(service.remains());

        CoffeeType coffeeType = CoffeeType.ESPRESSO;

        addCoffeeLog("Приготовлено " + qty + coffeeType.getName());

    }

    // приготовление по профилю
    public void coffeeOfProfile(int size, String name, int coffee, int water, int milk, Service service) {
        String qtyCupsStr = "Выберите количество чашек: ";
        Decorator.print(qtyCupsStr);
        int qty = ScanClass.sc();
        int quantityCoffee = qty * coffee;
        int quantityWater = qty * water;
        int quantityMilk = qty * milk;
        int clearing = service.needsClearing(qty);
        // Не больше 10 кружек за раз
        if (qty > 10) {
            Decorator.print(maxServings);
            return;
        }
        // Проверка нужно ли прибраться
        if (clearing == -1) {
            Decorator.print(clearingStr);
            return;
        }
        // Проверка, что не закончились ингредиенты
        int ingredientsCode = service.decreaseIngredients(quantityCoffee, quantityWater, quantityMilk);
        switch (ingredientsCode) {
            case -1 -> {
                Decorator.print(notEnoughCoffee);
                return;
            }
            case -2 -> {
                Decorator.print(notEnoughWater);
                return;
            }
            case -3 -> {
                Decorator.print(notEnoughMilk);
                return;
            }

        }

        Decorator.indent(30);
        Decorator.print(take + qty + " " + name);
        System.out.println();
        Decorator.print(service.remains());

        CoffeeType coffeeType = CoffeeType.PROFILE;
        addCoffeeLog("Приготовлено " + qty + " кофе из " + coffeeType.getName() + " " + name);
    }

    // Приготовить капучино
    public void cappuccino(int qty, Service service) {
        int quantityCoffee = qty * 10;
        int quantityWater = qty * 40;
        int quantityMilk = qty * 100;
        int clearing = service.needsClearing(qty);
        // Не больше 10 кружек за раз
        if (qty > 10) {
            Decorator.print(maxServings);
            return;
        }
        // Проверка нужно ли прибраться
        if (clearing == -1) {
            Decorator.print(clearingStr);
            return;
        }
        // Проверка, что не закончились ингредиенты
        int ingredientsCode = service.decreaseIngredients(quantityCoffee, quantityWater, quantityMilk);
        switch (ingredientsCode) {
            case -1 -> {
                Decorator.print(notEnoughCoffee);
                return;
            }
            case -2 -> {
                Decorator.print(notEnoughWater);
                return;
            }
            case -3 -> {
                Decorator.print(notEnoughMilk);
                return;
            }

        }


        Decorator.print(take + qty + " Капучино");
        System.out.println();
        Decorator.print(service.remains());

        CoffeeType coffeeType = CoffeeType.RAPPUCCINO;

        addCoffeeLog("Приготовлено " + qty + coffeeType.getName());

    }

    public enum CoffeeType {
        ESPRESSO(" Эспрессо"),
        RAPPUCCINO(" Капучино"),
        PROFILE(" профиль");


        private final String name;


        CoffeeType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


    public static void addCoffeeLog(String coffeeLogStr) {

        coffeeLog.add(coffeeLogStr);
    }

    public String getLog() {

        return String.join("\n", coffeeLog);
    }


}
