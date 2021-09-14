/*
--- Merge Two Sorted Lists ---

Merge two sorted linked lists and return it as a sorted list. The list should
be made by splicing together the nodes of the first two lists.

--- EXAMPLES ---

- EX 1 -
Input:          l1 = [1, 2, 4], l2 = [1, 3, 4]
Output:         [1, 1, 2, 3, 4, 4]

- EX 2 -
Input:          l1 = [], l2 = []
Output:         []

- EX 3 -
Input:          l1 = [], l2 = [0]
Output:         [0]
*/

public class MergeTwoSortedLists {

    /*
     * Time Complexity: O(N) where N is the length of the shorter list. This is
     * because our code has it to stop iteration after the shorter list ends. Then,
     * we merge the shorter of the list to the remainder of the longer.
     * 
     * Space Complexity: O(1).
     */

    // ListNode class.
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a dummy head for the list we will return.
        ListNode dummy = new ListNode(0);
        // This is the pointer used to scan the result list.
        ListNode dummyPointer = dummy;

        // Traverse both linked lists until we reach null on either list.
        while (l1 != null && l2 != null) {
            // If the l1's value is less than l2's value.
            if (l1.val < l2.val) {
                // Grab l1's value and create a node with it.
                ListNode newNode = new ListNode(l1.val);
                // Add to result list.
                dummyPointer.next = newNode;
                // Move the head of l1.
                l1 = l1.next;
            } else { // If l1's value is greater than or equal to l2's value.
                // Grab l2's value and create a node with it.
                ListNode newNode = new ListNode(l2.val);
                // Add to result list.
                dummyPointer.next = newNode;
                // Move the head of l2.
                l2 = l2.next;
            }
            // Move the pointer for the result list.
            dummyPointer = dummyPointer.next;
        }

        // If l2's list is longer.
        if (l1 == null && l2 != null) {
            // Add the remainder of l2 to result.
            dummyPointer.next = l2;
        }

        // If l1's list is longer.
        if (l2 == null && l1 != null) {
            // Add the remainder of l1 to result.
            dummyPointer.next = l1;
        }

        // Return the next node of the dummy head.
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode firstHead = new ListNode(1);
        firstHead.next = new ListNode(2);
        firstHead.next.next = new ListNode(4);

        ListNode secondHead = new ListNode(1);
        secondHead.next = new ListNode(3);
        secondHead.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(firstHead, secondHead);

        ListNode scanner = result;
        while (scanner != null) {
            System.out.print(scanner.val);
            if (scanner.next != null) {
                System.out.print(" -> ");
            }
            scanner = scanner.next;
        }
        System.out.println();
    }
}
