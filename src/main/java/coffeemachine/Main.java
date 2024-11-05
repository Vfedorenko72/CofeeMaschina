package coffeemachine;


public class Main {
    static String whitespace = " ";
    CoffeeMachine coffeeMachine = new CoffeeMachine(500, 1000, 1000);
    public static void main(String[] args) {
        Interface inter = new Interface();
        Decorator.indent(30);
        System.out.print(whitespace.repeat(5) + "Кнопка включателя кофемашины (1/0): ");
        inter.turnOn(ScanClass.sc());
        inter.mainMenu();
        inter.turnOff(0);


    }

}
