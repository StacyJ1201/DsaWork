//WAP to find Which number is missing in assorted array

package Array;

public class MissingNum {
    public static void main(String[] args) {
        int length = 5;

        int[] array = {1,2,3,4,5,6,7,8,9};

        if (numMissing(array) == -1){
            System.out.println("No missing number");
        } else {
            System.out.println(numMissing(array));
        }
    }

    public static int numMissing(int[] array){
        for (int i = 1; i <= array.length; i++) {
            if (array[i - 1] != i){
                return i;
            }
        }
        return -1;
    }
}
