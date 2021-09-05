/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021-09-04
 * Time:17:18
 */
public class text {
    public static void main(String[] args) {
        myLinkedList list = new myLinkedList();
        list.addToLast(1);
        list.addToLast(2);
        list.addToLast(3);
        list.addToLast(4);
        list.addToIndex(99,1);
        list.show();
        //list.show();
        //list.show2();
        System.out.println("=============");
        list.clear();
        list.show();
    }
}
