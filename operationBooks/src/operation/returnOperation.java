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
public class returnOperation implements IOoperation{
    @Override
    public void work(BookList bookList) {
        System.out.print("请输入查找的图书的名字：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int i = 0;
        while(i < bookList.getUsedSize()) {
            if(bookList.books[i].getName().compareTo(name) == 0 && bookList.books[i].isB() == true) {
                bookList.books[i].setB(false);
                System.out.println("还书成功");
                return;
            } else if (bookList.books[i].getName().compareTo(name) == 0 && bookList.books[i].isB() == false) {
                System.out.println("这本书已经归还，还书失败");
                return;
            }
            i++;
        }
    }
}
