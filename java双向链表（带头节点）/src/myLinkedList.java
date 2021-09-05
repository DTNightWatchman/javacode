import com.sun.media.jfxmedia.events.PlayerStateListener;

import javax.management.remote.rmi._RMIConnection_Stub;

/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021-09-04
 * Time:17:18
 */
class Node {
    public int val;
    public Node next;
    public Node prev;
    public Node(int val) {
        this.val = val;
    }
}
public class myLinkedList {
    Node head = new Node(-1);
    Node last = head;
    public void addToHead(int val) {
        Node node =  new Node(val);
        node.next = this.head.next;
        if(this.head == this.last) {
            this.last = node;
            node.prev = this.head.next;

        } else {
             node.next = this.head.next;
             node.prev = this.head;
        }
        this.head.next = node;
    }
    public void show() {
        if(this.head == null) {
            return;
        }
        Node cur = this.head.next;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void show2() {
        Node cur = this.last;
        while(cur != this.head) {
            System.out.print(cur.val + " ");
            cur = cur.prev;
        }
        System.out.println();
    }
    public void addToLast(int val) {
        Node node = new Node(val);
        if(this.head == this.last) {
            this.last = node;
            node.prev = this.head;
            this.head.next = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }
    public int getsize() {
        Node cur = this.head.next;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        //System.out.println(count);
        return count;
    }
    public Node getIndex(int index) {
        Node cur = this.head.next;
        while(index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }
    public void addToIndex(int x,int index) {
        if(index >= getsize() || index < 0 ) {
            System.out.println("位置不合法");
        } else {
            Node node = new Node(x);
            if(index == getsize() - 1) {
                node.prev = this.last;
                this.last.next = node;
                this.last = node;
            } else {
                Node cur = getIndex(index);
                node.next = cur;
                node.prev = cur.prev;
                cur.prev.next = node;
                cur.prev = node;
            }
        }
    }
    public boolean contains(int val) {
        Node cur = this.head.next;
        while(cur != null) {
            if(cur.val == val) {
                return true;
            }
        }
        return false;
    }
    //删除第一个值为key的节点
    public void remove(int key) {
        Node cur = this.head.next;
        while (cur != null) {
            if(cur.val == key) {
                if(cur == this.last) {
                    this.last = cur.prev;
                    this.last.next = null;
                    return;
                }
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                return;
            }
            cur = cur.next;
        }
    }
    public void removeAllKey(int key) {
        Node node = new Node(key);
        Node cur = this.head.next;
        while (cur != null) {
            if(cur.val == key) {
                if(cur == this.last) {
                    this.last = cur.prev;
                    cur.next = null;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;
        }
    }
    public void clear() {
        Node cur = this.head;
        while(cur != null) {
            Node curNext = cur.next;
            cur.next = null;
            cur.prev = null;
            cur = curNext;
        }
        this.head = null;
        this.last = null;
    }
}
