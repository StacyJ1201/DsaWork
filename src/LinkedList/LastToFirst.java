//Modify linked list in such a way that last node become the first node of the list.
//        eg:
//list:{1,2,3,4}
//output:{4,1,2,3}

package LinkedList;

public class LastToFirst {
    public static void main(String[] args) {

        LinkedList.append(1);
        LinkedList.append(2);
        LinkedList.append(3);
        LinkedList.append(4);
        LinkedList.append(5);

        LinkedList.display();


//        LinkedList.toTheFront();
//        LinkedList.display();
//
//        LinkedList.toTheFront();
//        LinkedList.display();

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
            if (start == null){
                start = new Node(data);
                last = start;
                return;
            }
            Node newLast = new Node(data);
            last.next = newLast;
            last = newLast;
        }

        public static void display(){
            Node current = start;
            while (current.next != null){
                System.out.print(current.data + " --> ");
                current = current.next;
            }
            System.out.println(current.data);
        }

        public static void toTheFront(){

            if (start == null || start.next == null){
                return;
            }
            Node current = start;
            while(current.next != last){
                current = current.next;
            }
            Node newStart = last;
            current.next = null;
            newStart.next = start;
            start = newStart;
            last = current;
        }
    }
}
