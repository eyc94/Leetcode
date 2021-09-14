/*
--- 1. Two Sum ---

Given an array of integers "nums" and an integer "target", return indices of the two
numbers such that they add up to "target".

You may assume that each input would have exactly one solution, and you may not use
the same element twice.

You can return the answer in any order.

--- EXAMPLES ---

- EX 1 -
Input:      nums = [2, 7, 11, 15], target = 9
Output:     [0, 1]
Output:     Because nums[0] + nums[1] == 9, we return [0, 1]

- EX 2 -
Input:      nums = [3, 2, 4], target = 6
Output:     [1, 2]

- EX 3 -
Input:      nums = [3, 3], target = 6
Output:     [0, 1]
*/

import java.util.*;

public class TwoSum {

    /*
     * Time Complexity: O(N) where N is the length of our nums array.
     * 
     * Space Complexity: O(N) where N is the length of our nums array.
     */

    public static int[] twoSum(int[] nums, int target) {
        // This map tracks the indices of numbers in our array.
        HashMap<Integer, Integer> map = new HashMap<>();

        // We iterate through our nums array.
        for (int i = 0; i < nums.length; i++) {
            // Find the difference between the target and the current num.
            int difference = target - nums[i];
            // If our map contains the difference (Meaning we came across this difference).
            if (map.containsKey(difference)) {
                // We found our answer so return the index of the difference and the current
                // index.
                return new int[] { map.get(difference), i };
            } else { // If our map does not contain the difference.
                map.put(nums[i], i); // Add the current number and its index in the array.
            }
        }

        // Return null if there is no pair of indices that add to target.
        return null;
    }

    public static void main(String[] args) {
        // Sample arrays.
        int[] sampleOne = new int[] { 2, 7, 11, 15 };
        int[] sampleTwo = new int[] { 3, 2, 4 };
        int[] sampleThree = new int[] { 3, 3 };

        // Sample targets.
        int targetOne = 9;
        int targetTwo = 6;
        int targetThree = 6;

        // Results.
        int[] resultOne = twoSum(sampleOne, targetOne);
        int[] resultTwo = twoSum(sampleTwo, targetTwo);
        int[] resultThree = twoSum(sampleThree, targetThree);

        // Print results.
        System.out
                .println("Sample 1: The two indices that sum to " + targetOne + " are: " + Arrays.toString(resultOne));
        System.out
                .println("Sample 2: The two indices that sum to " + targetTwo + " are: " + Arrays.toString(resultTwo));
        System.out.println(
                "Sample 3: The two indices that sum to " + targetThree + " are: " + Arrays.toString(resultThree));
    }
}