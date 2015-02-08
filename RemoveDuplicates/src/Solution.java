/**
 * Created by Mengqi on 15/2/8.
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pointer = head;
        ListNode previous = head;
        while ((pointer = pointer.next) != null) {
            //重复
            if (previous.val == pointer.val) {
                previous.next = pointer.next;//删去pointer
                continue;
            } else {
                previous = pointer;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4; listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode result = solution.deleteDuplicates(listNode1);

        ListNode pointer = result;
        System.out.print(pointer.val + "->");
        while ((pointer = pointer.next) != null) {
            System.out.print(pointer.val + "->");
        }
    }
}
