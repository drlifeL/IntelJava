package _算法竞赛进阶指南.图_Graph;

import java.util.Scanner;

public class _畅通工程续 {
    static int[][] Len;//权值
    static int[][] g;//矩阵存储连接的关系
    static int end;
    static int n;
    static int ans = Integer.MAX_VALUE;//最少的权值
    static boolean vis[];//节点的访问状态

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int m = sc.nextInt();

        g = new int[n][n];

        Len = new int[n][n];

        vis = new boolean[n];
        for (int i = 0; i < m; i++) {
            int cityA = sc.nextInt();
            int cityB = sc.nextInt();
            int x = sc.nextInt();
            //双向联系
            g[cityA][cityB] = 1;
            g[cityB][cityA] = 1;
            Len[cityA][cityB] = x;
            Len[cityB][cityA] = x;
        }
        int B = sc.nextInt();
        int E = sc.nextInt();
        end = E;
        dfs(B, 0);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

    }

    /**
     *
     * @param i 当前节点
     * @param len 起点到当前节点的权值
     */
    private static void dfs(int i,  int len) {
        if (i == end) {
            ans = Math.min(len, ans);
            return;
        }
        /**
         *遍历与当前点有联系的点
         */
        for (int k = 0; k < n; k++) {
            if (k == i) continue;//如果是本身，直接跳过
            if (g[i][k] == 1 && !vis[k]) {//如果这个点与当前点存在边，且没有被访问过
                vis[i] = true;//把我们当前点设置为已经访问
                dfs(k, len + Len[i][k]);//递归的访问下一个点
                vis[i] = false;//回溯状态
                len -= Len[i][k];//回溯状态
            }
        }
    }
}
