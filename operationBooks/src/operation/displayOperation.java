package operation;

import book.BookList;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021--
 * Time:11:34
 */
public class displayOperation implements IOoperation{
    @Override
    public void work(BookList bookList) {
        int i = 0;
        while (i < bookList.getUsedSize()) {
            System.out.println(bookList.books[i]);
            i++;
        }
    }
}
