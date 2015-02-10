/**
 * Created by Mengqi on 15/2/10.
 Write a program to find the node at which the intersection of two singly linked lists begins.


 For example, the following two linked lists:

 A:          a1 → a2
 ↘
 c1 → c2 → c3
 ↗
 B:     b1 → b2 → b3
 begin to intersect at node c1.
 */
//323ms
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //统计两链表长度
        int lengthA = 1, lengthB = 1;
        ListNode p = headA;
        while ((p = p.next) != null)
            lengthA++;
        p = headB;
        while ((p = p.next) != null)
            lengthB++;

        int minlength = lengthA > lengthB ? lengthB : lengthA;
        int shift = Math.abs(lengthA - lengthB);

        //对齐链表
        ListNode pA = headA, pB = headB;
        if (lengthA > lengthB) {
            for (int i = 0; i < shift; i++) {
                pA = pA.next;
            }
        } else {
            for (int i = 0; i < shift; i++) {
                pB = pB.next;
            }
        }

        ListNode intersectionStartNode = null;
        boolean intersectionAlready = false;//记录两链表是否交汇
        for (int i = 0; i < minlength; i++, pA = pA.next, pB = pB.next) {
            if (pA.val == pB.val) {
                if (!intersectionAlready) {
                    intersectionStartNode = pA;
                    intersectionAlready = true;
                }
            } else {
                //如果出现交汇链断裂，则复位
                if (intersectionAlready) {
                    intersectionAlready = false;
                    intersectionStartNode = null;
                }
            }
        }
        return intersectionStartNode;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        ListNode listNode4 = new ListNode(4);

        ListNode listNode5 = new ListNode(2);
        ListNode listNode6 = new ListNode(3);
        ListNode listNode7 = new ListNode(4);

//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//
//        listNode5.next = listNode6;
//        listNode6.next = listNode7;
//        listNode7.next = listNode4;

        ListNode intersectionNode = solution.getIntersectionNode(listNode2, listNode5);
        ListNode p = intersectionNode;
        if (intersectionNode != null) {
            System.out.print(intersectionNode.val + "->");
            while ((p = p.next) != null) {
                System.out.print(p.val + "->");
            }
        } else {
            System.out.println("NULL!");
        }
    }
}
