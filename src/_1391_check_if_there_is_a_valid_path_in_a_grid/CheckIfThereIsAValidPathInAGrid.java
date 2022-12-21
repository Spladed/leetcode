package _1391_check_if_there_is_a_valid_path_in_a_grid;

public class CheckIfThereIsAValidPathInAGrid {

    private static int m = 0;
    private static int n = 0;
    private static int[][] data;

    private static boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        data = grid;
        return unionFind();
    }

    private static boolean unionFind() {
        int[] parent = new int[m * n];
        int[] rank = new int[m * n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int current = data[i][j];
                processHorizontal(parent, rank, i, j, current);
                processPortrait(parent, rank, i, j, current);

            }
        }
        int source = calculateCurrentPosition(0, 0);
        int destination = calculateCurrentPosition(m - 1, n - 1);
        return findRoot(parent, source) == findRoot(parent, destination);
    }

    private static void processHorizontal(int[] parent, int[] rank, int i, int j, int current) {
        if (current == 1 || current == 4 || current == 6) {
            if (j + 1 < n) {
                int next = data[i][j + 1];
                if (next == 1 || next == 3 || next == 5) {
                    union(parent, rank, calculateCurrentPosition(i, j), calculateCurrentPosition(i, j + 1));
                }
            }
        }
    }

    private static void processPortrait(int[] parent, int[] rank, int i, int j, int current) {
        if (current == 2 || current == 3 || current == 4) {
            if (i + 1 < m) {
                int next = data[i + 1][j];
                if (next == 2 || next == 5 || next == 6) {
                    union(parent, rank, calculateCurrentPosition(i, j), calculateCurrentPosition(i + 1, j));
                }
            }
        }
    }

    private static void union(int[] parent, int[] rank, int x, int y) {
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

    private static int calculateCurrentPosition(int currentRow, int currentColumn) {
        return currentRow * n + currentColumn;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{new int[]{2, 4, 3}, new int[]{6, 5, 2}};
        boolean result = hasValidPath(grid);
        System.out.println(result);
    }

}
