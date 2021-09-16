/*
--- 16. Three Sum Closest ---

Given an integer array "nums" of length "n" and an integer "target", find three
integers in "nums" such that the sum is closest to "target".

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

--- EXAMPLES ---

- EX 1 -
Input:              nums = [-1, 2, 1, -4], target = 1
Output:             2
Explanation:        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

- EX 2 -
Input:              nums = [0, 0, 0], target = 1
Output:             0
*/

import java.util.Arrays;

public class ThreeSumClosest {

    /*
     * Time Complexity: O(N^2).
     * 
     * Space Complexity: O(1).
     */

    public static int threeSumClosest(int[] nums, int target) {
        // Sort the array first. O(N log N) time.
        Arrays.sort(nums);
        // Grab the first triplet sum and store in result.
        int result = nums[0] + nums[1] + nums[nums.length - 1];

        // Iterate through the array until 3rd to last to give room for last possible
        // triplet.
        for (int i = 0; i < nums.length - 2; i++) {
            // Find two sum with low and high pointers. Shrinking window.
            int low = i + 1;
            int high = nums.length - 1;

            // Shrink window.
            while (low < high) {
                // Grab the current triplet sum.
                int sum = nums[i] + nums[low] + nums[high];
                // If the sum is closer to the target than our current result is to the target.
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    // Update our result answer.
                    result = sum;
                }
                // If the sum is greater than the target
                if (sum > target) {
                    // Move the right boundary to the left to reduce sum.
                    high--;
                } else { // If the sum is less than or equal to target.
                    // Move the left boundary to the right to reduce sum.
                    low++;
                }
            }
        }
        // Return result.
        return result;
    }

    public static void main(String[] args) {
        // Sample arrays.
        int[] s1 = new int[] { -1, 2, 1, -4 };
        int[] s2 = new int[] { 0, 0, 0 };

        // Sample targets.
        int target = 1;

        // Results.
        int r1 = threeSumClosest(s1, target);
        int r2 = threeSumClosest(s2, target);

        // Print results.
        System.out.println("Sum of triplets close to target in array " + Arrays.toString(s1) + " is: " + r1);
        System.out.println("Sum of triplets close to target in array " + Arrays.toString(s2) + " is: " + r2);
    }
}
