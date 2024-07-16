package Arrays;

public class ZeroSumSubarrays {
    public static void findSubArrays(int[] arr) {
        int n = arr.length;

        // Traverse through all elements of the array
        for (int start = 0; start < n; start++) {
            int sum = 0;

            // Traverse through all possible end points of sub-arrays starting from start
            for (int end = start; end < n; end++) {
                sum += arr[end];

                // If sum is zero, print the sub-array from start to end
                if (sum == 0) {
                    printSubArray(arr, start, end);
                }
            }
        }
    }

    // Helper method to print sub-array from index start to end
    private static void printSubArray(int[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = { 4, 2, -3, -1, 0, 4 };
        int[] arr2 = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };

        System.out.println("Sub-arrays with sum 0 in arr1:");
        findSubArrays(arr1);

        System.out.println("\nSub-arrays with sum 0 in arr2:");
        findSubArrays(arr2);
    }
}

