//WAP to create a singly linked list from  unsorted array ,the resultant list is in sorted order and does not contain any  duplicate values .
//Example1:
//input:int[] arr= {1, 2, 2, 0,2,0, 3, 4, 4,3, 5};
//output:{0,1,2,3,4,5}
//Example 2:
//Input :int[] arr = {24,27,30,24,12,17,27,1,5,1,3};
//output:{1, 3, 5, 12, 17, 24, 27,30}

package LinkedList;

public class InOrder {
    public static void main(String[] args) {
        int[] arr= {1, 2, 2, 0,2,0, 3, 4, 4,3, 5};

        LinkedList linky = new LinkedList();

        linky.createList(arr);
        linky.displayList();

    }

    public static class Node{

        int data;
        Node next;

        public Node(int data){
           this.data = data;
           this.next = null;
        }
    }

    public static class LinkedList{

        Node start;

        private void createList(int[] array){
            for(int value : array){
               insert(value);
            }
        }

      private boolean noDupes(int data){
          Node current = start;
            while(current != null){
                if(current.data == data){
                    return true;
                }
                current = current.next;
            }
          return false;
      }

      private void insert(int data){

            if(noDupes(data)){
                return;
          }
            Node newNode = new Node(data);

            if(start == null || start.data > data){
              newNode.next = start;
              start = newNode;
              return;
          }
          Node current = start;
          while(current.next != null && current.next.data < data){
              current = current.next;
          }
          newNode.next = current.next;
          current.next = newNode;
      }

      private void displayList(){
          Node current = start;

          if (start != null){
              System.out.print("{ " + current.data + ", ");
              current = current.next;
          }

          while(current.next != null){
              System.out.print(current.data + ", ");
              current = current.next;
          }
          System.out.print(current.data + " }");
      }
    }
}
