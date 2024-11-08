package coffeemachine;

import java.util.Scanner;

public class ScanClass {
    static Scanner sc = new Scanner(System.in);

    public static int sc() {
        int res;
        try {
            res = sc.nextInt();

        } catch (Exception e) {
            sc.nextLine();
            return -1;
        }
        return res;
    }

    public static String scStr() {
        Scanner scStr = new Scanner(System.in);
        int maxLength = 15; // Максимальная длина строки
        String name = scStr.nextLine();
        if (name.length() > maxLength) {
            return "ошибка";

        } else {
            return name;
        }
    }
}
