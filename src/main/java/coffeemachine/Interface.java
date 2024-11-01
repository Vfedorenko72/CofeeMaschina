package coffeemachine;

import java.util.Scanner;

public class Interface {

    Scanner sc = new Scanner(System.in);

    static String whitespace = " ";

    public void launch(int num) {
        // Сдесь нужна проверка валидации, пропускаем только 1 и 0
        if (num == 1) {
            turnOn();
        } else {
            turnOff();
        }
    }


    private void turnOn() {
        Decorator.indent(30);
        Decorator.border();
        System.out.println(whitespace.repeat(10) + "Кофемашина включена");
        Decorator.border();
        mainMenu();
    }

    private void turnOff() {
        Decorator.indent(30);
        Decorator.border();
        System.out.println(whitespace.repeat(10) + "Кофемашина выключена");
        Decorator.border();
    }


    public void mainMenu() {
        Decorator.border();
        int mainMenuNum;
        System.out.print("1. Приготовление кофе\n" +
                "2. Обслуживание\n" +
                "3. Логирование\n" +
                "Выберите пункт меню: ");
        Decorator.border();
        if (sc.nextInt() == 1) {

        } else if (sc.nextInt() == 2) {

        } else if (sc.nextInt() == 3) {

        }

    }

}
