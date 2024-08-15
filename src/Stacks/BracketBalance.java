//Given an expression string exp,
// write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in the given expression.

package Stacks;

public class BracketBalance {
    public static void main(String[] args){

    }

    public static class Node{
        String data;
        Node next;

        public Node(String data){
            this.data = data;
        }
    }

    public static class LinkedList{
        private Node top;

        public void push(String data){
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
        }

        public String pop(){
            if(top == null){
                return "The stack is empty";
            }
            top = top.next;
            return top.data;
        }

        public void checkForBrackets(String input){
            for(char bracket : input.toCharArray()){
                if(bracket == '{' || bracket == '[' || bracket == '('){

                }
            }
        }
    }
}
