import book.BookList;
import user.User;
import user.adminUser;
import user.normalUser;

import java.util.Scanner;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021--
 * Time:11:51
 */
public class Main {
    public static User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你的名字：");
        String name = scanner.next();
        System.out.println("=======请输入你都身份========");
        System.out.println("1:管理员     |        2:用户");

        int choice = scanner.nextInt();
        if(choice == 1) {
            return new adminUser(name);
        } else if (choice == 2) {
            return new normalUser(name);
        } else {
            return null;
        }
    }
    public static void main(String[] args) {

        BookList bookList = new BookList();
        User user = login();
        while(true) {
            int choice = user.menu();
            user.doOperation(choice,bookList);
        }
    }
}
