package com.practice.ds.stack;

import java.util.EmptyStackException;

public class StackDemo {

    private ListNode top;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;

        ListNode(int data) {
            this.data = data;
        }
    }

    public StackDemo() {
        top = null;
        length = 0;
    }

    private void push(int data) {
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    private int pop() {
        if (length == 0) {
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    private int peek() {
        if (length == 0) {
            throw new EmptyStackException();
        }
        return top.data;
    }


    public static void main(String[] args) {
        StackDemo demo = new StackDemo();
        demo.push(10);
        demo.push(15);
        demo.push(20);

        System.out.println(demo.peek());

        demo.pop();

        System.out.println(demo.peek());
    }
}