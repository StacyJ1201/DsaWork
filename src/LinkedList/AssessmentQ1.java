//1)You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
// and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//
//Example 1:
//
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//Example 2:
//Input: l1 = [0], l2 = [0]
//Output: [0]
//Example 3:
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]

package LinkedList;

public class AssessmentQ1 {
    public static void main(String[] args){

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

        public void add(LinkedList otherList){
            int result = 0;
             if(start.next == null){
                 System.out.println(this.start.data + otherList.start.data);
                 return;
             }

            this.reverse();
            otherList.reverse();

            Node current = start;
            while(current.next != null){

            }
        }

        public void reverse(){
            Node ptr1 = start;
            Node ptr2 = start.next;
            Node ptr3 = start.next.next;

            ptr1.next = null;
            ptr2.next = ptr1;

            while(ptr3.next != null){
                ptr1 = ptr2;
                ptr2 = ptr3;
                ptr3 = ptr3.next;
                ptr2.next = ptr1;
            }
            ptr2 = start;
        }
    }
}
