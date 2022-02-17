import java.util.Scanner;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2022-02-16
 * Time:15:16
 */
public class AddOperation implements IOperation {
    @Override
    public void work() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入书名:>");
        String name = scanner.next();
        System.out.print("请输入作者:>");
        String author = scanner.next();
        System.out.print("请输入书的价格:>");
        int price = scanner.nextInt();
        System.out.print("请输入书的类型:>");
        String type = scanner.next();
        book book = new book();
        book.setName(name);
        book.setAutor(author);
        book.setPrice(price);
        book.setType(type);
        if (BookDao.AddBook(book)) {
            System.out.println("增加成功");
        } else {
            System.out.println("添加图书失败");
        }
    }
}
