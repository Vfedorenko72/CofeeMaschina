import java.util.Scanner;

public class array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите размер вашей корзтны: ");

        int longArray = scanner.nextInt();
        String[] size = new String[longArray];
        //System.out.print("Что бы вы хотели положить в корзину: ");
        int numberOfItems = 0;
        scanner.nextLine();

        for (int j = 0; j < longArray; j++) {

            System.out.print("Вы хотите положить в корзину вещи (да/нет)? ");
            if (scanner.next().equals("нет")) {
                break;
            }
            scanner.nextLine();
            System.out.print("Что бы вы хотели добавить: ");
            size[j] = scanner.nextLine();
            numberOfItems++;
        }

        if (longArray == numberOfItems) {
            System.out.println("Корзина заполнена\nКолисество вещей в корзине: " + numberOfItems + " шт.");
        } else {
            System.out.println("Корзина не заполнена\nКолисество вещей в корзине: " + numberOfItems + " шт.");
        }
        System.out.println("Вещи в корзтне:");
        for (int i = 0; i < numberOfItems; i++) {
            System.out.println("    - " + size[i]);
        }

    }
}
