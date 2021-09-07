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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode(-1);
        ListNode prev = newHead;
        ListNode cur = head;
        ListNode curNext;
        newHead.next = head;
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }
        for(int i = 0; i < length / k; i++) {
            int j = 0;
            while(j < k - 1) {
                curNext = cur.next;
                cur.next = curNext.next;
                curNext.next = prev.next;
                prev.next = curNext;
                j++;
            }
            prev = cur;
            cur = cur.next;
        }
        return newHead.next;
    }
}
```

