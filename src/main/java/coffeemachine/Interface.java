package coffeemachine;

import java.util.Scanner;

public class Interface {

    Scanner sc = new Scanner(System.in);
    Service service = new Service(500, 1000, 500);
   // Making making = new Making(500, 1000, 500);

    static String whitespace = " ";

    /*public void launch(int num) {
        // Сдесь нужна проверка валидации, пропускаем только 1 и 0
        if (num == 1) {
            turnOn();
            mainMenu();
        } else {
            turnOff();
        }
    }*/


    public void turnOn(int num) {
        Decorator.indent(30);
        String ternOn = whitespace.repeat(10) + "Кофемашина включена";
        Decorator.border(ternOn);

    }

    public void turnOff(int num) {
        Decorator.indent(30);
        String ternOff = whitespace.repeat(10) + "Кофемашина выключена";
        Decorator.border(ternOff);
    }


    public void mainMenu() {
        String mainMenu = "1. Приготовление кофе\n" +
                "2. Обслуживание\n" +
                "3. Логирование\n" +
                "0. Выключить кофемашину ";
        Decorator.border(mainMenu);
        System.out.print("Выберите пункт меню: ");
        int num = sc.nextInt();
        while (num != 0) {

            switch (num) {
                case 1 -> makingCoffeeMenu();
                case 2 -> serviceMenu();

            }
            Decorator.border(mainMenu);
            System.out.print("Выберите пункт меню: ");
            num = sc.nextInt();
        }

    }

    public void makingCoffeeMenu() {
        Decorator.indent(30);
        String makingCoffeeMenu = "    ПРИГОТОВЛЕНИЕ\n" +
                "1. Эспрессо\n" +
                "2. Капучино\n" +
                "3. Три порции любого\n" +
                "4. Профили\n" +
                "5. Создать профиль\n" +
                "0. Главное меню";
        Decorator.border(makingCoffeeMenu);
        System.out.print("Выберите пункт меню: ");
        int num = sc.nextInt();
        switch (num) {
            case 1-> {
                String espresso = making.espresso(1);
                System.out.println(espresso);
            }

        }


    }

    public void serviceMenu() {
        Decorator.indent(30);
        String serviceMenuString = "     ОБСЛУЖИВАНИЕ\n" +
                "  Остаток:\n" +
                "    - бокс для кофе:      " + service.getCoffee() +
                "\n    - емкость для воды:   " + service.getWater() +
                "\n    - емкость для молока: " + service.getMilk() +
                "\n1. Добавить кофе\n" +
                "2. Добавить воды\n" +
                "3. Добавить молока\n" +
                "0. Главное меню";
        Decorator.border(serviceMenuString);
        System.out.print("Выберите пункт меню: ");
        int numS = sc.nextInt();
        switch (numS) {
            case 0:
                Decorator.indent(30);
                mainMenu();


        }

    }

}
