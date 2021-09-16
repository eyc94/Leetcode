/*
--- 15. Three Sum ---

Given an integer array "nums", return all the triplets [nums[i], nums[j], nums[k]] such that
i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

--- EXAMPLES ---

- EX 1 -
Input:          nums = [-1, 0, 1, 2, -1, -4]
Output:         [[-1, -1, 2], [-1, 0, 1]]

- EX 2 -
Input:          nums = []
Output:         []

- EX 3 -
Input:          nums = [0]
Output:         []
*/

import java.util.*;

public class ThreeSum {

    /*
     * Time Complexity: O(N^2)
     * 
     * Space Complexity: O(1) if we don't count the final returned list of lists.
     */

    public static List<List<Integer>> threeSum(int[] nums) {
        // Sort the array. O(N log N) time.
        Arrays.sort(nums);
        // List of lists to hold triplets that sum to zero.
        List<List<Integer>> result = new ArrayList<>();

        // Iterate through our nums array until the 3rd to last number.
        // Doing this gives room for the final iteration to hold last two numbers.
        for (int i = 0; i < nums.length - 2; i++) {
            // If the number we're at is the second at least.
            // If the number we're at is not equal to the one before.
            // This is so that we do not have the same triplet with the same first number.
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                // Make the boundary to find two sum of the remaining numbers.
                int low = i + 1; // Left boundary is one after i.
                int high = nums.length - 1; // Right boundary is at the right end.
                int target = 0 - nums[i]; // The sum must add to target to get triplet that sums to 0.

                // Shrink our window.
                while (low < high) {
                    // If our two numbers equals target.
                    if (nums[low] + nums[high] == target) {
                        // We found our numbers, so create a list and add to result list.
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        // These next 2 statements handles duplicate checking.
                        // Our left boundary (second #) must not be equal to the position to the right.
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        // Our right boundary (third #) must not be equal to position to its left.
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        // Move the boundaries inward.
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > target) { // If the sum is greater than target.
                        // Move right boundary to the left.
                        high--;
                    } else { // If the sum is less than target.
                        // Move left boundary to the right.
                        low++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Sample arrays.
        int[] s1 = new int[] { -1, 0, 1, 2, -1, -4 };
        int[] s2 = new int[] {};
        int[] s3 = new int[] { 0 };

        // Results.
        List<List<Integer>> r1 = threeSum(s1);
        List<List<Integer>> r2 = threeSum(s2);
        List<List<Integer>> r3 = threeSum(s3);

        // Print results.
        System.out.println("The triplets that add to 0 for " + Arrays.toString(s1) + ": " + r1);
        System.out.println("The triplets that add to 0 for " + Arrays.toString(s2) + ": " + r2);
        System.out.println("The triplets that add to 0 for " + Arrays.toString(s3) + ": " + r3);
    }
}
