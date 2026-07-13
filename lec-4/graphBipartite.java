import java.util.*;

public class graphBipartite {

    static class Solution {

        public int isBipartite(int[][] graph) {

            int n = graph.length;
            int[] color = new int[n];

            for (int i = 0; i < n; i++) {

                if (color[i] != 0)
                    continue;

                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = 1;

                while (!queue.isEmpty()) {

                    int node = queue.poll();

                    for (int neighbour : graph[node]) {

                        if (color[neighbour] == 0) {

                            color[neighbour] = -color[node];
                            queue.offer(neighbour);

                        } else if (color[neighbour] == color[node]) {

                            return 0;
                        }
                    }
                }
            }

            return 1;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] graph = new int[n][];

        for (int i = 0; i < n; i++) {

            int k = scanner.nextInt();
            graph[i] = new int[k];

            for (int j = 0; j < k; j++) {

                graph[i][j] = scanner.nextInt();
            }
        }

        Solution sol = new Solution();

        int result = sol.isBipartite(graph);

        System.out.println(result);
    }
}