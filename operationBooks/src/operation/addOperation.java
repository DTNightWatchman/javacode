
package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021--
 * Time:23:46
 */
public class addOperation implements IOoperation{

    @Override
    public void work(BookList bookList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要添加的书名:");
        String name = scanner.next();
        System.out.print("请输入要添加的书的作者:");
        String writer = scanner.next();
        System.out.print("请输入要添加的书的类型:");
        String type = scanner.next();
        System.out.print("请输入要添加的书的价格:");
        int price  = scanner.nextInt();
        bookList.books[bookList.getUsedSize()] = new Book(name,writer,type,price);
        bookList.setUsedSize(bookList.getUsedSize() + 1);
    }
}
