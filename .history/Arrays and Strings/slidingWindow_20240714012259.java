
/*
 * Sliding Window
 * 1. Maximum Sum Subarray of Size K (easy)
 * 
 * Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
 * 
 */

public class slidingWindow {
    public static void main (String[] args){
        int [] arr = {1,2,3,4,5,6};
        int k = 3;
        System.out.println("Max sum of subarray of size k: " + findMaxSumSubArray(arr, k));
    }

    public static int findMaxSumSubArray (int[] arr, int k){
        // input validation
        if (arr.length < k){
            throw new IllegalArgumentException("Arr must be longer than k!");
        }

        //Sum of first window
        int maxSum = 0;
        for (int i = 0; i<k ; i++){
        maxSum += arr[i];
        }

        //move through window
        int windowSum = maxSum;
        for (int i=k; i< arr.length; i++){
            windowSum += arr[i] - arr[i-k];
            maxSum = Math.max(windowSum, maxSum);
        }
        return maxSum;
    }
}



// public class slidingWindow {
//     public static int findMaxSumSubArray(int k, int[] arr) {
//         int maxSum = 0;
//         int windowSum = 0;
//         int windowStart = 0;

//         for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
//             windowSum += arr[windowEnd];

//             if (windowEnd >= k - 1) {
//                 maxSum = Math.max(maxSum, windowSum);
//                 windowSum -= arr[windowStart];
//                 windowStart++;
//             }
//         }

//         return maxSum;
//     }

//     public static void main(String[] args) {
//         int[] arr = { 2, 1, 5, 1, 3, 2 };
//         int k = 3;
//         System.out.println(findMaxSumSubArray(k, arr));
//     }
// }