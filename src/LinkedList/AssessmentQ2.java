//2)Write  a program to remove the given  Node (n) From End of List
//Example 1:
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
//Example 2:
//Input: head = [1], n = 1
//Output: []
//Example 3:
//Input: head = [1,2], n = 1
//Output: [1]

package LinkedList;

public class AssessmentQ2 {
    public static void main(String[] args){

        LinkedList linked1 = new LinkedList();

        linked1.append(1);
        linked1.append(2);
        linked1.append(3);
        linked1.append(4);
        linked1.append(5);


        linked1.deleteByIndex(linked1, 2);

        linked1.displayList();

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
            Node newNode = new Node(data);
            last.next = newNode;
            last = newNode;
        }

        public void reverse(){
            Node ptr1 = start;
            Node ptr2 = start.next;
            Node ptr3 = start.next.next;

            ptr1.next = null;
            ptr2.next = ptr1;

            while(ptr3 != null){
                ptr1 = ptr2;
                ptr2 = ptr3;
                ptr3 = ptr3.next;
                ptr2.next = ptr1;
            }
            start = ptr2;
        }

        public void displayList(){
            Node current = start;

            if(current.next == null){
                return;
            }

            while(current.next != null){
                System.out.print(current.data + " --> ");
                current = current.next;
            }
            System.out.print(current.data);
        }

        public void deleteByIndex(LinkedList linky, int index){
            if(index == 1 && start == last){
                System.out.println("[]");
                return;
            }
            linky.reverse();
            Node current = start;
            Node previous = null;
            int count = index;
            while(count > 1){
                previous = current;
                current = current.next;
                count--;
            }
            if(index == 1){
                start = start.next;
                linky.reverse();
                return;
            }
            previous.next = current.next;
            current.next = null;
            linky.reverse();
        }
    }
}
