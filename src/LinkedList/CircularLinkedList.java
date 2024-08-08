package LinkedList;

public class CircularLinkedList {
    public static void main(String[] args){
        LinkedList linky = new LinkedList();

        linky.append(1);
        linky.append(2);
        linky.append(3);
        linky.append(5);
        linky.prepend(0);
        linky.insert(4);
        linky.displayList();

        linky.delete(0);
        linky.displayList();

    }

    static class Node{
        int data;
        Node previous;
        Node next;

        public Node(int data){
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }

    static class LinkedList{
        Node start;
        Node last;

        public void append(int data){
            if(start == null){
                start = new Node(data);
                last = start;
                return;
            }
            Node newLast = new Node(data);
            newLast.next = start;
            newLast.previous = last;
            last.next = newLast;
            last = newLast;
        }

        public void prepend(int data){
            if(start == null){
                start = new Node(data);
                last = start;
                return;
            }
            Node newStart = new Node(data);
            newStart.next = start;
            newStart.previous = last;
            start.previous = newStart;
            start = newStart;
        }

        public void insert(int data){
            if(start == null){
                start = new Node(data);
                last = start;
                return;
            }
            Node current = start;
            while(current.next.data <= data){
                current = current.next;
            }
            Node newNode = new Node(data);
            newNode.next = current.next;
            newNode.previous = current;
            current.next.previous = newNode;
            current.next = newNode;
        }

        public void delete(int data){
            if(start.data == data){
                start.next.previous = last;
                last.next = start.next;
                start = start.next;
                return;
            } else if(last.data == data){
                last.previous.next = start;
                start.previous = last.previous;
                last = last.previous;
                return;
            } else{
                Node current = start;
                while(current.data != data){
                    current = current.next;
                }
                if(current.data == data){
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    current.next = null;
                    current.previous = null;
                    return;
                }
            }
            System.out.println("No matching data");
        }

        public void displayList(){
            Node current = start;

            while(current != last){
                System.out.print(current.data + " --> ");
                current = current.next;
            }
            System.out.println(current.data);
        }
    }


}
