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

 // head = [0,1,2,3]
//  Output: [3,2,1,0]


class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null ) {
            ListNode temp = curr.next; // 1, 2
            curr.next = prev; // null, 1
            prev = curr; // 0, 1
            curr = temp; // 1, 2

            // prev
            // [1, 0]
        }

        return prev;
    }
}
