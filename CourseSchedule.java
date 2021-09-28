/*
--- 207. Course Schedule [MEDIUM] ---

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You
are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take
course bi first if you want to take course ai.

For example, the pair [0, 1] indicates that to take course 0 you have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.

--- EXAMPLES ---

- EX 1 -
Input:          numCourses = 2, prerequisites = [[1, 0]]
Output:         true
Explanation:    There are a total of 2 courses to take. To take course 1 you should have finished
                course 0. So it is possible.

- EX 2 -
Input:          numCourses = 2, prerequisites = [[1, 0], [0, 1]]
Output:         false
Explanation:    There are a total of 2 courses to take. To take course 1 you should have finished
                course 0, and to take course 0 you should also have finished course 1. So it is
                impossible.
*/

import java.util.*;

public class CourseSchedule {

    /*
     * Time Complexity: O(V + E) where V is the number of vertices and E is the
     * number of edges.
     * 
     * Space Complexity: O(V + E) because we have an array of ArrayLists (map). For
     * each vertex, we have a list of neighbors (edges).
     */

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Initializing a new array of ArrayLists (map).
        ArrayList[] map = new ArrayList[numCourses];
        // This operation takes O(V) time because we iterate through our vertices.
        for (int i = 0; i < numCourses; i++) {
            // Initialize a new ArrayList for each spot in our array.
            map[i] = new ArrayList<Integer>();
        }

        // Create two boolean arrays that keep track of visited courses.
        boolean[] visited = new boolean[numCourses];
        // Memo to keep track of outputs to reduce number of calculations.
        boolean[] memo = new boolean[numCourses];
        // Iterate through our prerequisites (edges).
        // This takes O(E) time because we go through each edge to add them to map.
        for (int i = 0; i < prerequisites.length; i++) {
            // Grab the first value of the pair. (Current course).
            int currCourse = prerequisites[i][0];
            // Grab the second value of the pair. (Requirement to take current course).
            int requirement = prerequisites[i][1];
            // Add requirement to the adjacency list of the current course.
            map[currCourse].add(requirement);
        }

        // Iterate through all courses.
        // This takes O(V) time.
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(map, visited, memo, i)) {
                return false;
            }
        }

        // This means we have successfully traversed the graph and can complete all
        // courses.
        // Return true.
        return true;
    }

    public static boolean dfs(ArrayList[] map, boolean[] visited, boolean[] memo, int course) {
        // If we have visited already, this means there's a cycle.
        // Return false immediately.
        if (visited[course]) {
            return false;
        }

        // If we have previously calculated output, save work and grab the previous
        // output. Return true.
        if (memo[course]) {
            return true;
        }

        // If we have not calculated or visited, mark as visited.
        visited[course] = true;
        // Grab the current course's adjacency list (neighbors).
        ArrayList<Integer> neighbors = map[course];

        // Iterate through the adjacency list (neighbors) and recursively call dfs.
        for (int i = 0; i < neighbors.size(); i++) {
            // Grab current value of neighbors.
            int neighbor = neighbors.get(i);
            // Recurse.
            if (!dfs(map, visited, memo, neighbor)) {
                return false;
            }
        }

        // After we finish the neighbors, mark the current course as visited.
        visited[course] = false;
        // Save the output as true to memo.
        memo[course] = true;
        // Return true.
        return true;
    }

    public static void main(String[] args) {
        // Sample prerequisites.
        int[][] s1 = new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 } };
        int[][] s2 = new int[][] { { 1, 0 } };
        int[][] s3 = new int[][] { { 0, 1 }, { 1, 0 } };

        // Calculate results.
        boolean r1 = canFinish(5, s1);
        boolean r2 = canFinish(2, s2);
        boolean r3 = canFinish(2, s3);

        // Print results.
        System.out.println("Finish courses in " + Arrays.deepToString(s1) + ": " + r1);
        System.out.println("Finish courses in " + Arrays.deepToString(s2) + ": " + r2);
        System.out.println("Finish courses in " + Arrays.deepToString(s3) + ": " + r3);
    }
}
