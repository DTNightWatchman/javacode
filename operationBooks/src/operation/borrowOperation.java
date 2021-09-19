package operation;

import book.BookList;

import java.util.Scanner;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021--
 * Time:11:35
 */
public class borrowOperation implements IOoperation{

    @Override
    public void work(BookList bookList) {
        System.out.print("请输入借阅的图书的名字：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int i = 0;
        while(i < bookList.getUsedSize()) {
            if(bookList.books[i].getName().compareTo(name) == 0 && bookList.books[i].isB() == false) {
                bookList.books[i].setB(true);
                System.out.println("借书成功");
                return;
            } else if (bookList.books[i].getName().compareTo(name) == 0 && bookList.books[i].isB() == true) {
                System.out.println("这本书已被借走");
                return;
            }
            i++;
        }
        System.out.println("没有这本书，借书失败");

    }
}
