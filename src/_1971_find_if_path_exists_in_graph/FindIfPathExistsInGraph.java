package _1971_find_if_path_exists_in_graph;

import java.util.*;

public class FindIfPathExistsInGraph {

    private static boolean validPath(int n, int[][] edges, int source, int destination) {
        return unionFind(n, edges, source, destination);
    }

    private static boolean bfs(int n, int[][] edges, int source, int destination) {
        List<Integer>[] adjacencyList = GenerateAdjacencyList(n, edges);

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
        List<Integer>[] adj = GenerateAdjacencyList(n, edges);
        boolean[] visited = new boolean[n];
        return dfs(adj, visited, source, destination);
    }

    private static boolean dfs(List<Integer>[] adj, boolean[] visited, int source, int destination) {
        if (source == destination) {
            return true;
        }
        visited[source] = true;
        for (Integer next : adj[source]) {
            if (!visited[next] && dfs(adj, visited, next, destination)) {
                return true;
            }
        }
        return false;
    }

    private static List<Integer>[] GenerateAdjacencyList(int n, int[][] edges) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return adj;
    }

    private static boolean unionFind(int n, int[][] edges, int source, int destination) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            union(edge, parent, rank);
        }

        return isConnect(parent, source, destination);
    }

    private static void union(int[] edge, int[] parent, int[] rank) {
        int x = edge[0];
        int y = edge[1];
        int rootX = findRoot(parent, x);
        int rootY = findRoot(parent, y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    private static int findRoot(int[] parent, int val) {
        if (parent[val] != val) {
            parent[val] = findRoot(parent, parent[val]);
        }
        return parent[val];
    }

    private static boolean isConnect(int[] parent, int source, int destination) {
        return findRoot(parent, source) == findRoot(parent, destination);
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
