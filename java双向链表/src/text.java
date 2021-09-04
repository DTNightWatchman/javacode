/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021-09-02
 * Time:20:16
 */
public class text {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.addToLast(1);
        list.addToLast(1);
        list.addToLast(3);
        list.addToLast(4);
        list.show();
        list.remove(1);
        //list.remove(4);
        list.show();
        System.out.println("========");
        list.clear();
        list.show();
    }
}
