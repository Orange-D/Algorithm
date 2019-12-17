package com.orange;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 */
public class Demo19 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(3);
//        listNode.next = listNode1;
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = null;
        removeNthFromEnd(listNode, 1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode node1 = head;
        ListNode nodeN = head;
        for (int i = 0; i < n; i++) {
            nodeN = nodeN.next;
        }

        while (nodeN!=null && nodeN.next != null) {
            node1 = node1.next;
            nodeN = nodeN.next;
        }
        if (nodeN == null){
            head = node1.next;
        }else {
            node1.next = node1.next.next;
        }
//        if (n == 1){
//            node1.next = null;
//        }else {
//            if (node1.next.next != null)
//                node1.next = node1.next.next;
//            else {
//                head = node1.next;
//            }
//        }
        return head;
    }


    public static class ListNode {
        int val;

        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }

}
