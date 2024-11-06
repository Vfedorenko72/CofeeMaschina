package coffeemachine;

import java.util.Scanner;

public class ScanClass {


    public static int sc() {

            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
    }
    public static String scStr() {
        Scanner scStr = new Scanner(System.in);
        return scStr.nextLine();
    }
}
