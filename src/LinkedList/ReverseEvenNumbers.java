//write a program to reverse the consecutive  even nodes of the SINGLY linked list
//input:{ 1, 2, 3, 3, 4, 6, 8, 5 }
//output:{1, 2, 3, 3, 8, 6, 4, 5 }

package LinkedList;

public class ReverseEvenNumbers {
    public static void main(String[] args){
        LinkedList linky = new LinkedList();

        linky.append(2);
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

        }


    }
}
