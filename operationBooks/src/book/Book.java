package book;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021-09-17
 * Time:22:09
 */
public class Book {
    private String name;
    private String writer;
    private String type;
    private int price;
    private boolean isB;

    public Book(String name, String writer, String type, int price) {
        this.name = name;
        this.writer = writer;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isB() {
        return isB;
    }

    public void setB(boolean b) {
        isB = b;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", writer='" + writer + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", isBoorow=" + isB +
                '}';
    }
}
