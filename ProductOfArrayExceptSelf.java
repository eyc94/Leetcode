/*
--- 238. Product of Array Except Self ---

Given an integer array "nums", return an array "answer" such that "answer[i]" is equal
to the product of all the elements of "nums" except "nums[i]".

The product of any prefix or suffix of "nums" is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in "O(N)" time and without using the division
operator.

--- EXAMPLE ---

- EX 1 -
Input:          nums = [1, 2, 3, 4]
Output:         [24, 12, 8, 6]

- EX 2 -
Input:          nums = [-1, 1, 0, -3, 3]
Output:         [0, 0, 9, 0, 0]
*/

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    /*
     * Time Complexity: O(N) where N is the length of nums.
     * 
     * Space Complexity: O(1) if we do not count the returning array. If we are
     * counting the returning array, it is actually O(N) where N is the length of
     * nums.
     */

    public static int[] productExceptSelf(int[] nums) {
        // This is the result array that has the products of numbers except self.
        int[] result = new int[nums.length];
        // We want to pre-populate it with the value 1.
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
        }

        // We scan left-to-right first.
        // We gather up the product of every number on the way to the right.
        // We start the left product at 1.
        int leftProduct = 1;
        // Iterate through left-to-right.
        for (int i = 0; i < nums.length; i++) {
            // Multiply the gathered products before the number with the current position.
            result[i] *= leftProduct;
            // Gather up the left product with the current spot on "nums".
            leftProduct *= nums[i];
        }

        // We scan right-to-left now.
        // We gather the products from right-to-left.
        // Start the product at 1.
        int rightProduct = 1;
        // Begin scanning right-to-left.
        for (int i = nums.length - 1; i >= 0; i--) {
            // Multiply the gathered product with the current position of results.
            result[i] *= rightProduct;
            // Gather up the product with the current position on "nums".
            rightProduct *= nums[i];
        }

        // Return the result array.
        return result;
    }

    public static void main(String[] args) {
        // Sample arrays.
        int[] s1 = new int[] { 1, 2, 3, 4 };
        int[] s2 = new int[] { -1, 1, 0, -3, 3 };

        // Results.
        int[] r1 = productExceptSelf(s1);
        int[] r2 = productExceptSelf(s2);

        // Print results.
        System.out.println("Product of " + Arrays.toString(s1) + " except self: " + Arrays.toString(r1));
        System.out.println("Product of " + Arrays.toString(s2) + " except self: " + Arrays.toString(r2));
    }
}
