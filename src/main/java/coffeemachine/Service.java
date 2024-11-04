package coffeemachine;

import java.util.Scanner;

public class Service {

    private int coffee;
    private int water;
    private int milk;
    private int clearing;
    private static final int volumeCoffee = 500;
    private static final int volumeWater = 1000;
    private static final int volumeMilk = 500;
    Scanner sc = new Scanner(System.in);

    public Service(int coffee, int water, int milk) {

        this.coffee = coffee;
        this.water = water;
        this.milk = milk;
        this.clearing = 0;

    }

    public int getCoffee() {
        return coffee;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

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
            int addCoffee = sc.nextInt();
            if (addCoffee !=0) {
                if (addCoffee < minAddCoffee) {
                    Decorator.print(strMinAddCoffee);
                    return;
                } else if (addCoffee > cenAddCoffee) {
                    Decorator.print(coffeeDoesntFit);
                } else {
                    coffee += addCoffee;
                    System.out.println(coffee);
                    Decorator.print(coffeeInBox + coffee + "грамм кофе.");
                    ready = true;
                }
            } else {
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
            Decorator.border(msgAddWater);
            int addWater = sc.nextInt();
            if (addWater != 0) {
                if (addWater < minAddWater) {
                    Decorator.border(strMinAddWater);
                } else if (addWater >= cenAddWater) {
                    Decorator.border(waterDoesntFit);
                } else {
                    water += addWater;
                    Decorator.border(waterInBox + water + "миллилитров воды.");
                    ready = true;
                }
            } else {
                ready = true;
            }
        }
    }

    // Добавить молока
    public void addMilk() {
        int cenAddMilk = volumeMilk - milk;
        int minAddMilk = 80;
        String msgAddMilk = "Введите объем добавляемого молока в миллилитрах или 0 для отмены";
        String milkDoesntFit = "В данный момент вы можете добавить не более " + cenAddMilk + " миллилитров молока.";
        String milkInBox = "Емкость с молоком наполнена, в емкости: ";
        String strMinAddMilk = "Минимальное количество добавляемого молока 80 миллилитров.";
        boolean ready = false;
        while (!ready) {
            Decorator.border(msgAddMilk);
            int addMilk = sc.nextInt();
            if (addMilk != 0) {
                if (addMilk < minAddMilk) {
                    Decorator.border(strMinAddMilk);
                } else if (addMilk >= cenAddMilk) {
                    Decorator.border(milkDoesntFit);
                } else {
                    milk += addMilk;
                    Decorator.border(milkInBox + milk + "миллилитров молока.");
                    ready = true;
                }
            } else {
                ready = true;
            }
        }
    }

    // Остаток
    public String remains() {
        return "   Остаток:\n" +
                "    - бокс для кофе:      " + coffee + "грамм" +
                "\n    - емкость для воды:   " + water + "миллилитров" +
                "\n    - емкость для молока: " + milk + "миллилитров";
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
        return 0;

    }

    public int needsClearing(int qty) {

        if (clearing + qty > 50) {
           return -1;
        } else {
            clearing += qty;
            return 0;
        }
    }

    public void clearing() {
        clearing = 0;
    }


}
