/**
 * created by YT
 * description:
 * User:mlenovo
 * Data:2021-08-16
 * Time:18:03
 */
public class textdemo {
    public static void main(String[] args) {
        myLinklist list = new myLinklist();

        list.addToHead(12);
        list.addToHead(3);
        list.addToHead(2);
        list.addToHead(5);
        list.addToHead(2);
        list.addTolast(13);
        list.show();
        //list.removeAllKey(2);
        list.reMoveAllKeyOtherWay(13);
        list.show();
        System.out.println("=================");
        //list.clear();
        //list.reverseList();
        //list.addTolast(13);
        list.show();
        Node mid = list.findMid();
        System.out.println(mid.val);
        Node l = list.findFromLast(-1);
        System.out.println(l);
        System.out.println("========================");
        myLinklist list1 = new myLinklist();
        myLinklist list2 = new myLinklist();
        list1.addTolast(1);
        list1.addTolast(2);
        list1.addTolast(3);
        list1.addTolast(7);
        list1.addTolast(9);
        list1.addTolast(10);
        list1.addTolast(11);
        list1.addTolast(12);
        list2.addTolast(4);
        list2.addTolast(6);
        list2.addTolast(8);
        list2.addTolast(11);
        myLinklist sumList = new myLinklist();
        sumList.head = myLinklist.addList(list1.head,list2.head);
        sumList.show();
    }
}
