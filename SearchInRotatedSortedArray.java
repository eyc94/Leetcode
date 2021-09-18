/*
--- 33. Search in Rotated Sorted Array [MEDIUM]

There is an integer array "nums" sorted in ascending order (with distinct values).

Prior to being passed to your function, "nums" is rotated at an unknown pivot index
"k" (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k + 1], ..., 
nums[k - 1]] (0-indexed). For example, [0, 1, 2, 4, 5, 6, 7] might be rotated at pivot
index 3 and become [4, 5, 6, 7, 0, 1, 2].

Given the array "nums" after the rotation and an integer "target", return the index of
"target" if it is in "nums", or -1 if it is not in "nums".

You must write an algorithm with O(log N) runtime complexity.

--- EXAMPLES ---

- EX 1 -
Input:          nums = [4, 5, 6, 7, 0, 1, 2], target = 0
Output:         4

- EX 2 -
Input:          nums = [4, 5, 6, 7, 0, 1, 2], target = 3
Output:         -1

- EX 3 -
Input:          nums = [1], target = 0
Output:         -1
*/

import java.util.Arrays;

public class SearchInRotatedSortedArray {

    /*
     * Time Complexity: O(log N) because we do a modified binary search.
     * 
     * Space Complexity: O(1).
     */

    public static int search(int[] nums, int target) {
        // Make the boundaries for binary search.
        int low = 0;
        int high = nums.length - 1;

        // While they do not meet.
        while (low <= high) {
            // Get the middle index.
            int mid = low + (high - low) / 2;
            // If the middle number is the target, return the middle index.
            if (nums[mid] == target) {
                return mid;
                // If the middle number is greater than the low boundary.
                // This means that the left half is increasing.
            } else if (nums[mid] >= nums[low]) {
                // Let's check if the target is between this constantly increasing left half.
                // If it is, we just have to perform binary search on the left half.
                if (target >= nums[low] && target <= nums[mid]) {
                    // Move the high boundary to lower half.
                    high = mid - 1;
                } else { // If the target is not in the left half, we know it's in the right half.
                    low = mid + 1; // Move low boundary up to right half.
                }
            } else { // If the number is less than low number.
                // This means we know that the left half is NOT constantly increasing.
                // We know for a fact that the right half IS constantly increasing.
                // We see if the target exists in the right half.
                if (target >= nums[mid] && target <= nums[high]) { // If the target is in right half.
                    // Move low boundary to right half.
                    low = mid + 1;
                } else { // If the target is not in the right half, we know it's in the left half.
                    // Move high boundary down to left half.
                    high = mid - 1;
                }
            }
        }

        // If we reach this, we know that there does not exist a target.
        // Return -1.
        return -1;
    }

    public static void main(String[] args) {
        // Sample arrays.
        int[] s1 = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int[] s2 = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int[] s3 = new int[] { 1 };

        // Sample targets.
        int t1 = 0;
        int t2 = 3;
        int t3 = 0;

        // Results.
        int r1 = search(s1, t1);
        int r2 = search(s2, t2);
        int r3 = search(s3, t3);

        // Print results.
        System.out.println("The index of target " + t1 + " in the array " + Arrays.toString(s1) + " is: " + r1);
        System.out.println("The index of target " + t2 + " in the array " + Arrays.toString(s2) + " is: " + r2);
        System.out.println("The index of target " + t3 + " in the array " + Arrays.toString(s3) + " is: " + r3);
    }
}
