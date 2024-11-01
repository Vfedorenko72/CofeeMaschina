package coffeemachine;

public class Decorator {




    public static void indent(int width) {
        for (int i = 0; i < width; i++) {
            System.out.println();
        }

    }
    public static void border() {
        System.out.println();
        for (int i = 0; i < 15; i++) {

            System.out.print("|*|");
        }
            System.out.println();
            System.out.println();

    }
}
