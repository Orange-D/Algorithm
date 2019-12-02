package com.orange;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created  2018/10/11.
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 */
public class Demo5 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public static void main(String[] args) {

    }

    public void push(int i) {
        stack1.push(i);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int num = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return num;
    }

}
