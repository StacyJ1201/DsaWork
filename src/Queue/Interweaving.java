//Given a queue of integers of even length, rearrange the elements by interleaving the first
// half of the queue with the second half of the queue.
//Only a stack can be used as an auxiliary space.
//Examples:
//Input :  1 2 3 4
//Output : 1 3 2 4
//Input : 11 12 13 14 15 16 17 18 19 20
//Output : 11 16 12 17 13 18 14 19 15 20
//Time complexity: O(n).
//Auxiliary Space: O(n).

package Queue;

public class Interweaving {
    public static void main(String[] args) {
        QueueLinkedList linky = new QueueLinkedList();

        linky.enqueue(1);
        linky.enqueue(2);
        linky.enqueue(3);
        linky.enqueue(4);


        linky.interweave();


    }

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    static class QueueLinkedList{
        Node start, last;

        public void enqueue(int data){
            if(start == null){
                start = new Node(data);
                last = start;
                return;
            }
            Node newNode = new Node(data);
            last.next = newNode;
            last = newNode;
        }

        public void dequeue(){
            if(start == null){
                System.out.println("List is empty");
            }
            Node previous = start;
            start = start.next;
            previous.next = null;
        }

        public void show(){
            Node current = start;
            while(current != null){
                if(current.next == null){
                    System.out.println(current.data);
                    return;
                }
                System.out.print(current.data + " ---> ");
                current = current.next;
            }
            System.out.println();
        }

        public void interweave(){
            StackLinkedList linkedStack = new StackLinkedList();
            Node fastPointer = start;
            Node slowPointer = start;

            while(fastPointer.next.next != null){
                fastPointer = fastPointer.next.next;
                slowPointer = slowPointer.next;
            }
            Node current1 = start;
            Node current2 = fastPointer;

            while(current2 != null) {
                linkedStack.push(current1.data);
                current1 = current1.next;
                linkedStack.push(current2.data);
                current2 = current2.next;
            }

            while(!linkedStack.isEmpty()) {
                System.out.print(linkedStack.pop() + ", ");
            }
        }
    }

    static class StackLinkedList{
        Node top;

        public void push(int data){
            if(top == null){
                top = new Node(data);
                return;
            }
            Node newTop = new Node(data);
            newTop.next = top;
            top = newTop;
        }

        public int pop(){
            if(top == null){
                System.out.println("Nothing to pop");
                return -1;
            }
            int popped = top.data;
            top = top.next;
            return popped;
        }

        public boolean isEmpty(){
            return top == null;
        }
    }
}
