package Array;

//Write a Java program to find the second-largest number in Java.
public class secondLargestNum {

    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;

    public int secondLargest(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest){
                secondLargest = largest;
                largest = array[i];
            } else if (array[i] < largest && array[i] > secondLargest){
                secondLargest = array[i];
            }
        }
        return secondLargest;
    }
}

