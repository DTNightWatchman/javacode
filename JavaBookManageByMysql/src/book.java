/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2022-03-03
 * Time:0:48
 */
public class book {
    private int bookId;
    private String name;
    private String autor;
    private int price;
    private String type;
    private int isBorrowed;

    @Override
    public String toString() {
        return "book{" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ", autor='" + autor + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }

    public int getBookId(int bookId) {
        return this.bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(int isBorrowed) {
        this.isBorrowed = isBorrowed;
    }
}
