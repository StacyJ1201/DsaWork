//3)What will be the final contents of the stack if you are given the sequence of commands?
//
//Given:
//
//-	A pooling system uses a stack. There are commands to track what operations are performed.
//-	The commands are in below format <Type> <Value>
//-	If type = 0, Value is pushed into the stack.
//-	If type = 1, Value is popped from the stack. (If there are no values to pop, the command is ignored). The value parameter is -1.
//-	If type = 2, the entire stack is reversed, the value parameter is -1.
//
//Input Format
//
//The first line contains an integer N, denoting the number of commands
//
//The next N lines each contain the command that is sent.
//
//Sample Input
//
//8
//0 1
//0 5
//1 -1
//1 -1
//1 -1
//0 1
//0 5
//2 -1
//
//Output Format
//
//Contents of stack (Top to Bottom)
//
//Sample Output
//
//1
//5

package Stacks;

public class AssessmentQ3 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.push(0, 4);
        linkedList.show();
    }
    static class Node{
        int type;
        int data;
        Node next;

        public Node(int type, int data){
            this.type = type;
            this.data = data;
        }

        public Node(int data){
            this.data = data;
        }
    }

    static class LinkedList{
        Node top;

        public void push(int type, int data){
            if (top == null && type == 0) {
                top = new Node(data);
                return;
            }
            if(type == 0) {
                Node newTop = new Node(data);
                newTop.next = top;
                top = newTop;
            }
        }

        public void reverse(){
            if (top == null) {
                throw new RuntimeException("Nothing to reverse");
            }
            if (top.next == null) {
                top.next.next = top;
                top = top.next;
                show();
            }
            Node prev = null;
            Node current = top;
            Node next;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            top = prev;
        }

        public int pop(int type, int data){
            if(top == null){
                throw new RuntimeException("Nothing to pop");
            }
            int popped = top.data;
            top = top.next;
            return popped;
        }

        public void show(){
            while(top != null){
                System.out.print(top.data);
                top = top.next;
            }
            System.out.println();
        }
    }

}
