//Grace has a string S and a stack A.
//She pushes each character of string S whose ASCII value is divisible by 3 on the stack.
//Given a string S as input print the contents of the stack by popping each character from the stack.
//Input Format
//
//The first line of input contains the string S.
//
//Sample Input
//
//abcfgh	- - denotes the string S
//
//Output Format
//
//Print the contents of the stack by popping each character from the stack as per the conditions.
//
//Sample Output
//
//Fc

package Stacks;

public class AssessmentQ2 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        String word = "abcfgh";

        for(char c : word.toCharArray()){
            linkedList.push(c);
        }

        linkedList.show();
    }

    static class Node{
        char data;
        Node next;

        public Node(char data){
            this.data = data;
        }
    }

    static class LinkedList{
        Node top;

        public void push(char data){
            int newData = (int) data;
            if(newData % 3 == 0) {
                if (top == null) {
                    top = new Node(data);
                    return;
                }
                Node newTop = new Node(data);
                newTop.next = top;
                top = newTop;
            }
        }

        public char pop(){
            if(top == null){
                throw new RuntimeException("Nothing to pop");
            }
            char popped = top.data;
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
