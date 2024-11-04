package coffeemachine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Making {
    private List<String> coffeeLog = new ArrayList<>();

    // Приготовить эспрессо
    public void espresso(int qty, Service service) {
        int quantityCoffee = qty * 10;
        int quantityWater = qty * 40;
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
        String take = "Заберите пожалуйста ваш кофе";


        // Проверка, что не закончились ингредиенты
        int coffee = service.decreaseCoffee(quantityCoffee);
        if (coffee == -1) {
            Decorator.print(notEnoughCoffee);
            return;
        }
        int water = service.decreaseWater(quantityWater);
        if (water == -1) {
            Decorator.print(notEnoughWater);
            return;
        }

        Decorator.print(take);
        Decorator.print(service.remains());
        coffeeLog.add("Эспрессо");

    }

    public void cappuccino (int qty, Service service) {
        int quantityCoffee = qty * 10;
        int quantityWater = qty * 40;
        int quantityMilk = qty * 100;
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

        // Проверка, что не закончились ингредиенты
        int coffee = service.decreaseCoffee(quantityCoffee);
        if (coffee == -1) {
            Decorator.border(notEnoughCoffee);
            return;
        }
        int water = service.decreaseWater(quantityWater);
        if (water == -1) {
            Decorator.border(notEnoughWater);
            return;
        }

        int milk = service.decreaseMilk(quantityMilk);
        if (milk == -1) {
            Decorator.border(notEnoughMilk);
            return;
        }



        Decorator.print(take);
        Decorator.print(service.remains());

    }

    public String getLog(){
        return String.join("\n",coffeeLog);
    }


}
