/*
--- 153. Find Minimum in Rotated Sorted Array ---

Suppose an array of length "n" sorted in ascending order is rotated between 1 and n
times. For example, the array nums = [0, 1, 2, 4, 5, 6, 7] might become:

    - [4, 5, 6, 7, 0, 1, 2] if it was rotated 4 times.
    - [0, 1, 2, 4, 5, 6, 7] if it was rotated 7 times.

Notice that rotating an array [a[0], a[1], a[2], ..., a[n - 1]] 1 time results in
the array [a[n - 1], a[0], a[1], a[2], ..., a[n - 2]].

Given the sorted rotated array "nums" of unique elements, return the minimum element
of this array.

You must write an algorithm that runs in O(log N) time.

--- EXAMPLES ---

- EX 1 -
Input:          nums = [3, 4, 5, 1, 2]
Output:         1
Explanation:    The original array was [1, 2, 3, 4, 5] rotated 3 times.

- EX 2 -
Input:          nums = [4, 5, 6, 7, 0, 1, 2]
Output:         0
Explanation:    The original array was [0, 1, 2, 4, 5, 6, 7] and it was rotated 4 times.

- EX 3 -
Input:          nums = [11, 13, 15, 17]
Output:         11
Explanation:    The original array was [11, 13, 15, 17] and it was rotated 4 times.
*/

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {

    /*
     * Time Complexity: O(log N) because we implement a modified Binary Search. A
     * linear search is O(N) but it is worse and you will fail automatically.
     * 
     * Space Complexity: O(1).
     */

    public static int findMin(int[] nums) {
        // This is the boundary that is initially set to the ends of array.
        int left = 0;
        int right = nums.length - 1;

        // We will cut our array in half on every iteration.
        // Iterate until the boundaries cross.
        while (left < right) {
            // Find the middle index.
            int mid = left + (right - left) / 2;

            // If our mid isn't the first number AND
            // If our middle number is LESS THAN the number to its left.
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                // Return mid because it's our minimum (because pivot).
                /*
                 * This is important to understand that our array increases and then decreases
                 * and then increases. We want to find the point of decrease. This will be the
                 * minimum in our array.
                 */
                return nums[mid];
                // If the middle number is greater than the left number AND greater than the
                // right. This means that we can explore the right side more.
                // If our mid is greater than our left, this means the left half is sorted.
                // So, you gotta look right.
                /*
                 * It's important to understand why we check the right number as well. We will
                 * run into the situation where the right number may actually be still greater
                 * than our middle number. This means the right half is sorted and we gotta look
                 * to the left half.
                 */
            } else if (nums[mid] >= nums[left] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else { // Look to the left half otherwise.
                right = mid - 1;
            }
        }
        // Return the number on the left pointer. This also accounts for when the array
        // is already sorted as well. Our left pointer will always land on the number to
        // return and cross right pointer.
        return nums[left];
    }

    public static void main(String[] args) {
        // Sample arrays.
        int[] s1 = new int[] { 3, 4, 5, 1, 1 };
        int[] s2 = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int[] s3 = new int[] { 11, 13, 15, 17 };

        // Results.
        int r1 = findMin(s1);
        int r2 = findMin(s2);
        int r3 = findMin(s3);

        // Print results.
        System.out.println("The minimum in the array " + Arrays.toString(s1) + " is: " + r1);
        System.out.println("The minimum in the array " + Arrays.toString(s2) + " is: " + r2);
        System.out.println("The minimum in the array " + Arrays.toString(s3) + " is: " + r3);
    }
}
