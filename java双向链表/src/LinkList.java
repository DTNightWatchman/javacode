/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021-09-02
 * Time:20:17
 */
class Node {
    public int val;
    public Node prev;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}
public class LinkList {
    public Node head = null;
    public Node last = null;
    public void show() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public int sizeOflink() {
        int count = 0;
        Node cur = this.head;
        while(cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
    public void addToHead(int n) {
        Node cur = new Node(n);
        if(head == null) {
            this.head = cur;
            this.last = cur;
        } else {
            cur.next = this.head;
            this.head.prev = cur;
            head = cur;
        }
    }
    public void addToLast(int n) {
        Node cur = new Node(n);
        if(last == null) {
            this.head = cur;
            this.last = cur;
        } else {
            this.last.next = cur;
            cur.prev = last;
            last = cur;
        }
    }
    public Node findIndex(int index) {
        if (index < 0) {
            return null;
        }
        if(index >sizeOflink()) {
            return null;
        }
        Node cur = this.head;
        while(index != 0) {
            cur = cur.next;
            index--;
        }
        return cur;
    }
    public void addToIndex(int n,int index) {
        Node cur = findIndex(index);
        Node node = new Node(n);
        if(cur == null) {
            System.out.println("位置不合法");
            return;
        }
        if(cur == this.head) {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        } else if (cur == this.last) {
            node.prev = last;
            last.next = node;
            this.last = node;
        } else {
            node.next = cur;
            node.prev = cur.prev;
            cur.prev.next = node;
            cur.prev = node;
        }
    }
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public void remove(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.val == key) {
                if(this.head == this.last) {
                    this.head = null;
                    this.last = null;
                    return;
                }
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else if(cur == this.last) {
                    this.last = this.last.prev;
                    this.last.next = null;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
                return;
            }
            cur = cur.next;
        }
    }
    //删除所有有key值的节点
    public void removeAllKey(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.val == key) {
                if(this.head == this.last) {
                    this.head = null;
                    this.last = null;
                    return;
                }
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else if(cur == this.last) {
                    this.last = this.last.prev;
                    this.last.next = null;
                } else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;
        }
    }
    //清除双向链表
    public void clear() {
        Node cur = this.head;
        while(cur != null) {
            Node curNext = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = cur.next;
        }
        this.head = null;
        this.last = null;
    }
}
