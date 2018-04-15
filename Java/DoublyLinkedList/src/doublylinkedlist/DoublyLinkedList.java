/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist;

/**
 *
 * @author Sami
 */
public class DoublyLinkedList<T extends Comparable<T>> {

    private Node first;
    private Node last;

    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    private void print() {
        StringBuilder s = new StringBuilder();
        Node p = first;
        while (p != null) {
            s.append(p.data + " ");
            p = p.next;
        }

        System.out.println(s.toString());
    }

    private void print_reverse() {
        StringBuilder s = new StringBuilder();
        Node p = last;
        while (p != null) {
            s.append(p.data + " ");
            p = p.prev;
        }

        System.out.println(s.toString());
    }

    private void insert_to_back(T item) {
        if (first == null) {
            first = new Node(item, null, null);
            last = first;
        } else {
            Node prevLast = last;
            last = new Node(item, null, prevLast);
            prevLast.next = last;
        }
    }

    private void insert_to_front(T item) {
        Node prevFirst = first;
        Node newFirst = new Node(item, first, null);
        first = newFirst;
        prevFirst.prev = first;
    }

    //Node class
    private class Node {

        private T data;
        private Node next;
        private Node prev;

        public Node(T data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {

        DoublyLinkedList<Integer> dbl = new DoublyLinkedList<Integer>();
        int order_no;
        char to_be_searched;
        dbl.print();
        dbl.print_reverse();
        dbl.insert_to_back(10);
        dbl.print();
        dbl.print_reverse();
        dbl.insert_to_front(20);
        dbl.print();
        dbl.print_reverse();
        dbl.insert_to_back(30);
        dbl.print();
        dbl.print_reverse();
        dbl.insert_to_front(40);
        dbl.print();
        dbl.print_reverse();
        dbl.insert_to_back(50);
        dbl.print();
        dbl.print_reverse();

    }

}
