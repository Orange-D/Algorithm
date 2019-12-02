package com.orange;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created  2018/10/9.
 * 输入一个链表，从尾到头打印链表每个节点的值
 *
 * 思路:借助栈实现，或使用递归的方法
 */
public class Demo3 {
    public static void main(String[] args) {
        ListNode listNode = createData();
        //借助栈实现
//        System.out.println(printLink(listNode));

        //使用递归实现
        printLinkecursion(listNode);
    }

    //递归输出
    public static void printLinkecursion(ListNode listNode){

        if (listNode.next != null){
            printLinkecursion(listNode.next);
        }else {
            System.out.println(listNode.value);
            return;
        }
        System.out.println(listNode.value);
    }

    //循环使用Stack栈实现
    public static ArrayList<String> printLink(ListNode listNode) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (listNode == null) return arrayList;

        Stack<ListNode> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop().value);
        }
        return arrayList;
    }

    static class ListNode {
        ListNode next;
        String value;
    }

    public static ListNode createData() {
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        ListNode listNode3 = new ListNode();
        ListNode listNode4 = new ListNode();
        ListNode listNode5 = new ListNode();
        listNode1.value = "a";
        listNode2.value = "b";
        listNode3.value = "c";
        listNode4.value = "d";
        listNode5.value = "e";
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        return listNode1;
    }
}
