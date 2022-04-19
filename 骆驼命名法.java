package demo16;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (i < str.length()) {
                if (str.charAt(i) == '_') {
                    i++;
                    stringBuilder.append((str.charAt(i) + "").toUpperCase(Locale.ROOT));
                    i++;
                } else {
                    stringBuilder.append(str.charAt(i));
                    i++;
                }
            }
            System.out.println(stringBuilder);
        }
    }
}
