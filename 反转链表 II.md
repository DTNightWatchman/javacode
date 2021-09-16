```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode fast = head;
        ListNode slow = head;
        int i = left;
        ListNode prev = newHead;
        while(i-1 > 0) {
            prev = prev.next;
            slow = slow.next;
            i--;
        }
        i = right;
        while(i-1 > 0) {
            fast = fast.next;
            i--;
        }
        ListNode ae = head;
        prev.next = null;
        ListNode be = fast.next;
        fast.next = null;
        
        ListNode curPrev = null;
        ListNode cur = slow;
        while(cur != null) {
            ListNode curNext = cur.next;
            cur.next = curPrev;
            curPrev = cur;
            cur = curNext;
        }
        prev.next = fast;
        slow.next = be;
        return newHead.next;
    }
}
```

