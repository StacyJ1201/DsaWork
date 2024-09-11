package Array;

import java.util.Arrays;

public class PlusMinus {
    public static void main(String[] args) {
        String s1 = "minusplusminus";
        String s2 = "plusminusminusplus";

        char[] array = s2.toCharArray();
        int size = 0;
        char[] temp = new char[10];
        int index = 0;

        for(int i = 0; i < array.length; i++){
            if (array[i] == 'p') {
                temp[index] = '+';
                i = i + 3;
                size++;
                index++;
            } else if (array[i] == 'm') {
                temp[index] = '-';
                i = i + 4;
                size++;
                index++;
            }
        }
        char[] output = new char[size];
        int newIndex = 0;
        for(char input : temp){
            output[newIndex] = input;
            newIndex++;
            if(newIndex == size){
                break;
            }
        }
        System.out.println(Arrays.toString(output));
    }
}
