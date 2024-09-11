package Deque;

public class Deque {
    public static void main(String[] args) {
        DequeList list = new DequeList();
        DequeArray arr = new DequeArray(5);

        arr.addFirst(1);
        arr.addLast(2);
        arr.addLast(3);
        arr.addLast(4);
        arr.addLast(5);

        arr.removeFirst();
        arr.removeFirst();
        arr.removeFirst();

        arr.show();

        list.insertFirst(10);
        list.insertLast(11);
        list.insertLast(12);
        list.insertLast(13);
        list.insertLast(14);

        list.removeLast();

        list.show();


    }
    static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
        }
    }


    static class DequeList{
        Node front, rear;
        int size;

        public boolean isEmpty(){
            return size == 0;
        }

        public void insertFirst(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                front = rear = newNode;
            }
            front.prev = newNode;
            newNode.next = front;
            front = newNode;
            size++;
        }

        public void insertLast(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                front = rear = newNode;
            }
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
            size++;
        }

        public int removeFirst(){
            if(isEmpty()){
                throw new RuntimeException("Deque is empty");
            }
            int data = front.data;
            front = front.next;
            if(front == null){
                rear = null;
            } else {
                front.prev = null;
            }
            size--;
            return data;
        }

        public int removeLast(){
            if(isEmpty()){
                throw new RuntimeException("Deque is empty");
            }
            int data = rear.data;
            rear = rear.prev;
            //only one element was left
            if(rear == null){
                front = null;
            }
            else {
                rear.next = null;
            }
            size--;
            return data;
        }

        public int peekFirst(){
            if(isEmpty()){
                throw new RuntimeException("Deque is empty");
            }
            return front.data;
        }

        public int peekLast(){
            if(isEmpty()){
                throw new RuntimeException("Deque is empty");
            }
            return rear.data;
        }

        public void show(){
            Node current = front;
            while(current != null){
                System.out.print(current.data + ", ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static class DequeArray{
        int[] array;
        int front;
        int rear;
        int size;
        int capacity;

        public DequeArray(int capacity){
            this.capacity = capacity;
            this.array = new int[capacity];
            this.front = -1;
            this.rear = this.size = 0;
        }

        public boolean isFull(){
            return size == capacity;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public void addFirst(int data){
            if(isFull()){
                throw new RuntimeException("Deque is full");
            }
            if(isEmpty()){
                front = rear = 0;
            } else {
                front = (front - 1 + capacity) % capacity;
            }
            array[front] = data;
            size++;
        }

        public void addLast(int data){
            if(isFull()){
                throw new RuntimeException("Deque is full");
            }
            if(isEmpty()){
                front = rear = 0;
            } else{
                rear = (rear + 1) % capacity;
            }
            array[rear] = data;
            size++;
        }

        public int removeFirst(){
            if (isEmpty()){
                throw new RuntimeException("Deque is empty");
            }
            int data = array[front];
            if(front == rear){
                front = rear = -1;
            } else{
                front = (front + 1) % capacity;
            }
            size--;
            return data;
        }

        public int removeLast(){
            if (isEmpty()){
                throw new RuntimeException("Deque is empty");
            }
            int data = array[rear];
            if(front == rear){
                front = rear = -1;
            } else {
                rear = (rear - 1) % capacity;
            }
            size--;
            return data;
        }

        public int peekFirst(){
            if (isEmpty()){
                throw new RuntimeException("Deque is empty");
            }
            return array[front];
        }

        public int peekLast(){
            if (isEmpty()){
                throw new RuntimeException("Deque is empty");
            }
            return array[rear];
        }

        public void show(){
            int i = 0;
            for (i = front + i; i <= rear; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.println();
        }
    }
}
