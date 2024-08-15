//Delete the nodes from a linked list at a given distance from beginning.
//
//Example1:
//
//Input: {1,2,3,4,5,6,7,8,9,10}
//
//distance :2
//
//output:{1,4,7,10}
//
//Example 2:
//
//Input:{ 1,2,3,4,5,6,7,8,9,10}
//
//distance :1
//
//Output:{1,3,5,7,9}

package LinkedList;

public class DeleteDistance {
    public static void main(String[] args){
        LinkedList linky = new LinkedList();

        linky.append(1);
        linky.append(2);
        linky.append(3);
        linky.append(4);
        linky.append(5);
        linky.append(6);
        linky.append(7);
        linky.append(8);
        linky.append(9);
        linky.append(10);

        linky.traverse(2);

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

        public void delete(Node node){

            if(start == node){
                node = node.next;
            }
            else {
                Node current = start;

                while (current.next != node && current.next != null) {
                    current = current.next;
                }
                current.next = node.next;
            }
        }

        public void append(int data){
            if(start == null){
                start = new Node(data);
                last = start;
                return;
            }
            Node newLast = new Node(data);
            last.next = newLast;
            last = newLast;
        }

        public void traverse(int distance){
            Node current = start;
            int index = 0;

            while(current != null){
                if(index % (distance + 1) == 0){
                    System.out.print(current.data + " ");
                }
                Node toDelete = current;
                current = current.next;
                if(index % distance != 0){
                    delete(toDelete);
                }
                index++;
            }
            System.out.println();
        }
    }
}
