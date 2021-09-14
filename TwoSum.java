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

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                return new int[] { map.get(difference), i };
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] sampleOne = new int[] { 2, 7, 11, 15 };
        int[] sampleTwo = new int[] { 3, 2, 4 };
        int[] sampleThree = new int[] { 3, 3 };

        int targetOne = 9;
        int targetTwo = 6;
        int targetThree = 6;

        int[] resultOne = twoSum(sampleOne, targetOne);
        int[] resultTwo = twoSum(sampleTwo, targetTwo);
        int[] resultThree = twoSum(sampleThree, targetThree);

        System.out.println("S1: The two indices that sum to " + targetOne + " are: " + Arrays.toString(resultOne));
        System.out.println("S2: The two indices that sum to " + targetTwo + " are: " + Arrays.toString(resultTwo));
        System.out.println("S3: The two indices that sum to " + targetThree + " are: " + Arrays.toString(resultThree));
    }
}