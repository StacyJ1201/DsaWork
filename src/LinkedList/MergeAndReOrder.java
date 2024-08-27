//Given two sorted singly linked lists having n and m elements each,
//merge them using constant space. First n smallest elements in both the lists should become part of first list
// and rest elements should be part of second list. Sorted order should be maintained.
//  We are not allowed to change pointers of first linked list.
//
//For example,
//
//Input:
//First List: 2->4->7->8->10
//Second List: 1->3->12
//
//Output:
//First List: 1->2->3->4->7
//Second List: 8->10->12

package LinkedList;

import java.util.Scanner;

public class MergeAndReOrder {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        System.out.println("Build your first list: ");
        String input1 = scanner.nextLine();

        while(!input1.equals("end")){
            try{
                list1.insert(Integer.parseInt(input1));
            } catch ( NumberFormatException e) {
                System.out.println("Input a valid number or enter \"end\" to end the inputs.");
            }
            input1 = scanner.nextLine();
        }
        System.out.print("You entered: ");
        list1.display();
        System.out.println("Build your second list: ");
        String input2 = scanner.nextLine();

        while(!input2.equals("end")){
            try{
                list2.insert(Integer.parseInt(input2));
            }catch (NumberFormatException e){
                System.out.println("Input a valid number or enter \"end\" to end the inputs.");
            }
            input2 = scanner.nextLine();
        }
        list2.display();
    }

    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    static class LinkedList{
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

        public void insert(int data){
            Node newNode = new Node(data);

            if(start == null || data <= start.data){
                newNode.next = start;
                start = newNode;
                if(last == null)
                    last = start;
                return;
            }

            Node current = start;
            Node previous = null;
            while(current != null && data > current.data){
                previous = current;
                current = current.next;
            }
            previous.next = newNode;
            newNode.next = current;

            if(current == null){
                last = newNode;
            }
        }

        public void display(){
            Node current = start;
            System.out.print("[ ");

            while(current.next != null){
                System.out.print(current.data + ", ");
                current = current.next;
            }
            System.out.println(current.data + " ]");
        }

        public void deleteLast(){
            Node current = start;
            while(current.next != last){
                current = current.next;
            }
            current.next = null;
            last = current;
        }

        public void merge(LinkedList otherList){
            Node current1 = this.start;
            Node current2 = otherList.start;

            while (current2 != null) {
                while(current1.data < current2.data){
                    current1 = current1.next;
                }
                current2 = current2.next;
            }
        }


    }
}


