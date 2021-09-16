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

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int target = 0 - nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == target) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > target) {
                        high--;
                    } else {
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
