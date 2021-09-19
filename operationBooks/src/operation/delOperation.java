package operation;

import book.BookList;

import java.util.Scanner;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021--
 * Time:11:33
 */
public class delOperation implements IOoperation{
    @Override
    public void work(BookList bookList) {
        System.out.print("请输入删除的图书的名字：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int i = 0;
        while(i < bookList.getUsedSize()) {
            if(bookList.books[i].getName().compareTo(name) == 0) {
                int j = i;
                while(j < bookList.getUsedSize() - 1) {
                    bookList.books[j] = bookList.books[j + 1];
                    j++;
                }
                bookList.setUsedSize(bookList.getUsedSize() - 1);
                System.out.println("删除成功");
                return;
            }
            i++;
        }
        System.out.println("没有这本书，删除失败~");
    }
}
