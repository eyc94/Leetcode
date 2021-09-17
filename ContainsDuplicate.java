/*
--- 217. Contains Duplicate [EASY] ---

Given an integer array "nums", return "true" if any value appears at least twice
in the array, an return "false" if every element is distinct.

--- EXAMPLES ---

- EX 1 -
Input:          nums = [1, 2, 3, 1]
Output:         true

- EX 2 -
Input:          nums = [1, 2, 3, 4]
Output:         false

- EX 3 -
Input:          nums = [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
Output:         true
*/

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicate {

    /*
     * Time Complexity: O(N log N) because of the sorting.
     * 
     * Space Complexity: O(1).
     */

    public static boolean containsDuplicate(int[] nums) {
        // Sort the array so that duplicates are next to each other.
        Arrays.sort(nums);
        // Iterate to the second to last number.
        for (int i = 0; i < nums.length - 1; i++) {
            // If the numbers adjacent to each other are the same, return true.
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        // Return false.
        return false;
    }

    /*
     * Time Complexity: O(N) because we iterate through the array once.
     * 
     * Space Complexity: O(N) because we add numbers to the hash set. Worst case
     * will include all numbers.
     */

    public static boolean containsDuplicateV2(int[] nums) {
        // Create a hashset to contain unique numbers.
        HashSet<Integer> set = new HashSet<>();
        // Iterate through array.
        for (int i = 0; i < nums.length; i++) {
            // If set contains number, we have seen it. So, return true.
            if (set.contains(nums[i])) {
                return true;
            } else { // If we have not seen it, add to hash set.
                set.add(nums[i]);
            }
        }
        // Return false if unique.
        return false;
    }

    public static void main(String[] args) {
        // Sample arrays.
        int[] s1 = new int[] { 1, 2, 3, 1 };
        int[] s2 = new int[] { 1, 2, 3, 4 };
        int[] s3 = new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };

        // Results.
        boolean r1 = containsDuplicate(s1);
        boolean r2 = containsDuplicate(s2);
        boolean r3 = containsDuplicate(s3);

        // Print results.
        System.out.println("Array " + Arrays.toString(s1) + " contains duplicates: " + r1);
        System.out.println("Array " + Arrays.toString(s2) + " contains duplicates: " + r2);
        System.out.println("Array " + Arrays.toString(s3) + " contains duplicates: " + r3);
    }
}
