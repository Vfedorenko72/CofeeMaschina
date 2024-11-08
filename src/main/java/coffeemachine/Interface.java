package coffeemachine;


public class Interface {


    Service service = new Service();
    Making making = new Making();
    CoffeeProfileManager profileManager = new CoffeeProfileManager();

    String whitespace = " ";
    String selectMenuItem = "Выберите пункт меню: ";

    public void start() {

        int num = -2;
        while (num != 2147483647) {
            System.out.print(whitespace.repeat(34) + "Кнопка включателя кофемашины (1/0)\n" +
                    "либо если выдернуть вилку из розетки - введите верхнюю границу int:) ");

            num = ScanClass.sc();

            if (num == 1) {
                turnOn();
                mainMenu();
                turnOff();
                } else if (num == 0) {
                turnOff();
            } else if (num == -1) {
                Decorator.print("Введенное значение должно быть числом");
                System.out.println();
            } else if (num == 2147483647) {
                System.exit(0);
            }
            else {
                Decorator.print("Вводимое значение должно быть только 0, 1 или то неприлично длинное число:)");
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

            if (num == 0) {
                return;
            }else if (num == -1) {
                Decorator.indent(30);
                Decorator.print("Введенное значение должно быть числом");
                System.out.println();
            } else if (num < 0 || num > 4) {
                String warning = "Выбранное значение должно быть от 0 до 4";
                Decorator.indent(30);
                Decorator.print(warning);

            } else{
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


        }
        Decorator.indent(30);


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
        int num = 1;
        while (num != 0) {
            num = ScanClass.sc();
            if (num == 0) {
                Decorator.indent(30);
                return;
            }else if (num < 0 || num > 5) {
                String warning = "Выбранное значение должно быть числом от 0 до 5";
                Decorator.indent(30);
                Decorator.print(warning);
            } else {
                if (num == 1 || num == 2) {
                    Decorator.print(qtyCupsStr);
                    int qtyCups = ScanClass.sc();
                    if (qtyCups == -1) {
                        Decorator.indent(30);
                        Decorator.print("Введите число, максимальное количество порций - 10");
                    } else {
                        Decorator.indent(30);
                        switch (num) {
                            case 1 -> making.espresso(qtyCups, service);
                            case 2 -> making.cappuccino(qtyCups, service);
                        }
                    }
                }
                switch (num) {
                    case 3 -> threeCoffees();

                    case 5 -> {
                        System.out.print("Введите название профиля: ");
                        String name = ScanClass.scStr();
                        int coffeeAmount = coffeeAmount();
                        if (coffeeAmount == 0) {
                            return;
                        }
                        int waterAmount = waterAmount();
                        if (waterAmount == 0) {
                            return;
                        }
                        int milkAmount = milkAmount();
                        if (milkAmount == 0) {
                            return;
                        }


                        profileManager.createProfile(name, coffeeAmount, waterAmount, milkAmount);
                    }
                    case 4 -> {
                        int size = profileManager.profilesSize();
                        if (size == 0) {
                            Decorator.indent(30);
                            Decorator.print("Список профилей пуст.");
                        } else if (profileManager.containsKey().equals("Нет профиля")) {
                            Decorator.print("Профиля с таким именем нет");
                        }
                        else {
                            CoffeeProfile profile = profileManager.getProfile(profileManager.containsKey());
                            int coffee = profile.getCoffeeAmount();
                            int water = profile.getWaterAmount();
                            int milk = profile.getMilkAmount();
                            String name = profile.getName();

                            making.coffeeOfProfile(size, name, coffee, water,
                                    milk, service);
                        }
                    }
                }
            }
            Decorator.border(makingCoffeeMenu);
            Decorator.print(selectMenuItem);
            //num = ScanClass.sc();
        }
        Decorator.indent(30);

    }
    public int coffeeAmount() {
        String qtyCoffee = "Введите количество порций кофе (1 - 10) или 0 для выхода: ";
        Decorator.print(qtyCoffee);
        while (true) {

            int qty = ScanClass.sc();
            if (qty < 0 || qty > 10) {
                Decorator.print(qtyCoffee);

            } else if (qty == 0) {
                return 0;
            } else {
               return  qty * 10;
            }
        }
    }

    public int waterAmount() {
        String qtyWater = "Введите количество воды (40 - 100) или 0 для выхода: ";
        Decorator.print(qtyWater);
        while (true) {

            int qty = ScanClass.sc();
            if ((qty < 40 || qty > 100) && qty != 0) {

                Decorator.print(qtyWater);

            } else if (qty == 0) {
                return 0;
            } else {
                return qty;
            }
        }

    }

    public int milkAmount() {
        String qtyMilk = "Введите количество молока (50 - 200) или 0 для выхода: ";
        Decorator.print(qtyMilk);
        while (true) {

            int qty = ScanClass.sc();
            if ((qty < 50 || qty > 250) && qty != 0) {

                Decorator.print(qtyMilk);

            } else if (qty == 0) {
                return 0;
            } else {
                return qty;
            }
        }

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

        int num = 1;

        while (num != 0) {
            num = ScanClass.sc();

            if (num == 0) {
                return;
            }else if (num < 0 || num > 4) {
                Decorator.indent(30);
                String warning = "Выбранное значение должно быть цифрой от 0 до 4";
                Decorator.print(warning);

            } else {
                switch (num) {
                    case 1 -> service.addCoffee();
                    case 2 -> service.addWater();
                    case 3 -> service.addMilk();
                    case 4 -> service.clearing();
                }
            }

            Decorator.border(serviceMenuString);
            Decorator.print(selectMenuItem);
            //num = ScanClass.sc();
        }
        Decorator.indent(30);
    }

    public void threeCoffees() {
        String coffeeSetStr = """
                1. Эспрессо
                2. Капучино""";
        Decorator.indent(30);
        int num = -1;
        while (num != 1 && num != 0) {


            Decorator.border(coffeeSetStr);

            Decorator.print("Выберите пункт меню или 0 для выхода: ");

            num = ScanClass.sc();
            Decorator.indent(30);
            switch (num) {
                case 1 -> making.espresso(3, service);
                case 2 -> making.cappuccino(3, service);
                case 0 -> {
                    return;
                }

                default -> {
                    Decorator.print("Выбранное значение должно быть только 0,  1 или 2");
                    System.out.println();
                }
            }
        }

    }


}
