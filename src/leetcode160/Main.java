package leetcode160;

public class Main {

    public static void main(String[] args) {
        //测试用例1，有相交
        ListNode a = new ListNode(new ListNode(new ListNode(null)));
        ListNode l1 = new ListNode(new ListNode(a));
        ListNode l2 = new ListNode(a);
        System.out.println(isIntersect(l1, l2));
        //测试用例2，不相交
        ListNode m1 = new ListNode(new ListNode(new ListNode(null)));
        ListNode m2 = new ListNode(new ListNode(new ListNode(null)));
        System.out.println(isIntersect(m1, m2));
        //测试用例3，null
        ListNode k1 = null;
        ListNode k2 = new ListNode(new ListNode(null));
        System.out.println(isIntersect(k1, k2));
    }

    public static boolean isIntersect(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        int num1 = 0, num2 = 0;//链表长度
        while(p1 != null) {
            p1 = p1.next;
            num1++;
        }
        while(p2 != null) {
            p2 = p2.next;
            num2++;
        }
        int d = Math.abs(num1 - num2);
        p1 = headA;
        p2 = headB;
        while(d != 0) {//长的链表指针前移d位
            if(num1 > num2){
                p1 = p1.next;
            } else {
                p2 = p2.next;
            }
            d--;
        }

        while(p1 != null && p2 != null && p1 != p2) {//逐个比较
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1 != null && p2 != null;
    }

}
class ListNode {
    ListNode next;
    int val;
    ListNode(ListNode next){
        this.next = next;
    }
}
