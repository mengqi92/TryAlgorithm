/**
 * Created by Mengqi on 15/4/28.
 * 424 ms
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        //清理前排所有匹配元素
        while(head!=null && head.val == val)
            head = head.next;

        if(head == null) return head;

        ListNode pre = head, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);

        ListNode listNode4 = new ListNode(1);

        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);
        ListNode listNode7 = new ListNode(6);

//        listNode1.next = listNode2; listNode2.next = listNode3; listNode3.next = listNode4;
//        listNode4.next = listNode5; listNode5.next = listNode6; listNode6.next = listNode7;

        ListNode listNode = solution.removeElements(listNode1, 1);
        ListNode p = listNode;
        if (listNode != null) {
            System.out.print(listNode.val + "->");
            while ((p = p.next) != null) {
                System.out.print(p.val + "->");
            }
        } else {
            System.out.println("NULL!");
        }
    }
}
