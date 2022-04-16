package demo11;

import java.util.Scanner;

public class Main {
    public static boolean func1(char[][] chars, int i, int j) {
        if (i + 4 >= 20) {
            return false;
        }
        if (chars[i][j] == chars[i+1][j] && chars[i][j] == chars[i+2][j] && chars[i][j] == chars[i+3][j] &&
            chars[i][j] == chars[i+4][j]) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean func2(char[][] chars, int i, int j) {
        System.out.println(j);
        if (j + 4 >= 20) {
            return false;
        }
        System.out.println(chars[i][j]);
        if (chars[i][j] == chars[i][j+1] && chars[i][j] == chars[i][j+2] && chars[i][j] == chars[i][j+3] &&
                chars[i][j] == chars[i][j+4]) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean func3(char[][] chars, int i, int j) {
        int count = 0;
        if (i + 4 >= 20 || j + 4 >= 20) {
            return false;
        }
        if (chars[i][j] == chars[i+1][j+1] && chars[i][j] == chars[i+2][j+2] && chars[i][j] == chars[i+3][j+3] &&
                chars[i][j] == chars[i+4][j+4]) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean func4(char[][] chars, int i, int j) {
        int count = 0;
        if (i + 4 >= 20 || j - 4 < 0) {
            return false;
        }
        if (chars[i][j] == chars[i+1][j-1] && chars[i][j] == chars[i+2][j-2] && chars[i][j] == chars[i+3][j-3] &&
                chars[i][j] == chars[i+4][j-4]) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean func(char[][] chars) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (chars[i][j] != '.') {
                    if (func1(chars,i,j) || func2(chars,i,j) || func3(chars,i,j) || func4(chars,i,j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            char[][] chars = new char[20][20];
            for (int i = 0; i < 20; i++) {
                String str = scanner.next();
                for (int j = 0; j < 20; j++) {
                    chars[i][j] = str.charAt(j);
                }
            }
            boolean ret = func(chars);
            System.out.println(ret);
        }
    }
}
