package BinaryTree;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {

        Heap heap = new Heap();

        int[] arr = new int[]{13, 7, 4, 9, 29, 83, 26, 40, 19, 64};

        for(int num : arr){
            heap.add(num);
        }

        System.out.println(Arrays.toString(arr));
        heap.minHeap();
        heap.displayHeap();
        heap.maxHeap();
        heap.displayHeap();



    }
    static class Heap {
        int capacity = 10;
        int size = 0;
        int[] array = new int[capacity];

        private int getLeftChildIndex(int parentIndex){
            return parentIndex * 2 + 1;
        }
        private int getRightChildIndex(int parentIndex){
            return parentIndex * 2 + 2;
        }
        private int getParentIndex(int childIndex){
            return childIndex / 2 - 1;
        }

        public boolean hasLeftChild(int index){
            return getLeftChildIndex(index) < size;
        }
        public boolean hasRightChild(int index){
            return getRightChildIndex(index) < size;
        }
        public boolean hasParent(int index){
            return getParentIndex(index) < size;
        }

        public int leftChildValue(int index){
            return array[getLeftChildIndex(index)];
        }
        public int rightChildValue(int index){
            return array[getRightChildIndex(index)];
        }
        public int parentValue(int index){
            return array[getParentIndex(index)];
        }

        public void swap(int indexOne, int indexTwo){
            int temp = array[indexOne];
            array[indexOne] = array[indexTwo];
            array[indexTwo] = temp;
        }

        public void ensureExtraCapacity(){
            if(size == capacity){
                array = Arrays.copyOf(array, capacity * 2);
                capacity *=2;
            }
        }

        public int peek(){
            assertCurrentSizeIsValid();
            return array[0];
        }

        public int poll(){
            assertCurrentSizeIsValid();
            int item = array[0];
            array[0] = array[size - 1];
            size--;
            minHeap();
            return item;
        }

        public void  assertCurrentSizeIsValid(){
            if(size == 0)
                throw new IllegalStateException("Nothing in the array");
        }

        public void add(int item){
            ensureExtraCapacity();
            array[size] = item;
            size++;
        }

        public void maxHeap(){
            int index = size - 1;
            while(hasParent(index) && parentValue(index) > array[index]){
                swap(getParentIndex(index), array[index]);
                index = getParentIndex(index);
            }
        }

        public void minHeap() {
            int index = 0;
            int smallerChildIndex;
            while (hasLeftChild(index)) {
                smallerChildIndex = getLeftChildIndex(index);
                if (hasRightChild(index) && leftChildValue(index) > rightChildValue(index)) {
                    smallerChildIndex = getRightChildIndex(index);
                }
                if (array[index] < array[smallerChildIndex]) {
                    break;
                } else {
                    swap(index, smallerChildIndex);
                }
                index = smallerChildIndex;
            }
        }

        public void displayHeap(){
            System.out.print("[");
            for (int i = 0; i < size; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.println("]");
        }
    }
}
