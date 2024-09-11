//Given a binary array containing 0’s and 1’s, find the largest subarray with equal numbers of 0’s and 1’s.
//
//For example,
//
//Input:  { 0, 0, 1, 0, 1, 0, 0 }
//
//Output: Largest subarray is { 0, 1, 0, 1 } or { 1, 0, 1, 0 }
package Array;

import java.util.Arrays;

public class LargestSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 0, 1, 0, 0};

        System.out.println(Arrays.toString(findTheBiggestSub(arr))); ;
    }
    public static int[] findTheBiggestSub(int[] array){
        int size = array.length;
        int[] subArray = new int[size];
        int newSize = 0;
        int oldMax = 0;
        int newMax = 0;
        for (int i = 0; i < array.length; i++) {
            subArray[0] = array[i];
            newSize++;
            for (int j = 0; j < array.length - 1; j++) {
                if(array[j] != array[j + 1]){
                    newMax++;
                    if(newMax > oldMax) {
                        oldMax = newMax;
                    }
                }
                int k = 0;
                for (; k < oldMax; k++) {
                    subArray[k] = array[j];
                }
            }
        }
        subArray = new int[oldMax];

        return subArray;
    }
}
