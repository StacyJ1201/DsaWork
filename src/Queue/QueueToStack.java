//Given a Queue consisting of first n natural numbers (in random order).
// The task is to check whether the given Queue elements can be arranged in increasing order in another Queue using a stack.
//  The operation allowed are:
//1. Push and pop elements from the stack
//2. Pop (Or enqueue) from the given Queue.
//3. Push (Or Dequeue) in the another Queue.
//
//Examples :
//
// Input : Queue[] = { 5, 1, 2, 3, 4 }
//Output : Yes
//Input : Queue[] = { 6,5, 1, 2, 3, 7,4 }
//Output : No
//
//Input : Queue[] = { 6,5, 1, 2, 3, 4 }
//Output : yes

// Input : Queue[] = { 5, 1, 2, 3, 4 }
//Output : Yes
//Pop the first element of the given Queue i.e 5.
//Push 5 into the stack.
//Now, pop all the elements of the given Queue and push them to
//second Queue.
//Now, pop element 5 in the stack and push it to the second Queue.
//
//Input : Queue[] = { 5, 1, 2, 6, 3, 4 }
//Output : No
//Push 5 to stack.
//Pop 1, 2 from given Queue and push it to another Queue.
//Pop 6 from given Queue and push to stack.
//Pop 3, 4 from given Queue and push to second Queue.
//Now, from using any of above operation, we cannot push 5
//into the second Queue because it is below the 6 in the stack.

package Queue;

public class QueueToStack {
    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.enqueue(5);
        q.enqueue(2);
        q.enqueue(10);
        q.enqueue(4);
        q.enqueue(9);

        q.dequeue();

        q.enqueue(3);
        q.enqueue(7);

        q.show();
    }

    static class Queue{
        int[] array;
        int front, rear;
        int size;

        public Queue(int initialSize){
            this.array = new int[initialSize];
            this.front = this.rear = -1;
            this.size = initialSize;
        }

        public boolean isFull(){
            return front == (rear + 1) % size;
        }

        public boolean isEmpty(){
            return front == -1;
        }

        public void enqueue(int data){
            if(isFull()){
                System.out.println("The array is full");
                return;
            } else if(isEmpty()){
                front = 0;
            }
            rear = (rear + 1) % size;
            array[rear] = data;
        }

        public int dequeue(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int data = array[front];
            if(front == rear){
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return data;
        }

        public void show() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
            } else {
                System.out.print("Elements: ");
                int i = front;
                while (true) {
                    System.out.print(array[i] + " ");
                    if (i == rear) {
                        break;
                    }
                    i = (i + 1) % size;
                }
                System.out.println();
            }
        }
    }

    static class Node{
        int data;
        Node top;

        public Node(int data){
            this.data = data;
        }
    }
    static class LinkedListStack{
        Node top;

        public void push(int data){

        }
    }
}
