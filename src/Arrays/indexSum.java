package Arrays;

public class indexSum {
    int num1;
    int num2;
    int index1;
    int index2;
    public void findTheIndices(int[] array, int target){
        for (int i = 0; i < array.length; i++) {
            if (array[i] < target){
                 num1 = array[i];
                 index1 = i;
                for (int j = 0; j < array.length; j++) {
                    if (num1 + array[j] == target){
                        num2 = array[j];
                        index2 = j;
                        break;
                    }
                }
                System.out.println("These are the values: " + num1 + " " + num2);
                System.out.println("These are the indexes: " + index1 + " " + index2);
                break;
            }
        }
    }
}
