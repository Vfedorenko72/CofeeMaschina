package coffeemachine;

import java.util.Scanner;




public class Service {
    CoffeeMachine coffeeMachine = new CoffeeMachine(500, 1000, 1000);
    int coffee = coffeeMachine.getCoffee();
    int water = coffeeMachine.getWater();
    int milk = coffeeMachine.getMilk();
    int clearing = coffeeMachine.getClearing();
    final int volumeCoffee = CoffeeMachine.volumeCoffee;
    final int volumeWater = CoffeeMachine.volumeWater;
    final int volumeMilk= CoffeeMachine.volumeMilk;

    // Добавить кофе
    public void addCoffee() {
        int cenAddCoffee = volumeCoffee - coffee;
        int minAddCoffee = 10;
        String msgAddCoffee = "Введите вес добавляемого кофе в граммах или 0 для отмены: ";
        String coffeeDoesntFit = "В данный момент вы можете добавить не более " + cenAddCoffee + " грамм кофе.";
        String coffeeInBox = "Бокс с кофе пополнен, в боксе: " ;
        String strMinAddCoffee = "Минимальное количество добавляемого кофе 10 грамм.";
        boolean ready = false;
        while (!ready) {
            Decorator.print(msgAddCoffee);
            int addCoffee = ScanClass.sc();
            if (addCoffee !=0) {
                if (addCoffee == -1) {
                    String warning = "Выбранное значение должно быть цифрой";


                    Decorator.print(warning);
                    System.out.println();
                } else if (addCoffee < minAddCoffee) {
                    Decorator.print(strMinAddCoffee);
                    System.out.println();
                } else if (addCoffee > cenAddCoffee) {
                    Decorator.print(coffeeDoesntFit);
                    System.out.println();

                } else {
                    coffee += addCoffee;
                    Decorator.indent(30);
                    Decorator.print(coffeeInBox + coffee + " грамм кофе.");
                    System.out.println();
                    Decorator.print(remains());
                    Making.addCoffeeLog("Добавил " + addCoffee + " грамм кофе");

                    ready = true;
                }
            } else {
                Decorator.indent(30);
                ready = true;
            }
        }

    }

    // Добавить воды
    public void addWater() {
        int cenAddWater = volumeWater - water;
        int minAddWater = 40;
        String msgAddWater = "Введите объем добавляемой воды в миллилитрах или 0 для отмены: ";
        String waterDoesntFit = "В данный момент вы можете добавить не более " + cenAddWater + " милллилитров воды.";
        String waterInBox = "Емкость с водой наполнена, в емкости: ";
        String strMinAddWater = "Минимальное количество добавляемой воды 40 милилитров.";
        boolean ready = false;
        while (!ready) {
            Decorator.print(msgAddWater);
            int addWater = ScanClass.sc();
            if (addWater != 0) {
                if (addWater == -1) {
                    String warning = "Выбранное значение должно быть цифрой";


                    Decorator.print(warning);
                    System.out.println();
                } else if (addWater < minAddWater) {
                    Decorator.print(strMinAddWater);
                    System.out.println();
                } else if (addWater > cenAddWater) {
                    Decorator.print(waterDoesntFit);
                    System.out.println();
                } else {
                    water += addWater;
                    Decorator.print(waterInBox + water + " миллилитров воды.");
                    System.out.println();
                    Decorator.print(remains());
                    Making.addCoffeeLog("Добавил " + addWater + " миллилитров воды");
                    ready = true;
                }
            } else {
                Decorator.indent(30);
                ready = true;
            }
        }
    }

    // Добавить молока
    public void addMilk() {
        int cenAddMilk = volumeMilk - milk;
        int minAddMilk = 80;
        String msgAddMilk = "Введите объем добавляемого молока в миллилитрах или 0 для отмены: ";
        String milkDoesntFit = "В данный момент вы можете добавить не более " + cenAddMilk + " миллилитров молока.";
        String milkInBox = "Емкость с молоком наполнена, в емкости: ";
        String strMinAddMilk = "Минимальное количество добавляемого молока 80 миллилитров.";
        boolean ready = false;
        while (!ready) {
            Decorator.print(msgAddMilk);
            int addMilk = ScanClass.sc();
            if (addMilk != 0) {
                if (addMilk == -1) {
                    String warning = "Выбранное значение должно быть цифрой";


                    Decorator.print(warning);
                    System.out.println();
                }
                if (addMilk < minAddMilk) {
                    Decorator.print(strMinAddMilk);
                    System.out.println();
                } else if (addMilk >= cenAddMilk) {
                    Decorator.print(milkDoesntFit);
                    System.out.println();
                } else {
                    milk += addMilk;
                    Decorator.print(milkInBox + milk + " миллилитров молока.");
                    System.out.println();
                    Decorator.print(remains());
                    Making.addCoffeeLog("Добавил " + addMilk + " миллилитров молока");
                    ready = true;
                }
            } else {
                Decorator.indent(30);
                ready = true;
            }
        }
    }

    // Остаток
    public String remains() {
        return "   Остаток:\n" +
                "    - бокс для кофе:      " + coffee + " грамм" +
                "\n    - емкость для воды:   " + water + " миллилитров" +
                "\n    - емкость для молока: " + milk + " миллилитров";
    }


    // Убавить ингредиенты
    public int decreaseIngredients(int decreaseCoffee, int decreaseWater, int decreaseMilk) {
        if (coffee - decreaseCoffee < 0) {
            return -1;                             //что-то пошло не так
        } else if (water - decreaseWater < 0) {
            return -2;
        } else if (milk - decreaseMilk < 0) {
            return -3;
        }

        coffee -= decreaseCoffee;
        water -= decreaseWater;
        milk -= decreaseMilk;
        return 0;

    }

    public int needsClearing(int qty) {

        if (clearing + qty > 10) {
           return -1;
        } else {
            clearing += qty;
            return 0;
        }
    }

    public void clearing() {
        clearing = 0;
        Decorator.indent(30);
        String clearingStr = "Кофемашина очищена";
        Decorator.print(clearingStr);
        Making.addCoffeeLog("Очистка кофемашины");
    }


}
