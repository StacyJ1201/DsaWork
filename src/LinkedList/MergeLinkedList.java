//Create a single linked list by merging the nodes of the two given linked lists from the end positions
//
//eg:
//
//list1={1,2,3,5,7}
//
//list2={4,6,9,11}
//
//output:{11,9,7,6,5,4,3,2,1}

package LinkedList;

public class MergeLinkedList {
    public static void main(String[] args){
        LinkedList linky = new LinkedList();

        linky.append(1);
        linky.append(2);
        linky.append(3);
        linky.append(4);

        linky.displayList();


    }

    static class Node{
        int data;
        Node previous;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    static class LinkedList{
        Node start;
        Node last;

        public void append(int data){
          if(start == null){
              start = new Node(data);
              last = start;
              return;
          }
          Node newLast = new Node(data);
          newLast.previous = last;
          last = newLast;
        }

        public void displayList(){
            Node current = last;
            System.out.print("{ ");
            while(current.previous != null){
                System.out.print(current.data + ", ");
                current = current.previous;
            }
            System.out.println(current.data + " }");
        }

        public void merge(Node start1, Node start2){

        }
    }

}
