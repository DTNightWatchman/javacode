package book;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021-09-17
 * Time:22:56
 */
public class BookList {
    private int usedSize;
    public Book[] books = new Book[10];
    public BookList() {
        books[0] = new Book("红楼梦", "曹雪芹", "小说", 18);
        books[1] = new Book("西游记", "施耐庵", "小说", 19);
        books[2] = new Book("三国演义", "罗贯中", "小说", 20);
        this.usedSize = 3;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

}
