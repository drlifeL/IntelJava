package leetCode;

/**
 * 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
 * <p>
 * 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 * <p>
 * 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
 * <p>
 * 输入：[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：
 * 有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * <p>
 * 该题是一个变体题
 */
public class FLyDustNum {

    public static void main(String[] args) {
        int[][] A = {{0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};

        int[][]t = {{0,0,0,1,1,1,0,1,0,0},
                    {1,1,0,0,0,1,0,1,1,1},
                    {0,0,0,1,1,1,0,1,0,0},
                    {0,1,1,0,0,0,1,0,1,0},
                    {0,1,1,1,1,1,0,0,1,0},
                    {0,0,1,0,1,1,1,1,0,1},
                    {0,1,1,0,0,0,1,1,1,1},
                    {0,0,1,0,0,1,0,1,0,1},
                    {1,0,1,0,1,1,0,0,0,0},
                    {0,0,0,0,1,1,0,0,0,1}};

        System.out.println(arriveNum(t));
    }

    /**
     * 求被四周都是0包围的，且不在边缘网格上的1的数量
     * 目前的想法：
     * 1.先遍历一遍该图，把该图中与边界有关系的节点全部渲染成0，
     * 2.再次遍历该图，统计1的数量就可以完成
     *
     * @return
     */
    public static int arriveNum(int[][] g) {
        int rows = g.length;
        if (rows == 2 || rows == 1) return 0;
        init(g);
        print(g);
        int num = 0;
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 0; j < g[i].length; j++) {
                if (g[i][j] == 1) {
                    num++;
                }
            }
        }
        return num;
    }

    private static void print(int[][] g) {
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                System.out.print(g[i][j]+" ");
            }
            System.out.println();
        }

    }

    private static void init(int[][] g) {
        for (int i = 0; i < g[0].length; i++) {//遍历头
            if (g[0][i] == 1) {
                dfs(0, i, g);
            }
        }
        for (int i = 1; i < g.length - 1; i++) {
            int cols = g[i].length - 1;
            if (g[i][0] == 1) {
                dfs(i, 0, g);
            }
            if (g[i][cols] == 1) {
                dfs(i, cols, g);
            }
        }
        for (int i = 0; i < g[0].length; i++) {
            if (g[g.length - 1][i] == 1) {
                dfs(g.length - 1, i, g);
            }
        }
    }
    private static void dfs(int i, int j, int[][] g) {
        if (i < 0 || i >= g.length || j < 0 || j >= g[i].length || g[i][j] == 0) return;
        g[i][j] = 0;
        dfs(i, j + 1, g);
        dfs(i, j - 1, g);
        dfs(i - 1, j, g);
        dfs(i + 1, j, g);
    }
}
