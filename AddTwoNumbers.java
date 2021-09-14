/*
--- Add Two Numbers ---

You are given two non-empty linked lists representing two non-negative integers. The
digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

--- EXAMPLES ---

- EX 1 -
Input:          l1 = [2, 4, 3], l2 = [5, 6, 4]
Output:         [7, 0, 8]
Explanation:    342 + 465 = 807

- EX 2 -
Input:          l1 = [0], l2 = [0]
Output:         [0]

- EX 3 -
Input:          l1 = [9, 9, 9, 9, 9, 9, 9], l2 = [9, 9, 9, 9]
Output:         [8, 9, 9, 9, 0, 0, 0, 1]
*/

public class AddTwoNumbers {

    /*
     * Time Complexity: O(M + N) where M is the length of l1 and N is the length of
     * l2.
     * 
     * Space Complexity: O(1).
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // This is the new Linked List to return that contains the sum.
        ListNode dummy = new ListNode(0); // Dummy head.
        ListNode dummyPointer = dummy; // Pointer for this list.

        int carry = 0; // This is the carry value that we'll use when we carrover a number.
        // Iterate while l1 or l2 does not equal null.
        // This means that once l1 or l2 reaches null, we still loop through it.
        // There are conditions to handle this (non-equal list sizes).
        while (l1 != null || l2 != null) {
            // We find the value of l1.
            // If the l1 is null (finished before l2), its value is 0.
            // If the l1 is not null (have not finished l1), its value is the current value.
            int l1Val = (l1 != null) ? l1.val : 0;
            // We find the value of l2.
            // If the l2 is null (finished before l1), its value is 0.
            // If the l2 is not null (have not finished it), its value is the current value.
            int l2Val = (l2 != null) ? l2.val : 0;

            // Calculate the sum of the values of l1 and l2 and carry over.
            int currentSum = l1Val + l2Val + carry;

            // Find the last digit to use to create the new node.
            int lastDigit = currentSum % 10;
            // Update the new carry over value for the next iteration and summing.
            carry = currentSum /= 10;
            // Create a new node with the last digit.
            ListNode newNode = new ListNode(lastDigit);
            // Add the new node to the new list.
            dummyPointer.next = newNode;

            // If our l1 still has more terms to go, move l1 pointer.
            if (l1 != null) {
                l1 = l1.next;
            }

            // If our l2 still has more terms to go, move l2 pointer.
            if (l2 != null) {
                l2 = l2.next;
            }

            // Move pointer of new sum list.
            dummyPointer = dummyPointer.next;
        }

        // There can also be an extra carry over value when the list is done iterating
        // through. If we have a leftover carry, we just add a new node with this value.
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            dummyPointer.next = newNode;
            dummyPointer = dummyPointer.next;
        }

        // Return the next node after dummy head.
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode headOne = new ListNode(2);
        headOne.next = new ListNode(4);
        headOne.next.next = new ListNode(3);

        ListNode headTwo = new ListNode(5);
        headTwo.next = new ListNode(6);
        headTwo.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(headOne, headTwo);

        ListNode scanner = result;
        while (scanner != null) {
            System.out.print(scanner.val + " -> ");
            scanner = scanner.next;
        }
    }
}
