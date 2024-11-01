package coffeemachine;

import java.util.Scanner;


public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Decorator.indent(30);
        Decorator.border();
        System.out.println(Interface.whitespace.repeat(5) + "Кнопка включателя кофемашины (1/0): ");
        Decorator.border();
        Interface inter = new Interface();
        inter.launch(sc.nextInt());


    }

}
