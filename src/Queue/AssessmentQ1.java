//)Given a queue with random elements, we need to sort it.
//We are not allowed to use extra space. The operations allowed on queue are :
//enqueue() : Adds an item to rear of queue.
//dequeue() : Removes an item from front of queue.
//isEmpty() : Checks if a queue is empty.
//Examples :
//Input : A queue with elements
//        11  5  4  21
//Output : Modified queue with
//         following elements
//        4 5 11 21
//Input : A queue with elements
//        3  2  1  2
//Output : Modified queue with
//         following elements
//        1 2 2 3

package Queue;

public class AssessmentQ1 {
    public static void main(String[] args) {

        QueueArray queueArray = new QueueArray(4);
        queueArray.enqueue(11);
        queueArray.enqueue(5);
        queueArray.enqueue(4);
        queueArray.enqueue(21);

        queueArray.dequeue();

        queueArray.enqueue(14);
        queueArray.sort();
        queueArray.show();

    }
    //Enqueue each element position to get it in the right order

    static class QueueArray{
        int front, rear, size, capacity;
        int[] array;

        public QueueArray(int capacity){
            this.front = -1;
            this.rear = 0;
            this.size = 0;
            this.array = new int[capacity];
            this.capacity = capacity;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public void enqueue(int data){
            if(isEmpty()){
                front = 0;
                array[rear] = data;
                size++;
            } else if(rear < 3) {
                rear = (rear + 1);
                array[rear] = data;
                return;
            } else{
                for (int i = 0; i < array.length - 1; i++) {
                    int temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
                array[rear] = data;
                return;
            }

            array[rear] = data;
        }

        public void dequeue(){
            if(isEmpty()){
                throw new RuntimeException("Queue is empty");
            }
            if(front == rear){
                front = rear = -1;
                return;
            }
            array[front] = 0;
        }

        public void show(){
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + ", ");
            }
        }

        public void sort(){
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - 1; j++) {
                    if(array[j] > array[j + 1]){
                        int temp = array[j];
                        dequeue();
                        enqueue(temp);
                    }
                }
            }
        }
    }
}
