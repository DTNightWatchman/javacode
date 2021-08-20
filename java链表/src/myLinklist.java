/**
 * created by YT
 * description:
 * User:lenovo
 * Data:2021-08-16
 * Time:17:48
 */
class Node {
    public int val;
    public Node next;
    public Node (int val) {
        this.val = val;
    }
}
public class myLinklist {
    Node head;

    public Node searchPrev(int index) {
        Node cur = this.head;
        int i = 0;
        while(i < index - 1) {
            cur = cur.next;
            i++;
        }
        return cur;
    }
    public Node searchPrevNode(int key) {
        Node cur = this.head;
        while (cur.next != null) {
            if(cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    public void show() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    //得到单链表的长度
    public int size() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //头插法
    public void addToHead(int val) {
        Node node = new Node(val);
        if (head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }
    //尾插法
    public void addTolast(int val) {
        Node node = new Node(val);
        if (head == null) {
            this.head = node;
        } else {
            Node nur = this.head;
            while (nur.next != null) {
                nur = nur.next;
            }
            nur.next = node;
        }
    }
    //在某个位置插入一个数据：
    public void addIndex(int val, int pos) {
        if(pos > this.size() || pos < 0) {
            System.out.println("位置不合法");
            return;
        }
        Node node = new Node(val);
        if(pos == 0) {
            node.next = head;
            head = node;
            return;
        }
        Node cur = this.searchPrev(pos);
        node.next = cur.next;
        cur.next = node;
    }
    //删除某个数第一次出现的那个节点
    public void indexDel(int key) {
        if (this.head == null) {
            System.out.println("链表为空");
            return;
        }
        if(head.val == key) {
            head = head.next;
            System.out.println("删除成功");
        } else {
            Node cur = searchPrevNode(key);
            if(cur == null) {
                System.out.println("没有这个数值，无法删除");
                return;
            }
            while(cur.next.val != key) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            System.out.println("删除成功");
        }
    }
    public void removeAllKey(int key) {
        Node cur = head.next;
        Node prev = head;
        while(cur != null) {
            if(cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }
        if(head.val == key) {
            head = head.next;
        }
    }
    public void reMoveAllKeyOtherWay(int key) {
        Node prev = head;
        while (prev.next != null) {
            if(prev.next.val == key) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        if(head.val == key) {
            head = head.next;
        }
    }
    public void clear() {
        Node nextCure = this.head.next;
        while(this.head != null) {
            nextCure = this.head.next;
            this.head.next = null;
            this.head = nextCure;
        }
    }
    //链表翻转
    public void reverseList() {
        Node nextCur = head;
        Node cur = this.head;
        Node newHead = null;
        while (cur != null) {
            nextCur = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = nextCur;
        }
        this.head = newHead;
    }
    //循环一遍找到链表中间的值(快慢指针)
    public Node findMid() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //找到链表的倒数第n个节点
    public Node findFromLast(int n) {
        if(head == null) {
            return null;
        }
        if(n < 0) {
            return null;
        }
        Node fast = this.head;
        Node slow = this.head;
        for(int i = 1; i <= n - 1; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //将两个有序的链表合并成一个有序的链表。
    public static Node addList(Node head1,Node head2) {
        if(head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if(head1 == null && head2 == null) {
            return null;
        }
        Node newHead = null;
        Node cur = null;
        Node h1 = head1;
        Node h2 = head2;
        while(h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                if(newHead == null) {
                    newHead = h1;
                    cur = newHead;
                } else {
                    cur.next = h1;
                    cur = cur.next;
                }
                h1 = h1.next;
            } else {
                if(newHead == null) {
                    newHead = h2;
                    cur = newHead;
                } else {
                    cur.next = h2;
                    cur = cur.next;
                }
                h2 = h2.next;
            }
        }
        if(h2 == null) {
            cur.next  = h1;
        } else {
            cur.next = h2;
        }
        return newHead;

    }
}
