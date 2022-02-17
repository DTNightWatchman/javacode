import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Scanner;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2022-02-16
 * Time:15:23
 */
public class ReturnOperation implements IOperation {
    @Override
    public void work() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入还书的ID:>");
        int bookId = scanner.nextInt();
        BookDao.ReturnBook(bookId);
    }
}
