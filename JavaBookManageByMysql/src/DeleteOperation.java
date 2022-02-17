import java.util.Scanner;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2022-02-16
 * Time:15:17
 */
public class DeleteOperation implements IOperation{
    @Override
    public void work() {
        System.out.print("请输入书的ID:>");
        Scanner scanner = new Scanner(System.in);
        int bookId = scanner.nextInt();
        Boolean ret = BookDao.DeleteBook(bookId);
        if (ret) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }
}
