package coffeemachine;

import java.util.Scanner;

public class Interface {

    Service service = new Service();
    Making making = new Making();
    static String whitespace = " ";

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
        String mainMenu = """
                1. Приготовление кофе
                2. Обслуживание
                3. Логирование
                4. Посмотреть остатки
                0. Выключить кофемашину""";
        Decorator.border(mainMenu);
        System.out.print("Выберите пункт меню: ");
        int num = ScanClass.sc();
        while (num != 0) {
            switch (num) {
                case 1 -> makingCoffeeMenu(service);
                case 2 -> serviceMenu();
                case 3 -> {
                    System.out.println(" ".repeat(5) + "ЛОГИ");
                    Decorator.print(making.getLog());
                }
                case 4 -> {
                    Decorator.indent(30);
                    Decorator.print(service.remains());
                }

            }
            Decorator.border(mainMenu);
            System.out.print("Выберите пункт меню: ");
            num = ScanClass.sc();
        }


    }

    public void makingCoffeeMenu(Service service) {
        Decorator.indent(30);
        String makingCoffeeMenu = """
                    ПРИГОТОВЛЕНИЕ
                1. Эспрессо
                2. Капучино
                3. Три порции любого кофе
                4. Профили
                5. Создать профиль
                0. Главное меню""";
        String selectMenuItem = "Выберите пункт меню: ";
        String qtyCupsStr = "Выберите количество чашек: ";
        Decorator.border(makingCoffeeMenu);
        Decorator.print(selectMenuItem);
        int num = ScanClass.sc();

        while (num != 0) {
            Decorator.print(qtyCupsStr);
            int qtyCups = ScanClass.sc();
            Decorator.indent(30);
            switch (num) {
                case 1 -> making.espresso(qtyCups, service);
                case 2 -> making.cappuccino(qtyCups, service);
            }
            Decorator.border(makingCoffeeMenu);
            Decorator.print(selectMenuItem);
            num = ScanClass.sc();
        }
        Decorator.indent(30);

    }

    public void serviceMenu() {
        Decorator.indent(30);
        Decorator.print(service.remains());
        String serviceMenuString = " ОБСЛУЖИВАНИЕ " +
                "\n1. Добавить кофе " +
                "\n2. Добавить воды " +
                "\n3. Добавить молока " +
                "\n4. Очистить кофемашину " +
                "\n0. Главное меню";
        String selectMenuItem = "Выберите пункт меню: ";

        Decorator.border(serviceMenuString);
        Decorator.print(selectMenuItem);
        int num = ScanClass.sc();
        while (num != 0) {
            switch (num) {
                case 1 -> service.addCoffee();
                case 2 -> service.addWater();
                case 3 -> service.addMilk();
                case 4 -> service.clearing();
            }
            Decorator.border(serviceMenuString);
            Decorator.print(selectMenuItem);
            num = ScanClass.sc();
        }
        Decorator.indent(30);
    }

}
