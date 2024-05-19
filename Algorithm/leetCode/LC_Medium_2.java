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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean first =false, second = false;
        ListNode list1 = l1;
        ListNode list2 = l2;
        int tmp = 0;
        ListNode answer = new ListNode();
        ListNode cur = answer;
        while(!(first&&second)) {
            int f=0, s=0;
            if(!first) {
                if(list1.next == null) {
                    first = true;
                } 
                f = list1.val;
                list1 = list1.next;
            }
            if(!second) {
                if(list2.next == null) {
                    second = true;
                }
                s = list2.val;
                list2 = list2.next;
            }
           
            int sum = f+s+tmp;
            tmp = sum/10;
            cur.val = sum%10;
            if(!(first && second)) {
                cur.next = new ListNode();
            } else if(tmp == 1) {
                cur.next = new ListNode(1);
            }
            cur = cur.next;
        }
        return answer;
    }
}