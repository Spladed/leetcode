package _1971_find_if_path_exists_in_graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FindIfPathExistsInGraph {

    private static boolean validPath(int n, int[][] edges, int source, int destination) {
        return bfs(n, edges, source, destination);
    }

    private static boolean bfs(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adjacencyList = new List[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            adjacencyList[x].add(y);
            adjacencyList[y].add(x);
        }

        boolean[] visited = new boolean[n];

        Queue<Integer> waitForVisit = new ArrayDeque<>();

        visited[source] = true;
        waitForVisit.offer(source);

        while (!waitForVisit.isEmpty()) {
            int vertex = waitForVisit.poll();
            if (vertex == destination) {
                break;
            }
            for (int next : adjacencyList[vertex]) {
                if (!visited[next]) {
                    waitForVisit.offer(next);
                    visited[next] = true;
                }
            }
        }

        return visited[destination];
    }

    private static boolean dfs(int n, int[][] edges, int source, int destination) {
        return false;
    }

    private static boolean unionFind(int n, int[][] edges, int source, int destination) {
        return false;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = new int[][]{new int[]{0, 1}, new int[]{1, 2}, new int[]{2, 0}};
        int source = 0;
        int destination = 2;
        boolean result = validPath(n, edges, source, destination);
        System.out.println(result);
    }

}
