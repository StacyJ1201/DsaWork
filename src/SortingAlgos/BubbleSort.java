package SortingAlgos;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{22, 43, 14, 53, 36, 7, 99, 49};

        System.out.println(Arrays.toString(bubbleSort(array)));
    }
    public static int[] bubbleSort(int[] array) {
        int pass = 0;

        while (pass <= array.length - 1){
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
            pass++;
        }
        return array;
    }
}
