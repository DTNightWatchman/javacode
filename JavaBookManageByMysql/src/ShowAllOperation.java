import java.util.List;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2022-02-16
 * Time:15:10
 */
public class ShowAllOperation implements IOperation{
    @Override
    public void work() {
        List<book> books = BookDao.ShowBooks();
        for (book book :books) {
            System.out.println(book);
        }
        System.out.println("显示完毕");
    }
}
