/*
--- 133. Clone Graph [MEDIUM] ---

Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

--- Test Case Format ---

For simplicity, each node's value is the same as the node's index (1-indexed). For example,
the first node with val == 1, the second node with val == 2, and so on. The graph is represented
in the test case using an adjacency list.

An adjacency list is a collection of unordered lists used to represent a finite graph. Each list
describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given
node as a reference to the cloned graph.

--- EXAMPLES ---

- EX 1 -
Input:          adjList = [[2, 4], [1, 3], [2, 4], [1, 3]]
Output:         [[2, 4], [1, 3], [2, 4], [1, 3]]
Explanation:    There are 4 nodes in the graph.
                1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
                2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
                3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
                4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).

- EX 2 -
Input:          adjList = [[]]
Output:         [[]]
Explanation:    Note that the input contains one empty list. The graph consists of only one node
                with val = 1 and it does not have any neighbors.

- EX 3 -
Input:          adjList = []
Output:         []
Explanation:    This is an empty graph. It does not have any nodes.

- EX 4 -
Input:          adjList = [[2], [1]]
Output:         [[2], [1]]
*/

import java.util.*;

public class CloneGraph {

    /*
     * Time Complexity: O(V + E) because we iterate through each node and its
     * neighbors.
     * 
     * Space Complexity: O(V + E) because we store a mapping of all nodes and its
     * neighbors in our HashMap.
     */

    // Node class.
    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    // Make function.
    public static Node cloneGraph(Node node) {
        // The case when our graph is empty.
        if (node == null) {
            return null;
        }

        // Our map to keep track of our cloned graph.
        // We map our old nodes to the new cloned nodes.
        HashMap<Node, Node> oldToNew = new HashMap<>();

        // Call helper function that we call recursively.
        return makeClone(node, oldToNew);
    }

    // Helper function.
    public static Node makeClone(Node node, HashMap<Node, Node> map) {
        // If we have not seen this node yet.
        if (!map.containsKey(node)) {
            // Make the cloned node.
            Node clonedNode = new Node(node.val);
            // Add the mapping of old node to cloned node into the hash map.
            map.put(node, clonedNode);
            // Iterate through our node's neighbors.
            for (Node neighbor : node.neighbors) {
                // Add to the cloned node's neighbors list the result of calling the function
                // again on the neighbor node. This is the recursive call.
                // This will recursively call the function on every neighbor until we reach a
                // node whose neighbors are all visited.
                clonedNode.neighbors.add(makeClone(neighbor, map));
            }
        }
        // If we have seen the node, return this node's cloned node.
        // In the end, we will return the reference to the entry node's cloned node.
        return map.get(node);
    }

    public static void main(String[] args) {
        // Create nodes for graph sample one.
        Node nodeOne = new Node(1);
        Node nodeTwo = new Node(2);
        Node nodeThree = new Node(3);
        Node nodeFour = new Node(4);

        // Add node 1's neighbors.
        nodeOne.neighbors.add(nodeTwo);
        nodeOne.neighbors.add(nodeFour);

        // Add node 2's neighbors.
        nodeTwo.neighbors.add(nodeOne);
        nodeTwo.neighbors.add(nodeThree);

        // Add node 3's neighbors.
        nodeThree.neighbors.add(nodeTwo);
        nodeThree.neighbors.add(nodeFour);

        // Add node 4's neighbors.
        nodeFour.neighbors.add(nodeOne);
        nodeFour.neighbors.add(nodeThree);

        // Call the cloneGraph function.
        Node clonedGraphReference = cloneGraph(nodeOne);

        // Print the results. This is not a visually appealing print. Just a
        // verification of node's neighbors.
        System.out.println("Printing entry node: " + clonedGraphReference.val);
        for (Node node : clonedGraphReference.neighbors) {
            System.out.println("Printing entry node's neighbors: " + node.val);
            for (Node neighbor : node.neighbors) {
                System.out.println("Printing " + node.val + "'s neighbors: " + neighbor.val);
                for (Node s1 : neighbor.neighbors) {
                    System.out.println("Printing " + neighbor.val + "'s neighbors: " + s1.val);
                }
            }
        }
    }
}