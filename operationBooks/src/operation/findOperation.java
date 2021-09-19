package operation;

import book.BookList;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.Scanner;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021--
 * Time:11:33
 */
public class findOperation implements IOoperation {
    @Override
    public void work(BookList bookList) {
        System.out.print("请输入查找的图书的名字：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int i = 0;
        while(i < bookList.getUsedSize()) {
                if(bookList.books[i].getName().compareTo(name) == 0) {
                System.out.println("存在这本书，序号是：" + i);
                return;
            }
            i++;
        }
        System.out.println("不存在这部书");
    }
}
