package SortingAlgos;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {

        Random random = new Random();
        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("Before it was sorted: " + Arrays.toString(array));

        mergeSort(array);

        System.out.println("After it was sorted: " + Arrays.toString(array));
    }

    private static void mergeSort(int[] array){
        int n = array.length;
        if (n <= 1){
            return;
        }
        int middle = n / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[n - leftArray.length];
        


        for (int i = 0; i < middle; i++){
            leftArray[i] = array[i];
        }
        for (int j = middle; j < n;j++){
            rightArray[j - middle] = array[j];
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array){

        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0;

        while (l < leftSize && r < rightSize){
            if (leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                l++;
            } else {
                array[i] = rightArray[r];
                r++;
            }
            i++;
        }
        while (l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}
