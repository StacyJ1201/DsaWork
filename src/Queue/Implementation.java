package Queue;

import java.util.Arrays;

public class Implementation {
    public static void main(String[] args){
        LinkedList linky = new LinkedList();
        QueueUsingArray arr1 = new QueueUsingArray(5);

        arr1.append(1);
        arr1.append(2);
        arr1.append(3);
        arr1.append(4);
        arr1.append(5);


        arr1.display();

        linky.append(1);
        linky.append(2);
        linky.append(3);


        linky.display();


    }
    static class QueueUsingArray {
        int front, rear;
        int[] array;

        public QueueUsingArray(int initialSize){
            this.front = this.rear = -1;
            this.array = new int[initialSize];
        }

        public void append(int data){
            if(isFull()){
                System.out.println("You cannot add anymore");
                return;
            }
            if(isEmpty()){
                front = 0;
            }
            rear = (rear + 1) % array.length;
            array[rear] = data;
        }

        public void delete(){
            if(isEmpty()){
                System.out.print("Queue is empty");
                return;
            }
            if(front == rear){
                front = rear = -1;
            }
            front = (front + 1) % array.length;
        }

        public void display(){
            if(isEmpty()){
                System.out.println("queue is empty");
            }
            System.out.print("[ ");
            for(int i = front; i < rear;i++){
                System.out.print(array[i] + ", ");
            }
            System.out.println(array[rear] + " ]");
        }

        public boolean isEmpty(){
            return front == -1;
        }

        public boolean isFull(){
           return (rear + 1) % array.length == front;
        }
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
            Node newLast = new Node(data);
            last.next = newLast;
            last = newLast;
        }

        public void delete(){
            if(start == null){
                System.out.println("There is nothing to delete");
                return;
            }
            if(start.next == null){
                start = last = null;
                return;
            }
            Node current = start;
            start = current.next;
            current.next = null;
        }

        public void display(){
            if(start == null){
                System.out.println("The list is empty");
                return;
            }
            Node current = start;
            while(current.next != null){
                System.out.print(current.data + ", ");
                current = current.next;
            }
            System.out.println(current.data);
        }

    }
}
