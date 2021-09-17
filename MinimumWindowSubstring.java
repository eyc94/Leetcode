/*
--- 76. Minimum Window Substring [HARD] ---

Given two strings "s" and "t" of lengths "m" and "n" respectively, return the minimum
window substring of "a" such that every character in "t" (including duplicates) is included
in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

--- EXAMPLES ---

- EX 1 -
Input:          s = "ADOBECODEBANC", t = "ABC"
Output:         "BANC"
Explanation:    The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

- EX 2 -
Input:          s = "a", t = "a"
Output:         "a"
Explanation:    The entire string s is the minimum window.

- EX 3 -
Input:          s = "a", t = "aa"
Output:         ""
Explanation:    Both 'a's from t must be included in the window. Since the largest window of s
                only has one 'a', return empty string.
*/

import java.util.HashMap;

public class MinimumWindowSubstring {

    /*
     * Time Complexity: O(m + n) where m is the length of s and n is the length of
     * t. This is because we iterate through t to place them in hash map. We then
     * iterate through s to find the minimum substring.
     * 
     * Space Complexity: O(n) where n is the length of t. This is because our hash
     * map holds the characters frequencies in string t. It does not hold every
     * character from string s.
     */

    public static String minWindow(String s, String t) {
        if (t.length() > s.length() || s.length() == 0 || t.length() == 0) {
            return "";
        }

        // These are the properties of the minimum window substring.
        // Initialize them to be the input string "s" itself.
        int smallestSize = s.length(); // This holds the size of the minimum window.
        int leftIndex = 0; // Left index of min window.
        int rightIndex = s.length() - 1; // Right index of min window.

        // Hash Map that keeps track of characters to look for in our window.
        // This map will hold all character frequencies in input string "t".
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // This holds the size of the map.
        // This will be our indicator to shrink or expand.
        int count = map.size();
        // This is a flag to tell the program that we have found a solution.
        boolean found = false;

        // We make window boundary and expand.
        int start = 0; // Left boundary.
        // Iterate through string "s". Right boundary.
        for (int end = 0; end < s.length(); end++) {
            // Grab right character.
            char rightChar = s.charAt(end);
            // If our map contains the right character.
            if (map.containsKey(rightChar)) {
                // Decrement frequency.
                map.put(rightChar, map.get(rightChar) - 1);
                // If our frequency reaches 0 for that character, it has satisfied the
                // requirement for just THAT character.
                if (map.get(rightChar) == 0) {
                    count--; // Decrement count to denote requirement for one character.
                }
            }

            // When count reaches 0, we know that ALL requirements are fulfilled, and we can
            // start looking for the smallest window containing these characters from the
            // map.
            while (count == 0) {
                // Grab the current window dimensions.
                // Length of window.
                int currentWindowSize = end - start + 1;
                // If our window is smallest than the smallest so far.
                if (currentWindowSize <= smallestSize) {
                    // Update smallest window.
                    smallestSize = currentWindowSize;
                    // Update left and right index (boundaries) of smallest window.
                    leftIndex = start;
                    rightIndex = end;
                    // Mark as found.
                    found = true;
                }

                // Now that we have updated, can we update more??
                // We need to shrink our window to see if the requirements are STILL fulfilled.
                // Shrink from the left, so grab the left character.
                char leftChar = s.charAt(start++);
                // If the map contains the left character.
                if (map.containsKey(leftChar)) {
                    // Increment the frequency.
                    map.put(leftChar, map.get(leftChar) + 1);
                    // If the frequency becomes positive (meaning our requirement is no longer
                    // fulfilled).
                    if (map.get(leftChar) > 0) {
                        // Increment count. After this, the while loop breaks until count reaches 0
                        // again.
                        count++;
                    }
                }
            }
        }

        // If we have found a string, return the string of the string "s".
        // Otherwise, return "".
        // This "found" flag is necessary because without it our code assumes the
        // initial boundaries represent the real answer when it fact it might not.
        // s = "a", t = "b". Without the flag, our code would say that the output is "a"
        // when it should be "". This is because our initial boundaries are 0 and 0.
        // Our return statement assumes found when it shouldn't. Our flag helps with
        // that.
        return (found) ? s.substring(leftIndex, rightIndex + 1) : "";
    }

    public static void main(String[] args) {
        // Sample strings.
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";

        String s2 = "a";
        String t2 = "a";

        String s3 = "a";
        String t3 = "aa";

        // Results.
        String r1 = minWindow(s1, t1);
        String r2 = minWindow(s2, t2);
        String r3 = minWindow(s3, t3);

        // Print results.
        System.out.println("Minimum substring of " + s1 + " that includes characters from " + t1 + " is: " + r1);
        System.out.println("Minimum substring of " + s2 + " that includes characters from " + t2 + " is: " + r2);
        System.out.println("Minimum substring of " + s3 + " that includes characters from " + t3 + " is: " + r3);
    }
}
