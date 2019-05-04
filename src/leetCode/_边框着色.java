package leetCode;

import java.util.Arrays;

public class _边框着色 {
    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 2}};
        int[][] grid1 = {{1, 2, 2}, {2, 3, 2}};
        int[][] grid2 = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[][] grid3 = {{2, 2, 1, 2, 1, 1}, {2, 1, 2, 1, 2, 1}, {2, 2, 1, 1, 2, 1}, {2, 1, 2, 1, 2, 1}};
        int[][] grid4 = {{1, 2, 1, 2, 1, 2}, {2, 2, 2, 2, 1, 2}, {1, 2, 2, 2, 1, 2}};//该例没有通过
        colorBorder(grid4, 1, 3, 1);
        System.out.println(Arrays.deepToString(grid4));

    }

    /**
     * 题意理解错误，该题就是染色问题的变体，提供的入门没有在边界上，那么就不对她进行染色，对她周围的色块进行染色
     *
     * @param grid
     * @param r0
     * @param c0
     * @param color
     * @return
     */
    public static int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        int curColor = grid[r0][c0];
        boolean vis[][] = new boolean[50][50];
        dfs(grid, r0, c0, curColor, color, vis);

        return grid;
    }

    public static void dfs(int[][] grid, int i, int j, int curColor, int color, boolean[][] vis) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != curColor || grid[i][j] == color || vis[i][j])
            return;
        if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1)
            grid[i][j] = color;
        vis[i][j] = true;
        dfs(grid, i, j - 1, curColor, color, vis);
        dfs(grid, i, j + 1, curColor, color, vis);
        dfs(grid, i + 1, j, curColor, color, vis);
        dfs(grid, i - 1, j, curColor, color, vis);
    }
    //那么我们是什么时候该往下面走的，第一个我们要确认我们的左边没有相同的的颜色，那么我们就可以往下边走
    //
}
