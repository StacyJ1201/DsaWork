package SortingAlgos;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{52, 34, 54, 35, 65, 87, 56};

        System.out.println(Arrays.toString(insertionSort(array)));
    }

    public static int[] insertionSort(int[] array){
        for (int i = 1; i < array.length - 1; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] >= temp){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
        return array;
    }
}
