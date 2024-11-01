package coffeemachine;

public class Decorator {




    public static void indent(int width) {
        for (int i = 0; i < width; i++) {
            System.out.println();
        }

    }
    public static void border(String str) {
        System.out.println();
        System.out.print("|*|".repeat(15));
        System.out.println();
        System.out.println();

        System.out.println(str);

        System.out.println();
        System.out.print("|*|".repeat(15));
        System.out.println();
        System.out.println();
    }
}
