package coffeemachine;


public class Main {
    static String whitespace = " ";
    CoffeeMachine coffeeMachine = new CoffeeMachine(500, 1000, 1000);
    public static void main(String[] args) {
        Interface inter = new Interface();
        Decorator.indent(30);
        inter.start();
    }

}
