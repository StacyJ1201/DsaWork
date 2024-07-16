package searchingAlgos;

public class LinearSearch {
    public static void main(String args[]) {

        int[] array = new int[]{5, 25, 67, 48, 76, 32, 99, 105, 46};
        int target = 45;

        int result = findTarget(array, target);

        if ( result == -1){
        System.out.println("Your number is not in the list");
        } else {
        System.out.println("Your number is at index: " + result);
        }

    }

    public static int findTarget(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
