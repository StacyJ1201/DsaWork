//Given a linked list, swap every two adjacent nodes and return its head.You may not modify the values in the list's nodes. Only nodes itself may be changed.
//
// Example 1:
//
//
//
//Input: head = [1,2,3,4]
//
//Output: [2,1,4,3]
//
//Example 2:
//
//Input: head = []
//
//Output: []
//
//Example 3:
//
//Input: head = [1]
//
//Output: [1]

package LinkedList;

public class SwapNeighbors {
    public static void main(String[] args){
        LinkedList linky = new LinkedList();

        linky.append(1);
        linky.append(2);
        linky.append(3);
        linky.append(4);
        linky.append(5);
        linky.display();

        linky.swapNeighbors();
        linky.display();
    }
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    public static class LinkedList{
        Node start, last;

        public void append(int data){
            if(start == null){
                start = new Node(data);
                last = start;
                return;
            }
            Node newLast = new Node(data);
            last.next = newLast;
            last = newLast;
        }

        public void swapNeighbors(){
            if (start == null || start.next == null){
                display();
            }
            Node dummy = new Node(0);
            dummy.next = start;
            Node prev = dummy;
            Node current = start;

            while(current != null && current.next != null){
                Node first = current;
                Node second = current.next;

                first.next = second.next;
                second.next = first;
                prev.next = second;

                prev = first;
                current = first.next;
            }
            start = dummy.next;
        }

        public void display(){
            if(start == null){
                System.out.print("[]");
            }
            else if (start.next == null){
                System.out.print("[" + start.data + "]");
            }
            else{
                Node current = start;
                System.out.print("[ ");
                while (current.next != null){
                   System.out.print(current.data + ", ") ;
                   current = current.next;
                }
                System.out.println(current.data + " ]");
            }
        }

    }
}
