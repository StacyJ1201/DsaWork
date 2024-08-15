package Array;

public class numStringsAndDigits {
    public static void main(String[] args) {
        String[] list = new String[]{"apple", "23", "banana", "strawberry", "24", "77"};

        isNumericLogic(list);
    }

    public static void isNumericLogic(String[] array) {
        int numStrings = 0;
        int numInts = 0;

        for (int i = 0; i < array.length; i++) {
            if (isNumeric(array[i]) == -1){
                numStrings++;
            } else {
                numInts++;
            }
        }
        System.out.println("Number of Strings: " + numStrings);
        System.out.println("Number of integers: " + numInts);
    }

    public static int isNumeric(String currentElement) {
        try {
            Integer.parseInt(currentElement);
            return 1;
        } catch (NumberFormatException e){
            return -1;
        }
    }

}
