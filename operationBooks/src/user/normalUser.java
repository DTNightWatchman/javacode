package user;

import book.BookList;
import operation.*;

import java.util.Scanner;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021-09-18
 * Time:14:11
 */
public class normalUser extends User{

    public normalUser(String name) {
        super(name);
        this.operations = new IOoperation[] {
                new exitOperation(),
                new findOperation(),
                new borrowOperation(),
                new returnOperation()

        };
    }



    @Override
    public int menu() {
        System.out.println("hello " + super.name + ", 欢迎来到图书管理系统");
        System.out.println("===================用户菜单=================");
        System.out.println("1. 查找图书");
        System.out.println("2. 借阅图书");
        System.out.println("3. 归还图书");
        System.out.println("0. 退出系统");
        System.out.println("==========================================");
        System.out.print("请输入你所选择的服务项目:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
