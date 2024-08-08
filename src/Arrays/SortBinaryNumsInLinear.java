package Arrays;

import java.util.Arrays;

public class SortBinaryNumsInLinear {
    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 1, 0, 1, 0, 0, 1,0};

        System.out.println(Arrays.toString(newArray(array)));
    }

    public static int[] newArray(int[] array) {
        int zerosPlace = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                int temp = array[zerosPlace];
                array[zerosPlace] = array[i];
                array[i] = temp;
                zerosPlace++;
            }
        }
        return array;
    }
}
