package Array;

public class twoLargestNums {
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;

    public void printTheTwoLargest(int[] array){
        for (int i = 0; i < array.length; i++) {
            if (largest < array[i]){
                secondLargest = largest;
                largest = array[i];
            } else if (largest > array[i] && secondLargest < array[i]) {
                secondLargest = array[i];
            }
        }
        System.out.println("The two largest numbers are: (" + secondLargest + ", " + largest + ")");
    }
}
