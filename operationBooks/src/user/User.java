package user;

import book.BookList;
import operation.IOoperation;

import java.util.LinkedList;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021--
 * Time:0:12
 */
public abstract class User {
    protected String name;
    protected IOoperation[] operations;
    public User(String name) {
        this.name = name;
    }

    public abstract int menu();
    public void doOperation(int choice, BookList bookList) {
        operations[choice].work(bookList);
    }

}
