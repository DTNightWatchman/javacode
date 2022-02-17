import java.util.Scanner;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2022-03-03
 * Time:0:50
 */
public class Admin extends User{
    public Admin() {
        iOperation = new IOperation[]{
                new ExitOperation(),
                new ShowAllOperation(),
                new FindOperation(),
                new AddOperation(),
                new DeleteOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("=======================");
        System.out.println("     1.查看书籍列表");
        System.out.println("     2.查找书籍");
        System.out.println("     3.新增书籍");
        System.out.println("     4.删除书籍");
        System.out.println("     0.退出");
        System.out.println("=======================");
        System.out.print("请输入你的选择:>");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
