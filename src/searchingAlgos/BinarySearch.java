package searchingAlgos;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = new int[]{11, 24, 9, 44, 51, 52, 14, 80, 2};
        int target = 52;

        int result = binarySearch(array, target);

        if (result == -1){
            System.out.println("Your target is not in here");
        } else {
            System.out.println("Your target was found at index: " + result);
        }
    }

    public static int binarySearch(int[] array, int target) {
        Arrays.sort(array);

        int lowerBound = 0;
        int upperBound = array.length -1;

        while (lowerBound <= upperBound){
            int middleElement = lowerBound + (upperBound - lowerBound)/2;

            if (array[middleElement] == target){
                return middleElement;
            } else if(target > array[middleElement]){
                lowerBound = middleElement + 1;
            } else {
                upperBound = middleElement - 1;
            }
        }
        return -1;
    }
}
