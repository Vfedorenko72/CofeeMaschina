package coffeemachine;

import java.util.Scanner;


public class CoffeeMachine {
    static String whitespace = " ";
    public static void main(String[] args) {
        ;
        Scanner sc = new Scanner(System.in);
        Launch session = new Launch();
        session.indent(30);
        session.border();
        System.out.println(whitespace.repeat(5) + "Кнопка включателя кофемашины (1/0): ");
        session.border();

        session.launch(sc.nextInt());



    }

}
