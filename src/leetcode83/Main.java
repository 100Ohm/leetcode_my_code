package leetcode83;

/**
 * @author ohm
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(new Solution().deleteDuplicates(
                new ListNode(1,
                        new ListNode(1,
                                new ListNode(2,
                                        new ListNode(2,
                                                new ListNode(3, null)))))).toString());
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    @Override
    public String toString() {
        if(next != null)
            return Integer.toString(val) + "->" + next.toString();
        else return Integer.toString(val);
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode p1 = head, p2 = head.next;
        while(p1 != null && p2 != null) {
            while (p1.val == p2.val) {//可能null，待会改
                p2 = p2.next;
                if(p2 == null)
                    break;
            }
            p1.next = p2;
            p1 = p1.next;
            if(p2 != null)
                p2 = p2.next;
        }
        return head;
    }
}
