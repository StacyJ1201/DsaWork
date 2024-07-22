package SortingAlgos;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3, 19, 36, 45, 117};

        System.out.println(Arrays.toString(shellSortDivided(arr)));

    }
    public static int[] shellSort(int[] array) {
        int n = array.length;

        for (int incr = 3; incr > 0; incr--){
            for (int L = 0; L < n; L++) {
                for (int i = 0; i < n; i+= incr) {
                    int temp = array[i];
                    int j;
                    for (j = i; j >= incr && array[j - incr] > temp; j -= incr) {
                        array[j] = array[j - incr];
                    }
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    private static int[] shellSortDivided(int[] array){

        for (int gap = array.length/2; gap > 0; gap/=2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                while (j >= gap && array[j] <= array[j - gap]){
                    int temp = array[j];
                    array[j] = array[j-gap];
                    array[j-gap] = temp;
                    j-=gap;
                }
            }
        }
        return array;
    }
}
