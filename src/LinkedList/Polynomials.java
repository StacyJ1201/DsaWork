//        //4x5 + 5x4 + 2x3 + 3x2 + 7x
//        //9x6 + 6x4 + 3x2
//        Polynomial list1=new Polynomial();
//        list1.insertatend(4, 5);
//        list1.insertbetween(5, 4);
//        list1.insertbetween(2, 3);
//        list1.insertbetween(3, 2);
//        list1.insertbetween(7, 1);

package LinkedList;

public class Polynomials {
    public static void main(String[] args){
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.insertAtEnd(4, 5);
        list1.insertBetween(5, 4);
        list1.insertBetween(2, 3);
        list1.insertBetween(3, 2);
        list1.insertBetween(7, 1);

        list2.insertAtEnd(9, 6);
        list2.insertBetween(6,4);
        list2.insertBetween(3,2);

        list1.displayList();
        list2.displayList();

        LinkedList list3 = list1.add(list2);
        System.out.print("Result: ");
        list3.displayList();
    }

    public static class Node{
        int coefficient;
        int exponent;
        Node next;

        public Node(int coefficient, int exponent){
            this.coefficient = coefficient;
            this.exponent = exponent;
        }
    }

    public static class LinkedList{
        Node start, last;

        public LinkedList add(LinkedList otherLinkedList){
            LinkedList result = new LinkedList();
            Node node1 = this.start;
            Node node2 = otherLinkedList.start;

            while(node1 != null && node2 != null) {
                if (node1.exponent > node2.exponent) {
                    result.insertAtEnd(node1.coefficient, node1.exponent);
                    node1 = node1.next;
                } else if (node2.exponent > node1.exponent) {
                    result.insertAtEnd(node2.coefficient, node2.exponent);
                    node2 = node2.next;
                } else {
                    result.insertAtEnd(node1.coefficient +  node2.coefficient, node1. exponent);
                    node1 = node1.next;
                    node2 = node2.next;
                }
            }
            while(node1 != null){
                result.insertAtEnd(node1.coefficient, node1.exponent);
                node1 = node1.next;
            }
            while(node2 != null){
                result.insertAtEnd(node2.coefficient, node2.exponent);
                node2 = node2.next;
            }
            return result;
        }

        public void insertAtEnd(int coefficient, int exponent){
            if(start == null){
                start = new Node(coefficient, exponent);
                last = start;
                return;
            }
            Node newLast = new Node(coefficient, exponent);
            last.next = newLast;
            last = newLast;
        }

        public void insertBetween(int coefficient, int exponent){
            if(start == null){
                start = new Node(coefficient, exponent);
                last = start;
                return;
            }
            if(last.exponent > exponent){
                insertAtEnd(coefficient, exponent);
                return;
            }

            if(start.exponent > exponent){
                insertAtStart(coefficient, exponent);
                return;
            }
            Node current = start;
            while(current.exponent >= exponent){
                current = current.next;
            }
            Node newNode = new Node(coefficient, exponent);
            newNode.next = current.next;
            current.next = newNode;
        }

        public void insertAtStart(int coefficient, int exponent){
            if(start == null){
                start = new Node(coefficient, exponent);
                last = start;
                return;
            }
            Node newStart = new Node(coefficient, exponent);
            newStart.next = start;
            start = newStart;
        }

        public void displayList(){
            Node current = start;
            while(current.next != null){
                System.out.print(current.coefficient + "x" + current.exponent + " + ");
                current = current.next;
            }
            System.out.println(current.coefficient + "x" + current.exponent);
        }
    }
}
