/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021-08-15
 * Time:20:15
 */

public class demo {

    public static void main(String[] args) {
        myArrayList list = new myArrayList();
        list.usedSize = 10;
        for (int i = 0; i < list.usedSize; i++) {
            list.elem[i] = i + 1;
        }
        list.disPlay();
        list.add(2,10);
        list.disPlay();
        int key = 11;
        boolean flag = list.contains(key);
        System.out.println(flag);
        int ret = list.search(key);
        System.out.println(ret);
        int ret2 = list.getPos(10);
        System.out.println(ret2);
        list.remove(10);
        list.remove(10);
        list.disPlay();
        System.out.println("==================");
        list.clear();
        list.disPlay();
    }
}

