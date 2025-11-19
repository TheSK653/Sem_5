import java.util.*;

public class Graph_Valid_Tree {

    class Solution {

        public boolean validTree(int n, int[][] edges) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(i, new ArrayList<>());
            }
            for (int[] edge : edges) {
                int v1 = edge[0];
                int v2 = edge[1];
                map.get(v1).add(v2);
                map.get(v2).add(v1);
            }
            return BFT(map);
        }

        public boolean BFT(HashMap<Integer, List<Integer>> map) {
            Queue<Integer> q = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();
            int c = 0;
            for (int src : map.keySet()) {
                if (visited.contains(src)) {
                    continue;
                }
                c++;
                q.add(src);
                while (!q.isEmpty()) {
                    // 1. remove
                    int r = q.poll();
                    // 2. Ignore if Already visited
                    if (visited.contains(r)) {
                        return false;// cycle mil gya hai
                    }
                    // 3. Makred visited
                    visited.add(r);
                    // 4. self work
                    // 5. Add unvisited nbrs
                    for (int nbrs : map.get(r)) {
                        if (!visited.contains(nbrs)) {
                            q.add(nbrs);
                        }
                    }
                }
            }
            return c == 1;
        }
    }

    // Simple runner to make this file executable and demonstrate validTree
    public static void main(String[] args) {
        Graph_Valid_Tree outer = new Graph_Valid_Tree();
        Solution sol = outer.new Solution();

        // Example 1: valid tree
        int n1 = 5;
        int[][] edges1 = {{0,1},{0,2},{0,3},{1,4}};
        System.out.println("Example 1 (should be true): " + sol.validTree(n1, edges1));

        // Example 2: contains a cycle -> not a valid tree
        int n2 = 5;
        int[][] edges2 = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        System.out.println("Example 2 (should be false): " + sol.validTree(n2, edges2));
    }
}
