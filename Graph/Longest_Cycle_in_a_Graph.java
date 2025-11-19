import java.util.HashMap;
import java.util.Map;
public class Longest_Cycle_in_a_Graph {
    public static  int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visited = new boolean[n];
        int longestCycleLength = -1;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int current = i;
                Map<Integer, Integer> nodeToStep = new HashMap<>();
                int step = 0;

                while (current != -1) {
                    if (visited[current]) {
                        break;
                    }
                    if (nodeToStep.containsKey(current)) {
                        int cycleLength = step - nodeToStep.get(current);
                        longestCycleLength = Math.max(longestCycleLength, cycleLength);
                        break;
                    }

                    nodeToStep.put(current, step);
                    visited[current] = true;
                    current = edges[current];
                    step++;
                }
            }
        }

        return longestCycleLength;
    }
    public static void main(String[] args) {
        int[] edges = {3, 3, 4, 2, 3};
        int result = longestCycle(edges);
        System.out.println("Longest Cycle Length: " + result); // Output: 3
    }
}
