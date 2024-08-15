package Array;

import java.util.Arrays;

public class removeDuplicates {

    public int[] noDuplicates(int[] array){
        Arrays.sort(array);

        int j = 0;
        int temp[] = new int[array.length];

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                temp[j++] = array[i];
            }
        }

        temp[j++] = array[array.length - 1];

        int[] newArray = new int[j];

        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = temp[i];
        }
        return newArray;
    }
}
