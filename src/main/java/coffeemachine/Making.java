package coffeemachine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Making {
    public static List<String> coffeeLog = new ArrayList<>();
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
    String take = "Заберите пожалуйста ваш кофе";
    String clearingStr = """
                Необходимо очистить емкость с отходами кофе.
                Главное меню -> Обслуживание -> Очистка""";

    // Приготовить эспрессо
    public void espresso(int qty, Service service) {
        int quantityCoffee = qty * 10;
        int quantityWater = qty * 40;
        int quantityMilk = 0;

        // Проверка, что не закончились ингредиенты
        int ingredientsCode = service.decreaseIngredients(quantityCoffee, quantityWater, quantityMilk);
        int clearing = service.needsClearing(qty);
        if (clearing == -1) {
            Decorator.print(clearingStr);
            return;
        }

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

        Decorator.print(take);
        System.out.println();
        Decorator.print(service.remains());
        addCoffeeLog("Приготовлено " + qty + " Эспрессо");

    }
    // Приготовить капучино
    public void cappuccino (int qty, Service service) {
        int quantityCoffee = qty * 10;
        int quantityWater = qty * 40;
        int quantityMilk = qty * 100;

        // Проверка, что не закончились ингредиенты
        int ingredientsCode = service.decreaseIngredients(quantityCoffee, quantityWater, quantityMilk);
        int clearing = service.needsClearing(qty);
        if (clearing == -1) {
            Decorator.print(clearingStr);
            return;
        }
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


        Decorator.print(take);
        System.out.println();
        Decorator.print(service.remains());
        addCoffeeLog("Приготовлено " + qty + " Капучино");

    }
    public static void addCoffeeLog(String coffeeLogStr) {
        coffeeLog.add(coffeeLogStr);
    }

    public String getLog(){
        return String.join("\n",coffeeLog);
    }



}
