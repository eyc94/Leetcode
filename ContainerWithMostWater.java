import java.util.Arrays;

/*
--- Container With Most Water ---

Given "n" non-negative integers a1, a2, ..., an, where each represents a point at
coordinate (i, ai). "n" vertical lines are drawn such that the two endpoints of
the line "i" is at (i, ai) and (i, 0). Find two lines, which, together with the
x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

--- EXAMPLES ---

- EX 1 -
Input:          height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
Output:         49
Explanation:    The max area of water the container can contain is 49.

- EX 2 -
Input:          height = [1, 1]
Output:         1

- EX 3 -
Input:          height = [4, 3, 2, 1, 4]
Output:         16

- EX 4 -
Input:          height = [1, 2, 1]
Output:         2
*/

public class ContainerWithMostWater {

    /*
     * Time Complexity: O(N) where N is the length of our array.
     * 
     * Space Complexity: O(1).
     */

    public static int maxArea(int[] height) {
        // Left window.
        int i = 0;
        // Right window.
        int j = height.length - 1;

        // Holds the largest area seen so far.
        int largestArea = Integer.MIN_VALUE;
        // Shrink window from both ends.
        while (i < j) {
            // Grab the minimum height between the left and right window.
            int min = Math.min(height[i], height[j]);
            // Grab the area. Length x width.
            int area = min * (j - i);
            // Update largest area so far.
            largestArea = Math.max(largestArea, area);
            // Move left window to the right if left height is smaller than right.
            if (height[i] < height[j]) {
                i++;
            } else { // Move right window to the left if right height is <= left.
                j--;
            }
        }

        // Return largest area overall.
        return largestArea;
    }

    public static void main(String[] args) {
        // Sample arrays.
        int[] sampleOne = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int[] sampleTwo = new int[] { 1, 1 };
        int[] sampleThree = new int[] { 4, 3, 2, 1, 4 };
        int[] sampleFour = new int[] { 1, 2, 1 };

        // Results
        int resultOne = maxArea(sampleOne);
        int resultTwo = maxArea(sampleTwo);
        int resultThree = maxArea(sampleThree);
        int resultFour = maxArea(sampleFour);

        // Print results
        System.out.println("Largest area of " + Arrays.toString(sampleOne) + ": " + resultOne);
        System.out.println("Largest area of " + Arrays.toString(sampleTwo) + ": " + resultTwo);
        System.out.println("Largest area of " + Arrays.toString(sampleThree) + ": " + resultThree);
        System.out.println("Largest area of " + Arrays.toString(sampleFour) + ": " + resultFour);
    }
}
