/*
--- 20. Valid Parentheses [EASY] ---

Given a string "s" containing just the characters '(', ')', '{', '}', '[', ']', determine
if the input string is valid.

An input string is valid if:

    1. Open brackets must be closed by the same type of brackets.
    2. Open brackets must be closed in the correct order.

--- EXAMPLE ---

- EX 1 -
Input:          s = "()"
Output:         true

- EX 2 -
Input:          s = "()[]{}"
Output:         true

- EX 3 -
Input:          s = "(]"
Output:         false

- EX 4 -
Input:          s = "([)]"
Output:         false

- EX 5 -
Input:          s = "{[]}"
Output:         true
*/

import java.util.Stack;

public class ValidParentheses {

    /*
     * Time Complexity: O(N) where N is the length of our string.
     * 
     * Space Complexity: O(N) where N is the length of our string. In the worst
     * case, we push all characters to the stack.
     */

    public static boolean isValid(String s) {
        // This is the stack to push opening brackets, braces, and parentheses to.
        Stack<Character> stack = new Stack<>();

        // Iterate through input string.
        for (char c : s.toCharArray()) {
            // If it is an opening character, push to stack.
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else if (c == ']' || c == '}' || c == ')') { // If it is a closing character.
                // If the stack is empty, there is no opening character to balance the closing
                // character. Return false immediately.
                if (stack.isEmpty()) {
                    return false;
                }
                // Peek the top character of the stack.
                char topChar = stack.peek();
                // If the top of the stack (open) matches its closing counterpart.
                if (c == ']' && topChar == '[' || c == '}' && topChar == '{' || c == ')' && topChar == '(') {
                    // Pop the opening character off the stack as its balanced to that end.
                    stack.pop();
                } else {
                    // If the characters do not match, return false for imbalance.
                    return false;
                }
            }
        }

        // Empty stack denotes a perfect balanced parentheses string.
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Sample strings.
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";

        // Results.
        boolean r1 = isValid(s1);
        boolean r2 = isValid(s2);
        boolean r3 = isValid(s3);
        boolean r4 = isValid(s4);
        boolean r5 = isValid(s5);

        // Print results.
        System.out.println(s1 + " valid parentheses? " + r1);
        System.out.println(s2 + " valid parentheses? " + r2);
        System.out.println(s3 + " valid parentheses? " + r3);
        System.out.println(s4 + " valid parentheses? " + r4);
        System.out.println(s5 + " valid parentheses? " + r5);
    }
}
