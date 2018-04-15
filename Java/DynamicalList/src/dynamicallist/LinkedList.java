package dynamicallist;

import java.util.Scanner;

public class LinkedList<T extends Comparable<T>> {

    private Node first;

    public LinkedList() {
        first = null;
    }

    public void add(T item) {
        if (first != null) {
            Node newnode = first;
            while (newnode.next != null) {
                newnode = newnode.next;
            }
            newnode.next = new Node(item, null);
        } else {
            first = new Node(item, null);
        }
    }

    private void delete_last() {
        if (first != null) {
            if (first.next == null) {
                delete_first();
            } else {
                Node newnode = first;
                while (newnode.next != null) {
                    if (newnode.next.next == null) {
                        newnode.next = null;
                    } else {
                        newnode = newnode.next;
                    }
                }
            }
        }
    }

    private void insert_to_end(T item) {
        this.add(item);
    }

    private int find_pos_in_list(T item) {
        int i = 0;
        Node newnode = first;
        while(newnode != null){
            if(newnode.data.equals(item)){
                return i;
            }
            newnode = newnode.next;
            i++;
        }
        return -1;
    }

    private void delete_first() {
        first = first.next;
    }

    private class Node {

        private T data;
        private Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node p = first;
        while (p != null) {
            s.append(p.data + " ");
            p = p.next;
        }

        return s.toString();
    }

    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<Character>();
        Scanner s = new Scanner(System.in);
        int order_no;
        char to_be_searched;
        try {
            list.delete_last();
            list.insert_to_end('?');
            list.delete_last();
            list.insert_to_end('x');
            list.insert_to_end('a');
            list.insert_to_end('b');
            list.insert_to_end('c');
            list.insert_to_end('d');
            list.insert_to_end('y');
            System.out.println("List: " + list);
            System.out.print("Enter first character to be searced ? ");
            to_be_searched = s.next().charAt(0);
            if ((order_no = list.find_pos_in_list(to_be_searched)) >= 0) {
                System.out.println("The order no is " + order_no);
            } else {
                System.out.println("Not found");
            }
            System.out.print("Enter second character to be searced ? ");
            to_be_searched = s.next().charAt(0);
            if ((order_no = list.find_pos_in_list(to_be_searched)) >= 0) {
                System.out.println("The order no is " + order_no);
            } else {
                System.out.println("Not found");
            }
            list.delete_first();
            System.out.println("List: " + list);
            list.delete_last();
            System.out.println("List: " + list);
        } catch (Exception e) {
            System.out.println("Exception " + e);
        }
    }
}
