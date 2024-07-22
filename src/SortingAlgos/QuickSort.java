package SortingAlgos;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        Random random = new Random();
        int[] randomArray = new int[10];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(100);
        }

        System.out.println("Unsorted: " + Arrays.toString(randomArray));

        quickSort(randomArray, 0, randomArray.length  -1);

        System.out.println("Sorted: " + Arrays.toString(randomArray));

    }

    public static void quickSort(int[] array, int lowIndex, int highIndex){
        if (lowIndex >= highIndex){
            return;
        }

        int pivot = array[lowIndex + (highIndex - lowIndex) / 2];
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while (leftPointer <= rightPointer){

            while (array[leftPointer] < pivot){
                leftPointer++;
            }

            while (array[rightPointer] > pivot){
                rightPointer--;
            }
            if (leftPointer <= rightPointer){
                swap(array, leftPointer, rightPointer );
                leftPointer++;
                rightPointer--;
            }
        }
        if (lowIndex < rightPointer){
            quickSort(array, lowIndex, rightPointer);
        }
        if (highIndex > leftPointer){
            quickSort(array, leftPointer, highIndex);
        }
    }

    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }


}
