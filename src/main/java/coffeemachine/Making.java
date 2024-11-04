package coffeemachine;

public class Making {

    // Приготовить эспрессо
    public void espresso(int q, Service service) {
        int quantityCoffee = q * 10;
        int quantityWater = q * 40;
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

        int coffee = service.decreaseCoffee(quantityCoffee);
        if (coffee == -1) {
            Decorator.border(notEnoughCoffee);
            return;
        }
        int water = service.decreaseWater(quantityWater);//сделать проверки, что не кончился ресурс

        //int milk = service.decreaseMilk(quantityMilk);

        System.out.println("Вот ваш кофе");
        Decorator.border(service.remains());








      /* coffee -= quantityCoffee;
        water -= quantityWater;

        if (coffee < 0 || water < 0) {
            return "Не получилось";
        } else {
            return "Вот ваш кофе";
        }*/
    }


}
