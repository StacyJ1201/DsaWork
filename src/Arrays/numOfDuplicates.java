package Arrays;

import java.util.Arrays;

public class numOfDuplicates {
    public void howManyDupes(int[] array){
        Arrays.sort(array);

        int j = 0;
        int[] temp = new int[array.length];

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i+1] && array[i] != array[i + 2]){
                temp[j++] = array[i];
            }
        }

        int result[] = new int[j];

        for (int i = 0; i < result.length; i++) {
            result[i] = temp[i];
        }

        System.out.println("Total repeated length: " + result.length);
        System.out.println(Arrays.toString(result));
    }
}
