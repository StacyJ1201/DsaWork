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
        LinkedList l1 = new LinkedList();
        l1.append(9);
        l1.append(9);
        l1.append(9);
        l1.append(9);
        l1.append(9);
        l1.append(9);
        l1.append(9);

        LinkedList l2 = new LinkedList();
        l2.append(9);
        l2.append(9);
        l2.append(9);
        l2.append(9);

        LinkedList result = l1.addList(l2);
        result.displayList();

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

        public LinkedList addList(LinkedList otherList){
            LinkedList result = new LinkedList();
            Node current1 = this.start;
            Node current2 = otherList.start;
            int carry = 0;

            while(current1 != null || current2 != null){
                int x = (current1 != null) ? current1.data : 0;
                int y = (current2 != null) ? current2.data : 0;
                int sum = x + y + carry;
                carry = sum / 10;
                result.append(sum % 10);
                if(current1 != null)current1 = current1.next;
                if(current2 != null)current2 = current2.next;
            }
            if(carry > 0) result.append(carry);

            return result;
        }

        public void reverse() {
            Node prev = null;
            Node current = start;
            Node next;

            while(current != null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            start = prev;
        }
        public void displayList(){
            Node current = start;

            System.out.print("[ ");
            while(current.next != null) {
                System.out.print(current.data + ", ");
                current = current.next;
            }
            System.out.println(current.data + " ]");
        }
    }
}
