package lab1_client;


import java.util.Scanner;

public class ConsoleInput {
    public static String ReadStrValue(String field) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter " + field + " or press enter to continue: ");
        String str_val = in.nextLine();
        if (str_val.equals("")) {
            str_val = null;
        }
        return str_val;
    }
    public static Integer ReadIntValue(String field) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter " + field + " or press enter to continue: ");
        String str_val = in.nextLine();
        if (str_val.equals("")) {
            return null;
        }

        return Integer.parseInt(str_val);

    }
}
