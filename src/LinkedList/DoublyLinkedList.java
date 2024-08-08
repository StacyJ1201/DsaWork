package LinkedList;

import javax.naming.LinkLoopException;

public class DoublyLinkedList {
    public static void main(String[] args) {
        LinkedList.append(2);
        LinkedList.append(3);
        LinkedList.append(6);
        LinkedList.prepend(1);
        LinkedList.insert(4);
        LinkedList.insert(5);

        LinkedList.displayList();

        LinkedList.delete(4);
        LinkedList.displayList();

        LinkedList.insert(7);
        LinkedList.displayList();
        LinkedList.reverse();
    }
    static class Node{
        int data;
        Node next;
        Node previous;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    static class LinkedList{
        static Node start;
        static Node last;

        public static void append(int data){
            if (start == null){
                start = new Node(data);
                last = start;
                return;
            }
            Node newLast = new Node(data);
            last.next = newLast;
            newLast.previous = last;
            newLast.next = null;
            last = newLast;
        }

        public static void prepend(int data){
            if (start == null){
                start = new Node(data);
                last = start;
                return;
            }
            Node newStart = new Node(data);
            start.previous = newStart;
            newStart.next = start;
            newStart.previous = null;
            start = newStart;
        }

        public static void insert(int data){
            if (start == null){
                start = new Node(data);
                last = start;
                return;
            }
            Node current = start;
            Node previous = null;
            while (current.data < data){
                if (current.next == null){
                    Node newLast = new Node(data);
                    last.next = newLast;
                    newLast.previous = last;
                    newLast.next = null;
                    last = newLast;
                    return;
                }
                previous = current;
                current = current.next;
            }
            Node newNode = new Node(data);
            current.previous = newNode;
            assert previous != null : "Previous cannot be null";
            previous.next = newNode;
            newNode.previous = previous;
            newNode.next = current;
        }

        public static void delete(int data){
            if (start.data == data){
                start = start.next;
                start.previous = null;
            } else if (last.data == data) {
                last = last.previous;
                last.next = null;
            } else {
                Node current = start;
                Node previous = null;

                while (current.data != data){
                    previous = current;
                    current = current.next;
                }
                previous.next = current.next;
                current.next.previous = previous;
                current = null;
            }
        }

        public static void reverse(){
            Node current = last;
            while (current.previous != null){
                System.out.print(current.data + " --> ");
                current = current.previous;
            }
            System.out.println(current.data);
        }

        public static void displayList(){
            Node current = start;
            while (current.next != null){
                System.out.print(current.data + " --> ");
                current = current.next;
            }
            System.out.println(current.data);
        }
    }
}
