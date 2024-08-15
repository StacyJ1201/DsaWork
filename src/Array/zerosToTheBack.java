package Array;

import java.util.Arrays;

public class zerosToTheBack {
    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 0, 4, 9, 0, 3, 23};

        System.out.println(Arrays.toString(zerosToTheBack(array)));
    }

    public static int[] zerosToTheBack(int[] array) {
        int nonZero = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0){
                int temp = array[nonZero];
                array[nonZero] = array[i];
                array[i] = temp;
                nonZero++;
            }
        }
        return array;
    }
}
