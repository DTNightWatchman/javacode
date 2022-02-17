import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.List;
import java.util.Scanner;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2022-02-16
 * Time:15:15
 */
public class FindOperation implements IOperation {
    @Override
    public void work() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要查找的书的名字:>");
        String name = scanner.next();
        List<book> books = BookDao.FindBook(name);
        for (book book: books) {
            System.out.println(book);
        }
    }
}
