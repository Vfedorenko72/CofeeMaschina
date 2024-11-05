package coffeemachine;

import java.util.Scanner;


public class CoffeeMachine {
    static String whitespace = " ";
    public static void main(String[] args) {
        Interface inter = new Interface();
        Scanner sc = new Scanner(System.in);
        Decorator.indent(30);
        System.out.print(whitespace.repeat(5) + "Кнопка включателя кофемашины (1/0): ");
        inter.turnOn(sc.nextInt());
        inter.mainMenu();
        inter.turnOff(0);


    }

}
