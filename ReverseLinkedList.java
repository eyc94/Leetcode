/*
--- 206. Reverse Linked List [EASY] ---

Given the "head" of a singly linked list, reverse the list, and return
the reversed list.

--- EXAMPLES ---

- EX 1 -
Input:          head = [1, 2, 3, 4, 5]
Output:         [5, 4, 3, 2, 1]

- EX 2 -
Input:          head = [1, 2]
Output:         [2, 1]

- EX 3 -
Input:          head = []
Output:         []
*/

public class ReverseLinkedList {

    /*
     * Time Complexity: O(N) where N is the length of the original linked list.
     * 
     * Space Complexity: O(1) because we do not use extra space other than pointers.
     */

    // This is the ListNode class.
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

    public static ListNode reverseList(ListNode head) {
        // This prev pointer will be the new head of the reversed linked list.
        ListNode prev = null;
        // This is the scanner that we move to the end.
        ListNode curr = head;

        // Iterate while the scanner is not null.
        while (curr != null) {
            // Make a reference to the next node to move to.
            ListNode next = curr.next;
            // Point the next pointer of our current node to the previous node. This way we
            // work backwards.
            curr.next = prev;
            // Move prev to curr because this will be the new prev.
            prev = curr;
            // Move curr to next pointer to analyze in the next iteration.
            curr = next;
        }
        // Return the head of the reversed linked list.
        return prev;
    }

    public static void main(String[] args) {
        // Sample Linked List.
        ListNode s1 = new ListNode(1);
        s1.next = new ListNode(2);
        s1.next.next = new ListNode(3);
        s1.next.next.next = new ListNode(4);
        s1.next.next.next.next = new ListNode(5);

        // Print original list.
        ListNode scanner = s1;
        System.out.println("Original list:");
        while (scanner != null) {
            if (scanner.next == null) {
                System.out.println(scanner.val);
            } else {
                System.out.print(scanner.val + "-> ");
            }
            scanner = scanner.next;
        }

        // Call to reverse list.
        ListNode r1 = reverseList(s1);

        // Print out reversed list.
        scanner = r1;
        System.out.println("Reversed List:");
        while (scanner != null) {
            if (scanner.next == null) {
                System.out.println(scanner.val);
            } else {
                System.out.print(scanner.val + "-> ");
            }
            scanner = scanner.next;
        }
    }
}
