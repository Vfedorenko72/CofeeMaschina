package coffeemachine;

import java.util.List;

public class Interface {


    Service service = new Service();
    Making making = new Making();
    CoffeeProfileManager profileManager = new CoffeeProfileManager();

    String whitespace = " ";
    String selectMenuItem = "Выберите пункт меню: ";

    public void start() {

        int num = -1;
        while (num != 1 && num != 0) {
            System.out.print(whitespace.repeat(5) + "Кнопка включателя кофемашины (1/0): ");

            num = ScanClass.sc();
            if (num == 1) {
                turnOn();
                mainMenu();
                turnOff();
            } else if (num == 0) {
                turnOff();
            }else {
                Decorator.print("Вводимое значение должно быть только 0 или 1");
                System.out.println();
            }

        }
    }



    public void turnOn() {
        Decorator.indent(30);
        String ternOn = whitespace.repeat(10) + "Кофемашина включена";
        Decorator.border(ternOn);

    }

    public void turnOff() {
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
        Decorator.print(selectMenuItem);



        int num = 1;

        while (num != 0) {
            num = ScanClass.sc();
            if (num < 0 || num > 4) {
                String warning = "Выбранное значение должно быть от 0 до 4";
                Decorator.print(warning);
            } else {
                switch (num) {
                    case 1 -> makingCoffeeMenu(service);
                    case 2 -> serviceMenu();
                    case 3 -> {
                        Decorator.indent(30);
                        System.out.println(" ".repeat(5) + "ЛОГИ");
                        Decorator.print(making.getLog());
                    }
                    case 4 -> {
                        Decorator.indent(30);
                        Decorator.print(service.remains());
                    }

                }
            }
            Decorator.border(mainMenu);
            Decorator.print(selectMenuItem);
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

        String qtyCupsStr = "Выберите количество чашек: ";
        Decorator.border(makingCoffeeMenu);
        Decorator.print(selectMenuItem);
        int num = ScanClass.sc();

        while (num != 0) {
            if (num == 1 || num==2) {
                Decorator.print(qtyCupsStr);
                int qtyCups = ScanClass.sc();
                Decorator.indent(30);
                switch (num) {
                    case 1 -> making.espresso(qtyCups, service);
                    case 2 -> making.cappuccino(qtyCups, service);
                }
            }
            switch (num){
                case 3 -> threeCoffees();

                case 5 -> {
                    profileManager.createProfile();
                }
                case 4 -> {
                    CoffeeProfile profile = profileManager.getProfile();
                    int coffee = profile.getCoffeeAmount();
                    int water = profile.getWaterAmount();
                    int milk =  profile.getMilkAmount();
                    String name = profile.getName();
                    making.coffeeOfProfile(name, coffee, water,
                            milk, service);
                }



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
        String serviceMenuString = """
                ОБСЛУЖИВАНИЕ
                1. Добавить кофе
                2. Добавить воды
                3. Добавить молока
                4. Очистить кофемашину
                0. Главное меню""";
        Decorator.print(selectMenuItem);

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

    public void threeCoffees() {
        String coffeeSetStr = """
                1. Эспрессо
                2. Капучино""";
        Decorator.indent(30);
        Decorator.border(coffeeSetStr);
        Decorator.print(selectMenuItem);
        int num = ScanClass.sc();
        Decorator.indent(30);

        switch (num) {
            case 1 -> making.espresso(3, service);
            case 2 -> making.cappuccino(3, service);
        }
    }


}
