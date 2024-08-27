//A set of parenthesis are duplicate if the same subexpression is surrounded by multiple parenthesis.
//
//Examples:
//
//Below expressions have duplicate parenthesis -
//((a+b)+((c+d)))
//The subexpression "c+d" is surrounded by two
//pairs of brackets.
//
//(((a+(b)))+(c+d))
//The subexpression "a+(b)" is surrounded by two
//pairs of brackets.
//
//(((a+(b))+c+d))
//The whole expression is surrounded by two
//pairs of brackets.
//
//Below expressions don't have any duplicate parenthesis -
//((a+b)+(c+d))
//No subsexpression is surrounded by duplicate
//brackets.
//
//((a+(b))+(c+d))
//No subsexpression is surrounded by duplicate

package LinkedList;

import java.util.Scanner;

public class DuplicateParenthesis {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedList linky = new LinkedList();

        for(char c : input.toCharArray()){
            linky.push(c);
        }
        linky.display();
        scanner.close();
    }

    public static class Node{
        char info;
        Node next;

        public Node(char info){
            this.info = info;
        }
    }

    public static class LinkedList{
        Node start, last;

        public void push(char info){
            if(start == null){
                start = new Node(info);
                last = start;
                return;
            }

            Node newNode = new Node(info);
            last.next = newNode;
            last = newNode;
        }

        public char pop(){
            if(last == null){
                System.out.println("The list is empty");
                return '\0';
            }
            char popped = last.info;
            last = last.next;
            return popped;
        }

        public void display(){
            Node current = start;
            while(current != null){
                System.out.print(current.info);
                current = current.next;
                if(current != null){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        public void whereTheDuplicates(){

        }
    }
}
