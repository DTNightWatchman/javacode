package user;

import operation.*;

import java.util.Scanner;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021--
 * Time:0:12
 */
public class adminUser extends User{

    public adminUser(String name) {
        super(name);
        super.operations = new IOoperation[] {
                new exitOperation(),
                new findOperation(),
                new addOperation(),
                new delOperation(),
                new displayOperation()
        };
    }



    @Override
    public int menu() {
        System.out.println("hello " + this.name + "，欢迎来到图书管理系统");
        System.out.println("===============管理员菜单==================");
        System.out.println("1. 查找图书");
        System.out.println("2. 新增图书");
        System.out.println("3. 删除图书");
        System.out.println("4. 显示所有图书");
        System.out.println("0. 退出系统");
        System.out.println("========================================");
        System.out.print("请输入你所需要的服务项目:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
