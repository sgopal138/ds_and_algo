package com.practice.ds.linkedlist;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data){
            this.data = data;
        }
    }
    public DoublyLinkedList(){
        head = null;
        tail = null;
        length = 0;
    }

    public boolean isEmpty(){
        return length == 0;
    }



    public void insertFirst(int data){
        ListNode node = new ListNode(data);
        if(isEmpty()){
            tail = node;
        } else {
            head.previous = node;
        }
        node.next = head;
        head = node;
        length++;
    }

    public void insertLast(int data){
        ListNode node = new ListNode(data);
        if(isEmpty()){
            head = node;
        } else {
            tail.next = node;
            node.previous = tail;
        }
        length ++;

        tail = node;
    }

    public void displayForward(){
        if(head == null){
            return;
        }
        ListNode current = head;

        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    /* Function to reverse a Doubly Linked List */
   public void reverse()
    {
        ListNode temp = null;
        ListNode current = head;

        /* swap next and prev for all nodes of
         doubly linked list */
        while (current != null) {
            temp = current.previous;
            current.previous = current.next;
            current.next = temp;
            current = current.previous;
        }

        /* Before changing head, check for the cases like
         empty list and list with only one node */
        if (temp != null) {
            head = temp.previous;
        }
    }

    int search(ListNode head_ref, int x)
    {

        // Stores head Node
        ListNode temp = head_ref;

        // Stores position of the integer
        // in the doubly linked list
        int pos = 0;

        // Traverse the doubly linked list
        while (temp.data != x
                && temp.next != null)
        {
            // Update pos
            pos++;

            // Update temp
            temp = temp.next;
        }

        // If the integer not present
        // in the doubly linked list
        if (temp.data != x)
            return -1;
        // If the integer present in
        // the doubly linked list
        return (pos + 1);
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        /*dll.insertFirst(1);
        dll.insertFirst(12);*/

        dll.insertFirst(2);
        dll.insertFirst(12);
        dll.insertFirst(22);

        dll.displayForward();

        dll.reverse();
        dll.displayForward();

    }
}
