/*
--- 23. Merge K Sorted Lists [HARD] ---

You are given an array of "k" linked-lists "lists", each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

--- EXAMPLES ---

- EX 1 -
Input:          lists = [[1, 4, 5], [1, 3, 4], [2, 6]]
Output:         [1, 1, 2, 3, 4, 4, 5, 6]
Explanation:    The linked-lists are:
[
    1->4->5,
    1->3->4,
    2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

- EX 2 -
Input:          lists = []
Output:         []

- EX 3 -
Input:          lists = [[]]
Output:         []
*/

import java.util.*;

public class MergeKSortedLists {

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

    /*
     * Time Complexity: O(m*n log(m*n)) where m is the max nodes in a list and n is
     * the max number of lists.
     * 
     * Space Complexity: O(m*n).
     */

    public static ListNode mergeKLists(ListNode[] lists) {
        // Make priority queue to hold all node values.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Iterate through list.
        for (ListNode head : lists) {
            // Iterate through the linked list
            while (head != null) {
                // Add all values to min heap.
                minHeap.add(head.val);
                head = head.next;
            }
        }

        // Make new dummy head for new list.
        ListNode dummy = new ListNode(-1);
        // Scanner.
        ListNode newHead = dummy;
        // Iterate while min heap is not empty.
        while (!minHeap.isEmpty()) {
            // Grab the value of the lowest integer value in min heap.
            int currentVal = minHeap.remove();
            // Add new node with new value to the new list.
            newHead.next = new ListNode(currentVal);
            // Move scanner.
            newHead = newHead.next;
        }

        // Return the answer.
        return dummy.next;
    }

    // public static ListNode mergeKListsV2(ListNode[] lists) {
    // if (lists.length == 0) {
    // return null;
    // }

    // if (lists.length == 1) {
    // return lists[0];
    // }

    // if (lists.length == 2) {
    // return mergeTwoLists(lists[0], lists[1]);
    // }

    // int middleOfList = 0 + (lists.length - 1 - 0) / 2;

    // return mergeTwoLists(mergeKListsV2(lists))
    // }

    // public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    // }

    public static void main(String[] args) {
        // Sample linked lists.
        ListNode s1 = new ListNode(1);
        s1.next = new ListNode(4);
        s1.next.next = new ListNode(5);

        ListNode s2 = new ListNode(1);
        s2.next = new ListNode(3);
        s2.next.next = new ListNode(4);

        ListNode s3 = new ListNode(2);
        s3.next = new ListNode(6);

        ListNode[] sample = new ListNode[] { s1, s2, s3 };

        // Call merge function.
        ListNode result = mergeKLists(sample);

        // Print merged list.
        ListNode scanner = result;
        System.out.println("Merged list:");
        while (scanner != null) {
            if (scanner.next == null) {
                System.out.println(scanner.val);
            } else {
                System.out.print(scanner.val + " -> ");
            }
            scanner = scanner.next;
        }
    }
}
