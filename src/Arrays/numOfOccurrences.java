package Arrays;

public class numOfOccurrences {
    public static void main(String[] args) {

        int[] array = {1, 3, 5, 5, 5, 5, 67, 67, 123, 125};
        int element = 67;

        int firstIndex = binarySearch(element, array,true);
        int lastIndex = binarySearch(element, array,false);

        if (firstIndex != -1){
            System.out.println("First Occurrence is at: " + firstIndex);
            System.out.println("Second Occurrence is at: " + lastIndex);
        } else {
            System.out.println("Element is not found");
        }
    }
    private static int binarySearch(int element, int[] array, boolean firstOccurrence){
        int lowerBound = 0;
        int upperBound = array.length - 1;
        int result = -1;

        while (lowerBound <= upperBound){
            int middleElement = lowerBound + (upperBound - lowerBound)/2;
            if (firstOccurrence) {
                if (element == array[middleElement]) {
                    result = middleElement;
                    upperBound = middleElement - 1;
                } else if (element < array[middleElement]) {
                    upperBound = middleElement - 1;
                } else {
                    lowerBound = middleElement + 1;
                }
            }
            else {
                if(element == array[middleElement]) {
                    result = middleElement;
                    lowerBound = middleElement + 1;
                } else if (element < array[middleElement]) {
                    upperBound = middleElement - 1;
                } else {
                    lowerBound = middleElement + 1;
                }
            }
        }
        return result;
    }
}
