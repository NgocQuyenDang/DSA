import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static int tinh(int a, int b, String dau) {
        switch (dau) {
            case "+" : return a + b;
            case "-" : return a - b;
            case "*" : return a * b;
            case "/" : return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {

        int a = 7;
        int b = 8;
        System.out.println(a + b);

        int result = tinh(10, 9, "-");
        System.out.println(result);
    }
}
