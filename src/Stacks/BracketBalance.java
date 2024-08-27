//Given an expression string exp,
// write a program to examine whether the pairs and the
// orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in the given expression.

package Stacks;
import java.util.Scanner;

public class BracketBalance {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        LinkedList link1 = new LinkedList();

        while(true) {
            System.out.print("Enter an input: ");
            String input = scanner.nextLine();

            if(input.equals("end"))
                break;
            if (link1.checkForBrackets(input)) {
                System.out.println("Balanced");
            } else {
                System.out.println("Not Balanced");
            }
        }
        scanner.close();
    }

    public static class Node{
        char data;
        Node next;

        public Node(char data){
            this.data = data;
        }
    }

    public static class LinkedList{
        private Node top;

        public void push(char data){
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
        }

        public char pop(){
            if(top == null){
                System.out.print("The stack is empty");
                return '\0';
            }
            char popped = top.data;
            top = top.next;
            return popped;
        }

        public boolean isEmpty(){
            return top == null;
        }

        public char peek(){
            return top != null ? top.data : '\0';
        }

        public boolean checkForBrackets(String input) {
            for (char bracket : input.toCharArray()) {
                if (bracket == '{' || bracket == '[' || bracket == '(') {
                    this.push(bracket);
                } else if (bracket == '}' || bracket == ')' || bracket == ']') {
                    if (isEmpty()) {
                        return false;
                    }
                    char topBracket = this.pop();
                    if(!isMatching(topBracket, bracket)){
                        return false;
                    }
                }
            }
            return isEmpty();
        }

        public boolean isMatching(char topBracket, char bracket){
            return  (topBracket == '(' && bracket == ')') ||
                    (topBracket == '[' && bracket == ']') ||
                    (topBracket == '{' && bracket == '}');
        }
    }
}
