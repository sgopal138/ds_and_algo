package com.practice.ds.linkedlist;

public class SinglyLinkedList {
    private ListNode head;

    static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private void insertFirst(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    private void insertLast(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        if (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    private ListNode deleteFirst(){
        if(head == null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
    //11 > 5 > 9 > null
    private ListNode deleteLast(){
        if(head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;
        while(current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    private boolean find(ListNode head, int serarchKey){
        if(head == null){
            return false;
        }

        ListNode current = head;
        while(current != null){
            if(current.data == serarchKey)
                return true;
            current = current.next;
        }
        return false;
    }

    private void dispaly() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.print("null");
    }

    private int length() {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            ++count;
            current = current.next;
        }
        return count;


    }

    private ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode next = null;
        ListNode previous = null;

        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.head = new ListNode(1);
        ListNode second = new ListNode(8);
        ListNode third = new ListNode(22);
        ListNode fourth = new ListNode(6);

        linkedList.head.next = second;
        second.next = third;
        third.next = fourth;

        /*System.out.println("Inserting Node start of the Signly Linked List");
        linkedList.insertFirst(11);
        linkedList.insertFirst(5);
        linkedList.insertFirst(7);
        linkedList.insertFirst(15);*/

       /* System.out.println("Inserting Node last of the Signly Linked List");
        linkedList.insertLast(11);
        linkedList.insertLast(5);
        linkedList.insertLast(7);
        linkedList.insertLast(15);*/

        /*System.out.println("Delete First Node of the Signly Linked List");
        linkedList.deleteFirst();
        linkedList.dispaly();
        System.out.println();*/

        /*System.out.println("Delete Last Node of the Signly Linked List");
        linkedList.deleteLast();
        linkedList.dispaly();
        System.out.println();*/

        /*System.out.println("Find node in linked list");
        if(linkedList.find(linkedList.head, 145)){
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
        System.out.println();*/

        //print length of singly link list
        System.out.println("Length of Singly Link List - " + linkedList.length());

        System.out.println("Reverse Linkedlist");
        ListNode reveseListNode = linkedList.reverse(linkedList.head);
        linkedList.reverse(reveseListNode);

        linkedList.dispaly();
        System.out.println();
    }
}
