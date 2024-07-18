package SortingAlgos;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3, 19, 36, 45, 117};

        System.out.println(Arrays.toString(shellSort(arr)));

    }
    public static int[] shellSort(int[] array) {
        int n = array.length;

        for (int incr = n/2; incr > 0; incr /= 2){
            for (int i = incr; i < n; i += 1) {
                int temp = array[i];
                int j;
                for (j = i; j >= incr && array[j - incr] > temp; j -= incr) {
                    array[j] = array[j - incr];
                }
                array[j] = temp;
            }
        }
        return array;
    }
}
