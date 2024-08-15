//WAP to find maximum 3 elements from a array
//int[] numArray = {10, 5, 8, 20, 15, 3, 25, 30};
//output:30,25,20

package Array;

public class BiggestThreeNumbers {
    public static void main(String[] args) {
        int[] numArray = {10, 5, 8, 20, 35, 3, 25, 30, 40};

        biggestNums(numArray);
    }
    private static void biggestNums(int[] array){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++) {
            if (array[i] > largest){
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = array[i];
            } else if (array[i] < largest && array[i] > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = array[i];
            } else if (array[i] < secondLargest && array[i] > thirdLargest){
                thirdLargest = array[i];
            }
        }

        System.out.println("Largest: " + largest);
        System.out.println("Second Largest: " + secondLargest);
        System.out.println("Third Largest: " + thirdLargest);
    }
}
