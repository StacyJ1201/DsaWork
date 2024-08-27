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

package Stacks;

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
        int top;
        int[] array;
        int[] minStack;
        int[] maxStack;

        public StackArray(int size){
            this.top = -1;
            this.array = new int[size];
            this.minStack = new int[size];
            this.maxStack = new int[size];
        }

        public void push(int data){
            if(isFull()) {
                System.out.println("This array is full");
                return;
            }
            array[++top] = data;

            if(top == 0){
                minStack[top] = data;
                maxStack[top] = data;
            } else{
                minStack[top] = Math.min(data, minStack[top - 1]);
                maxStack[top] = Math.max(data, maxStack[top - 1]);
            }
        }

        public int pop(){
            if(isEmpty()){
                System.out.println("This array is empty");
                return -1;
            }
            return array[top--];
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

        public void displayMinAndMax(){
            System.out.println("Minimum: " + minStack[top]);
            System.out.println("Maximum: " + maxStack[top]);
        }


        public boolean isEmpty(){
            return top == -1;
        }

        public boolean isFull(){
            return top == array.length  - 1;
        }
    }
}
