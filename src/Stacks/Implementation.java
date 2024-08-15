package Stacks;

import java.util.Arrays;

public class Implementation {
    public static void main(String[] args){
       Array array1 = new Array(5);
       LinkedListStack linky = new LinkedListStack();

        linky.push(6);
        linky.push(7);
        linky.push(8);
        linky.push(9);
        linky.push(10);

        array1.push(1);
        array1.push(2);
        array1.push(3);
        array1.push(4);
        array1.push(5);

        linky.pop();

        System.out.println(Arrays.toString(array1.displayArray()));
        linky.displayLinkedList();

    }

    public static class Array {
        private int maxSize;
        private int[] stackArray;
        private int top;

        public Array(int size){
            maxSize = size;
            stackArray = new int[maxSize];
            top = -1;
        }
        public void push(int data) {
            if(top == maxSize - 1){
                System.out.println("The stack is full");
                return;
            }
            stackArray[++top] = data;
        }

        public int pop() {
            if(top == -1){
                System.out.println("Stack is empty");
                return -1;
            }
            return stackArray[top--];
        }

        public int[] displayArray(){
            return Arrays.copyOf(stackArray, top + 1);
        }
    }

    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    public static class LinkedListStack{
        private Node top;

        public void push(int data){
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
        }

        public int pop(){
            if(top == null){
                System.out.println("the stack is empty");
                return -1;
            }
            top = top.next;
            return top.data;
        }

        public void displayLinkedList(){
            while(top.next != null){
                System.out.print(top.data + " --> ");
                top = top.next;
            }
            System.out.println(top.data);
        }

    }
}
