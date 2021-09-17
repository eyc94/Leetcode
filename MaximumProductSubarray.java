/*
--- 152. Maximum Product Subarray [MEDIUM] ---

Given an integer array "nums", find a contiguous non-empty subarray within
the array that has the largest product, and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

--- EXAMPLES ---

- EX 1 -
Input:          nums = [2, 3, -2, 4]
Output:         6
Explanation:    [2, 3] has the largest product 6.

- EX 2 -
Input:          nums = [-2, 0, -1]
Output:         0
Explanation:    The result cannot be 2, because [-2, -1] is not a subarray.
*/

import java.util.Arrays;

public class MaximumProductSubarray {

    /*
     * Time Complexity: O(N) where N is the length of the nums array.
     * 
     * Space Complexity: O(1).
     */

    public static int maxProduct(int[] nums) {
        // Because our array and subarray can contain negative numbers, we need to keep
        // track of both positive and negative products (so far).
        // Initialize all three below to first value.
        int max = nums[0]; // Max product so far.
        int min = nums[0]; // Min product so far.
        int result = nums[0]; // Result to return.

        // Iterate through array.
        for (int i = 1; i < nums.length; i++) {
            // Store new max value in temp max so as not to affect the value of min.
            // We compare the current number * current max, current number * current min,
            // and current num. Take the max of the three.
            int temp_max = Math.max(nums[i] * max, Math.max(nums[i] * min, nums[i]));
            // We compare the same things but take the min of the three.
            min = Math.min(nums[i] * max, Math.min(nums[i] * min, nums[i]));
            // Assign max to the temp max we stored.
            max = temp_max;
            // Update result to return.
            result = Math.max(result, max);
        }
        // Return result.
        return result;
    }

    public static void main(String[] args) {
        // Sample arrays.
        int[] s1 = new int[] { 2, 3, -2, 4 };
        int[] s2 = new int[] { -2, 0, -1 };

        // Results.
        int r1 = maxProduct(s1);
        int r2 = maxProduct(s2);

        // Print results.
        System.out.println("Max product subarray of " + Arrays.toString(s1) + " is: " + r1);
        System.out.println("Max product subarray of " + Arrays.toString(s2) + " is: " + r2);
    }
}
