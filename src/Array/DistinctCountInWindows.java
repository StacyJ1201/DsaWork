package Array;
import java.util.Arrays;

public class DistinctCountInWindows {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 1, 3, 4, 2, 3};
        int k1 = 4;
        System.out.println("Input: " + Arrays.toString(arr1) + ", k = " + k1);
        System.out.println("Output: " + Arrays.toString(countDistinctInWindows(arr1, k1))); // Output: [3, 4, 4, 3]

        int[] arr2 = {1, 2, 4, 4};
        int k2 = 2;
        System.out.println("Input: " + Arrays.toString(arr2) + ", k = " + k2);
        System.out.println("Output: " + Arrays.toString(countDistinctInWindows(arr2, k2))); // Output: [2, 2, 1]
    }

    public static int[] countDistinctInWindows(int[] arr, int k) {
        int n = arr.length;
        if (n < k) return new int[0];

        int[] result = new int[n - k + 1];
        int[] freq = new int[100001]; // assuming array elements are <= 100000

        int distinctCount = 0;

        // Initialize the frequency array for the first window
        for (int i = 0; i < k; i++) {
            if (freq[arr[i]] == 0) {
                distinctCount++;
            }
            freq[arr[i]]++;
        }

        // Print the first window
        System.out.println("Window 1: " + Arrays.toString(Arrays.copyOfRange(arr, 0, k)) + " | Distinct count: " + distinctCount);
        result[0] = distinctCount;

        // Slide the window from start to end
        for (int i = k; i < n; i++) {
            // Remove the first element of the previous window
            if (freq[arr[i - k]] == 1) {
                distinctCount--;
            }
            freq[arr[i - k]]--;

            // Add the new element of the current window
            if (freq[arr[i]] == 0) {
                distinctCount++;
            }
            freq[arr[i]]++;

            // Print the current window
            System.out.println("Window " + (i - k + 2) + ": " + Arrays.toString(Arrays.copyOfRange(arr, i - k + 1, i + 1)) + " | Distinct count: " + distinctCount);
            result[i - k + 1] = distinctCount;
        }

        return result;
    }
}
