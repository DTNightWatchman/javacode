import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Scanner;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2022-02-16
 * Time:15:22
 */
public class BorrowOperation implements IOperation {
    @Override
    public void work() {
        System.out.print("请输入书的ID:>");
        Scanner scanner = new Scanner(System.in);
        int bookId = scanner.nextInt();
        BookDao.BorrowBook(bookId);
    }
}
