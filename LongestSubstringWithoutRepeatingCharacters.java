/*
--- Longest Substring Without Repeating Characters ---

Given a string "s", find the length of the longest substring without repeating characters.

--- EXAMPLES ---

- EX 1 -
Input:          s = "abcabcbb"
Output:         3
Explanation:    The answer is "abc", with the length of 3.

- EX 2 -
Input:          s = "bbbbb"
Output:         1
Explanation:    The answer is "b", with the length of 1.

- EX 3 -
Input:          s = "pwwkew"
Output:         3
Explanation:    The answer is "wke", with the length of 3. Notice that the
                answer must be a substring, "pwke" is a subsequence not a substring.

- EX 4 -
Input:          s = ""
Output:         0
*/

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    /*
     * Time Complexity: O(N) where N is the length of our string.
     * 
     * Space Complexity: O(N) in the worst case where N is the length of our string
     * because our map will contain all characters of our string.
     */

    public static int lengthOfLongestSubstring(String s) {
        // If our string is empty, there is no substring. Return 0.
        if (s.length() == 0) {
            return 0;
        }

        // This keeps track of the longest substring with no repeating characters.
        int longest = Integer.MIN_VALUE;
        // Hash Map to keep track of characters and their frequency.
        HashMap<Character, Integer> map = new HashMap<>();

        // Left window pointer.
        int start = 0;
        // Iterate through string by expanding window to the right.
        for (int end = 0; end < s.length(); end++) {
            // Grab the character at right window.
            char currentChar = s.charAt(end);
            // Increment that character's frequency.
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            // We need to make sure that the frequency of the character we just put in is 1
            // or less. Iterate while the frequency is greater than 1.
            while (map.get(currentChar) > 1) {
                // Grab the left window character.
                char leftChar = s.charAt(start);
                // Decrement that character's frequency.
                map.put(leftChar, map.get(leftChar) - 1);
                // Shift left window border to the right.
                start++;
            }
            // When we get out of the loop, we have a valid substring.
            // Update the longest length if applicable.
            longest = Math.max(longest, end - start + 1);
        }
        // Return this longest length.
        return longest;
    }

    public static void main(String[] args) {
        // Sample strings.
        String sampleOne = "abcabcbb";
        String sampleTwo = "bbbbb";
        String sampleThree = "pwwkew";
        String sampleFour = "";

        // Results.
        int resultOne = lengthOfLongestSubstring(sampleOne);
        int resultTwo = lengthOfLongestSubstring(sampleTwo);
        int resultThree = lengthOfLongestSubstring(sampleThree);
        int resultFour = lengthOfLongestSubstring(sampleFour);

        // Print results.
        System.out.println("Longest substring without repeating characters of " + sampleOne + " is: " + resultOne);
        System.out.println("Longest substring without repeating characters of " + sampleTwo + " is: " + resultTwo);
        System.out.println("Longest substring without repeating characters of " + sampleThree + " is: " + resultThree);
        System.out.println("Longest substring without repeating characters of " + sampleFour + " is: " + resultFour);
    }
}
