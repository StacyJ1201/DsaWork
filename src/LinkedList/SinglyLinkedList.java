package LinkedList;

public class SinglyLinkedList {
    public static void main(String[] args) {
        LinkedList.append(10);
        LinkedList.prepend(9);
        LinkedList.prepend(8);
        LinkedList.prepend(7);
        LinkedList.prepend(6);
        LinkedList.prepend(5);
        LinkedList.prepend(4);
        LinkedList.prepend(3);
        LinkedList.prepend(2);
        LinkedList.prepend(1);
        LinkedList.displayList();

        LinkedList.reverse();
        LinkedList.displayList();

    }

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static class LinkedList{

        static Node start;
        static Node last;

        public static void append(int data){
            if(start == null){
                start = new Node(data);
                last = start;
                return;
            }
            Node newLast = new Node(data);
            last.next = newLast;
            last = newLast;
        }

        public static void prepend(int data){
            if(start == null){
                start = new Node(data);
                last = start;
                return;
            }
            Node newStart = new Node(data);
            newStart.next = start;
            start = newStart;
        }

        public static void insert(int searchedNum, int data){
            Node current = start;
            while (current.data != searchedNum){
                current = current.next;
            }
            Node temp = current.next;
            current.next = new Node(data);
            current = current.next;
            current.next = temp;
        }

        private static void delete(int data){
            if (start == null){
                System.out.println("Empty list");
                return;
            }

            Node current = start;
            Node previous = null;

            if (current.data == data){
                start = start.next;
                return;
            }
            while (current.data != data){
                previous = current;
                current = current.next;
            }
            if (current.next == null){
                last = previous;
            }
            previous.next = current.next;
            current.next = null;
        }

        public static void reverse(){
            if (start.next == null){
                System.out.println("only one node");
                return;
            }
            if (start.next.next == null){
                System.out.print(start.next.data + " ");
                System.out.println(start.data);
                return;
            }

            Node ptr1 = start;
            Node ptr2 = start.next;
            Node ptr3 = start.next.next;

            ptr1.next = null;
            ptr2.next = ptr1;

            while (ptr3 != null){
                ptr1 = ptr2;
                ptr2 = ptr3;
                ptr3 = ptr3.next;
                ptr2.next = ptr1;
            }

            start = ptr2;
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
