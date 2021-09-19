package operation;

import book.BookList;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021--
 * Time:11:34
 */
public class exitOperation implements IOoperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统");
        System.exit(0);
    }
}
