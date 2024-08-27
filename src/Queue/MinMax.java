//Design a stack that supports push, pop, top(peek), and retrieving the minimum and maximum element in constant time.
//push(x) -- Push element x onto stack.
//pop() -- Removes the element on top of the stack.
//peek() -- Get the top element.
//getMin() -- Retrieve the minimum element in the stack.
//getMax()--Retrieve the maximum element in the stack.
//Input: [1, 2, 5,0, 4, 3, 6,-2,4, 8]
//pop()
//Output:[ min:-2,max:6]
//
//Input: [1, 2, 5,0, 4, 3, 6,-2,4, 8]
//pop(),pop(),pop(),pop()
//Output:[ min:0,max:5]

package Queue;

public class MinMax {
    public static void main(String[] args){
        StackArray stack = new StackArray(10);

        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(0);
        stack.push(4);
        stack.push(3);
        stack.push(6);
        stack.push(-2);
        stack.push(4);
        stack.push(8);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();


        stack.display();

        stack.displayMinAndMax();

    }
    static class StackArray{
        int front, rear, top;
        int[] array;

        public StackArray(int size){
            this.front = this.rear = -1;
            this.array = new int[size];
        }

        public void push(int data){
            if(isFull()) {
                System.out.println("This array is full");
                return;
            }
            if(isEmpty()){
                front = 0;
                array[top] = data;
                return;
            }
            top = (top + 1) % array.length;
            rear = top;
            array[top] = data;
        }

        public int pop(){
            if(isEmpty()){
                System.out.println("This array is empty");
                return -1;
            }
            if(front == rear){
               front = rear = -1;
               return -1;
            }
            int numPopped = array[top];
            top = (top - 1) % array.length;
            rear = top;
            return numPopped;
        }

        public int peek(){
            if(isEmpty()){
                System.out.println("This array is empty");
                return -1;
            }
            return array[top];
        }

        public void display(){
            for(int i = 0; i < top; i++){
                System.out.print(array[i] + ", ");
            }
            System.out.println(array[top]);
        }

        public int getMin(){
            int min = array[0];
            for(int i = 1; i < top; i++){
                if(array[i] < min){
                    min = array[i];
                }
            }
            return min;
        }

        public int getMax(){
            int max = array[0];
            for(int i = 1; i <= top; i++){
                if(array[i] > max){
                    max = array[i];
                }
            }
            return max;
        }

        public void displayMinAndMax(){
            System.out.println("Minimum: " + getMin());
            System.out.println("Maximum: " + getMax());
        }


        public boolean isEmpty(){
            return front == -1;
        }

        public boolean isFull(){
            return top == array.length - 1;
        }
    }
}
