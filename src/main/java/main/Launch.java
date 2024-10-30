package main;

public class Launch {


    public void launch(int num) {
        // Сдесь нужна проверка валидации, пропускаем только 1 и 0
        if (num == 1) {
            turnOn();
        } else {
            turnOff();
        }
    }


    public void turnOn() {
        indent(30);
        border();
        System.out.println(CoffeeMachine.whitespace.repeat(10) + "Кофемашина включена");
        border();
    }

    public void turnOff() {
        border();
        indent(30);
        System.out.println(CoffeeMachine.whitespace.repeat(10) + "Кофемашина выключена");
        border();
    }

    public void indent(int width) {
        for (int i = 0; i < width; i++) {
            System.out.println();
        }

    }
    public void border() {
        System.out.println();
        for (int i = 0; i < 15; i++) {

            System.out.print("|*|");
        }
            System.out.println();
            System.out.println();

    }
}
