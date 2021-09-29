/*
--- 141. Linked List Cycle [EASY] ---

Given "head", the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached
again by continuously following the "next" pointer. Internally, "pos" is used to
denote the index of the node that tail's "next" pointer is conneted to. Note that "pos"
is not passed as a parameter.

Return "true" if there is a cycle in the linked list. Otherwise, return "false".

--- EXAMPLES ---

- EX 1 -
Input:          head = [3, 2, 0, -4], pos = 1
Output:         true
Explanation:    There is a cycle in the linked list, where the tail connects to the
                1st node (0-indexed).

- EX 2 -
Input:          head = [1, 2], pos = 0
Output:         true
Explanation:    There is a cycle in the linked list, where the tail connects to the
                0th node.
            
- EX 3 -
Input:          head = [1], pos = -1
Output:         false
Explanation:    There is no cycle in the linked list.
*/

public class LinkedListCycle {

    /*
     * Time Complexity: O(N) where N is the length of our Linked List.
     * 
     * Space Complexity: O(1).
     */

    // This is the ListNode class.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        // Make a slow and fast pointer.
        // If there is a cycle, the two will eventually meet.
        // If not, the fast pointer will reach null and stop.
        ListNode slow = head;
        ListNode fast = head;

        // Iterate until fast pointer reaches null.
        while (fast != null && fast.next != null) {
            // Increment fast and slow pointers.
            fast = fast.next.next;
            slow = slow.next;
            // If the fast and slow pointer meet, return true.
            if (fast == slow) {
                return true;
            }
        }

        // If fast pointer reaches null, no cycle.
        // Return false.
        return false;
    }

    public static void main(String[] args) {
        // Cycle linked list.
        ListNode s1 = new ListNode(1);
        s1.next = new ListNode(2);
        s1.next.next = new ListNode(3);
        s1.next.next.next = new ListNode(4);
        // This makes the Linked List have a cycle.
        // s1.next.next.next.next = s1.next;

        // Call function.
        boolean r1 = hasCycle(s1);

        // Print result.
        System.out.println("Sample 1 has cycle: " + r1);
    }
}
