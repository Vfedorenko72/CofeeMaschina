package coffeemachine;

import java.util.Scanner;


public class CoffeeMachine {

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Decorator.indent(30);
//        System.out.print(Interface.whitespace.repeat(5) + "Кнопка включателя кофемашины (1/0): ");
//        Interface inter = new Interface();
//        inter.launch(sc.nextInt());

        Ingredients ingredients = new Ingredients(10,10,10);

        String all = ingredients.checkAll();//получаем текущую информацию о всех ингредиентах
        System.out.println(all);


    }

}
