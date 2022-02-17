import java.util.Scanner;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2022-03-03
 * Time:0:51
 */
public class NormalUser extends User{
    public NormalUser() {
        iOperation = new IOperation[] {
                new ExitOperation(),
                new ShowAllOperation(),
                new FindOperation(),
                new BorrowOperation(),
                new ReturnOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("======================");
        System.out.println("    1.查看书籍列表");
        System.out.println("    2.查找书籍");
        System.out.println("    3.借书");
        System.out.println("    4.还书");
        System.out.println("    0.退出");
        System.out.println("======================");
        System.out.print("请输入你的选择:>");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
