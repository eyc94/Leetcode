/*
--- 53. Maximum Subarray ---

Given an integer array "nums", find the contiguous subarray (containing at least
one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.

--- EXAMPLES ---

- EX 1 -
Input:          nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]    
Output:         6
Explanation:    [4, -1, 2, 1] has the largest sum = 6

- EX 2 -
Input:          nums = [1]
Output:         1

- EX 3 -
Input:          nums = [5, 4, -1, 7, 8]
Output:         23
*/

import java.util.Arrays;

public class MaximumSubarray {

    /*
     * This uses the Kadane's Algorithm.
     * 
     * Time Complexity: O(N) where N is the length of our array.
     * 
     * Space Complexity: O(1).
     */

    public static int maxSubArray(int[] nums) {
        // If the input array is of length 1, return that one element.
        if (nums.length == 1) {
            return nums[0];
        }

        // Keep track of largest sum of subarray in the array.
        int largestSum = Integer.MIN_VALUE;
        // Keep track of sum so far. Initialize to 0.
        int sumSoFar = 0;
        // Iterate through our nums array.
        for (int i = 0; i < nums.length; i++) {
            // Add the current value to the sum so far.
            int added = sumSoFar + nums[i];
            // We either start a new subarray OR add the current value to the current
            // subarray.
            sumSoFar = Math.max(added, nums[i]);
            // Update largest sum as needed.
            largestSum = Math.max(largestSum, sumSoFar);
        }

        // Return the largest sum.
        return largestSum;
    }

    public static void main(String[] args) {
        // Sample arrays.
        int[] s1 = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] s2 = new int[] { 1 };
        int[] s3 = new int[] { 5, 4, -1, 7, 8 };

        // Results.
        int r1 = maxSubArray(s1);
        int r2 = maxSubArray(s2);
        int r3 = maxSubArray(s3);

        // Print results.
        System.out.println("Max sum subarray of " + Arrays.toString(s1) + " is: " + r1);
        System.out.println("Max sum subarray of " + Arrays.toString(s2) + " is: " + r2);
        System.out.println("Max sum subarray of " + Arrays.toString(s3) + " is: " + r3);
    }
}