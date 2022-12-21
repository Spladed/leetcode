package _1391_check_if_there_is_a_valid_path_in_a_grid;

import java.util.*;

public class CheckIfThereIsAValidPathInAGrid {

    private static int m = 0;
    private static int n = 0;
    private static int[][] data;

    private static boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        data = grid;
        return bfs();
    }

    private static boolean bfs() {
        int[] source = {0, 0};
        int[] destination = {m - 1, n - 1};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> waitForVisit = new ArrayDeque<>();
        visited[source[0]][source[1]] = true;
        waitForVisit.offer(new int[]{0, 0});
        while (!waitForVisit.isEmpty()) {
            int[] coordinate = waitForVisit.poll();
            if (Arrays.equals(coordinate, destination)) {
                break;
            }
            int current = data[coordinate[0]][coordinate[1]];
            for (int[] next : whereToGoNext(current, coordinate[0], coordinate[1])) {
                if (!visited[next[0]][next[1]]) {
                    waitForVisit.offer(next);
                    visited[next[0]][next[1]] = true;
                }
            }
        }
        return visited[destination[0]][destination[1]];
    }

    private static List<int[]> whereToGoNext(int current, int x, int y) {
        ArrayList<int[]> list = new ArrayList<>();
        switch (current) {
            case 1:
                goLeft(x, y, list);
                goRight(x, y, list);
                break;
            case 2:
                goTop(x, y, list);
                goBottom(x, y, list);
                break;
            case 3:
                goLeft(x, y, list);
                goBottom(x, y, list);
                break;
            case 4:
                goBottom(x, y, list);
                goRight(x, y, list);
                break;
            case 5:
                goLeft(x, y, list);
                goTop(x, y, list);
                break;
            case 6:
                goTop(x, y, list);
                goRight(x, y, list);
                break;
        }
        return list;
    }

    private static void goBottom(int x, int y, ArrayList<int[]> list) {
        if (x + 1 < m) {
            int next = data[x + 1][y];
            if (next == 2 || next == 5 || next == 6) {
                list.add(new int[]{x + 1, y});
            }
        }
    }

    private static void goTop(int x, int y, ArrayList<int[]> list) {
        if (x - 1 >= 0) {
            int next = data[x - 1][y];
            if (next == 2 || next == 3 || next == 4) {
                list.add(new int[]{x - 1, y});
            }
        }
    }

    private static void goRight(int x, int y, ArrayList<int[]> list) {
        if (y + 1 < n) {
            int next = data[x][y + 1];
            if (next == 1 || next == 3 || next == 5) {
                list.add(new int[]{x, y + 1});
            }
        }
    }

    private static void goLeft(int x, int y, ArrayList<int[]> list) {
        if (y - 1 >= 0) {
            int next = data[x][y - 1];
            if (next == 1 || next == 4 || next == 6) {
                list.add(new int[]{x, y - 1});
            }
        }
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
        int[][] grid = new int[][]{new int[]{2}, new int[]{2}, new int[]{2}, new int[]{2}, new int[]{2}, new int[]{2}, new int[]{6}};
        boolean result = hasValidPath(grid);
        System.out.println(result);
    }

}
