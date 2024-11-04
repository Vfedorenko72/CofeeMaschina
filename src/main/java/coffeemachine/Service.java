package coffeemachine;

import java.util.Scanner;

public class Service {

    private int coffee;
    private int water;
    private int milk;
    private static final int volumeCoffee = 500;
    private static final int volumeWater = 1000;
    private static final int volumeMilk = 500;
    Scanner sc = new Scanner(System.in);

    public Service(int coffee, int water, int milk) {

        this.coffee = coffee;
        this.water = water;
        this.milk = milk;

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
    public void addCoffee(int qty) {
        int cenAddCoffee = volumeCoffee - coffee;
        int minAddCoffee = 10;
        String msgAddCoffee = "Введите вес добавляемого кофе в граммах";
        String coffeeDoesntFit = "В данный момент вы можете добавить не более " + cenAddCoffee + " грамм кофе.";
        String coffeeInBox = "Бокс с кофе пополнен, в боксе: " + coffee + "грамм кофе.";
        String strMinAddCoffee = "Минимальное количество добавляемого кофе 10 грамм.";
        while (true) {
            Decorator.border(msgAddCoffee);
            int addCoffee = sc.nextInt();
            if (addCoffee < minAddCoffee) {
                Decorator.border(strMinAddCoffee);
            } else if (addCoffee >= cenAddCoffee) {
                Decorator.border(coffeeDoesntFit);
            } else {
                coffee += addCoffee;
                Decorator.border(coffeeInBox);
                break;
            }

        }

    }

    // Добавить воды
    public void addWater(int qty) {
        int cenAddWater = volumeWater - water;
        int minAddWater = 40;
        String msgAddWater = "Введите объем добавляемой воды в миллилитрах";
        String waterDoesntFit = "В данный момент вы можете добавить не более " + cenAddWater + " милллилитров воды.";
        String waterInBox = "Емкость с водой наполнена, в емкости: " + water + "миллилитров воды.";
        String strMinAddWater = "Минимальное количество добавляемой воды 40 милилитров.";
        while (true) {
            Decorator.border(msgAddWater);
            int addWater = sc.nextInt();
            if (addWater < minAddWater) {
                Decorator.border(strMinAddWater);
            } else if (addWater >= cenAddWater) {
                Decorator.border(waterDoesntFit);
            } else {
                water += addWater;
                Decorator.border(waterInBox);
                break;
            }

        }

    }
    // Добавить молока
    public void addMilk() {
        int cenAddMilk = volumeMilk - milk;
        int minAddMilk = 80;
        String msgAddMilk = "Введите объем добавляемого молока в миллилитрах или -1 для отмены";
        String milkDoesntFit = "В данный момент вы можете добавить не более " + cenAddMilk + " миллилитров молока.";
        String milkInBox = "Емкость с молоком наполнена, в емкости: " + milk + "миллилитров молока.";
        String strMinAddMilk = "Минимальное количество добавляемого молока 80 миллилитров.";
        boolean ready = false;
        while (!ready) {
            Decorator.border(msgAddMilk);
            int addMilk = sc.nextInt();
            if (addMilk != -1) {
                if (addMilk < minAddMilk) {
                    Decorator.border(strMinAddMilk);
                } else if (addMilk >= cenAddMilk) {
                    Decorator.border(milkDoesntFit);
                } else {
                    milk += addMilk;
                    Decorator.border(milkInBox);
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

    // Убавить кофе
    public int decreaseCoffee(int decreaseCoffee) {
        if (coffee - decreaseCoffee < 0) {
            return -1;//что-то пошло не так
        }
        coffee -= decreaseCoffee;
        return coffee;
    }

    // Убавить воду
    public int decreaseWater(int decreaseWater) {
        if (water - decreaseWater < 0) {
            return -1;
        }
        water -= decreaseWater;
        return water;
    }

    // Убавить молоко
    public int decreaseMilk(int decreaseMilk) {
        if (water - decreaseMilk < 0) {
            return -1;
        }
        water -= decreaseMilk;
        return water;
    }
}
