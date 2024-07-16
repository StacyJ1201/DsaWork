package searchingAlgos;

public class MinimumElement {
    public static void main(String [] args) {
        int[] array = new int[]{4,5,6,7,0,1,2};

        int result = minimumElement(array);

        if (result == -1){
            System.out.println("There is no minimum element");
        } else {
            System.out.println(result);
        }
    }

    public static int minimumElement(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]){
                return array[i + 1];
            }
        }
        return -1;
    }
}
