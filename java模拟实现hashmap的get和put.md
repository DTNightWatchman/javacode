```java
/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2022-01-14
 * Time:10:39
 */
class HashBuck {
    static class Node {
        public int k;
        public int val;
        public Node next;

        public Node(int k, int val) {
            this.k = k;
            this.val = val;
        }
    }
    public int usedSize = 0;
    public Node[] array;
    public HashBuck() {
        this.array = new Node[8];
    }
    public int get(int key) {
        int index = key % array.length;
        Node node = array[index];
        while(node != null) {
            if(node.k == key) {
                return  node.val;
            }
            node = node.next;
        }
        return -1;//找不到
    }
    public void put(int key,int val) {
        Node node = new Node(key, val);
        int index = key % array.length;
        Node cur = this.array[index];
        while(cur != null) {
            if(cur.k == key) {
                //换掉原来的值
                cur.val = val;
                return;
            }
            cur = cur.next;
        }
        cur = this.array[index];
        //找到最后一个节点
        if(cur == null) {
            this.array[index] = node;
        } else {
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
        this.usedSize++;
        //如果负载因子大于0.75就要扩容
        if(loadFactor() >= 0.75) {
            resize();
        }
        return;
    }
    //计算负载因子
    public double loadFactor() {
        return this.usedSize * 1.0 / array.length;
    }
    public void resize() {
        Node[] newArray = new Node[array.length * 2];
        for(int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while(cur != null) {
                Node curNext = cur.next;
                int index = cur.k % newArray.length;
                Node newCur = newArray[index];
                if(newCur == null) {
                    newArray[index] = cur;
                } else {
                    while(newCur.next != null) {
                        newCur = newCur.next;
                    }
                    newCur.next = cur;
                }
                cur.next = null;
                cur = curNext;
            }
        }
        System.out.println("扩容");
        this.array = newArray;
    }
}
public class demo {
    public static void main(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.put(1,11);
        hashBuck.put(2,22);
        hashBuck.put(3,33);
        hashBuck.put(17,177);
        hashBuck.put(24,244);
        hashBuck.put(15,177);
        System.out.println(hashBuck.usedSize);
    }
}

```

