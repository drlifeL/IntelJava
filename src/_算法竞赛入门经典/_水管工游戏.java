package _算法竞赛入门经典;

import java.util.Scanner;

/**
 * 该题的算法的思路：
 *  1.问题的转换，由题意可知，题中管道只有直管和弯管，其分别对应四种状态，当前管道是否可以用，取决于当前管道是直管还是弯管，而下一个状态是取决于上一状态中管道的朝向
 */
public class _水管工游戏 {
    static char[][] g;
    static int n, m;
    static boolean vis[][];
    static int[] q = {0, 0, 1, -1};
    static int[] w = {1, -1, 0, 0};
    static boolean flag = false;
    static String ans="";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        g = new char[n][m];
        vis = new boolean[n][m];

        sc.nextLine();
        for (int i = 0; i < n; i++) {
            g[i] = sc.nextLine().toCharArray();
        }

        dfs(0, 0, 1);
        if(flag){
            System.out.println(ans);
        }else{
            System.out.println("No");
        }
    }

    /**
     * x,y表示当前坐标，fornt 表示水管的方向朝向
     * 这里我们用1表示左，2表示右，3表示上，4表示下
     *
     * @param x
     * @param y
     * @param front
     */
    public static void dfs(int x, int y, int front) {
        if (x == n - 1 && y == m) { //因为最后要接上最后一个状态，所以y必须等于m
            flag = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(vis[i][j] && i==n-1 && j==m-1){
                        ans+="("+i+","+j+")";
                    }else if(vis[i][j]){
                       ans+="("+i+","+j+")"+",";
                    }
                }
            }
            return;
        }
        if (x < 0 || x >= n || y < 0 || y >= m || vis[x][y] || g[x][y] == '0') return;//判断越界
        vis[x][y] = true;//设置为已经访问
        if (g[x][y] >= '5' && g[x][y] <= '6') {//如果当前管道为直管
/*            for (int i = 0; i < 4; i++) {
                if (front == i + 1) {
                    dfs(q[i], w[i], i + 1);
                }
             }*/
            if (front == 1) {
                dfs(x, y + 1, 1);
            } else if (front == 2) {
                dfs(x, y - 1, 2);
            } else if (front == 3) {
                dfs(x + 1, y, 3);
            } else {
                dfs(x - 1, y, 4);
            }

        }
        if (g[x][y] >= '1' && g[x][y] <= '4') {//如果当前状态为弯管
            if (front == 1) {
                dfs(x - 1, y, 4);
                dfs(x + 1, y, 3);
            } else if (front == 2) {
                dfs(x - 1, y, 4);
                dfs(x + 1, y, 3);
            } else if (front == 3) {
                dfs(x, y + 1, 1);
                dfs(x, y - 1, 2);
            } else {
                dfs(x, y + 1, 1);
                dfs(x, y - 1, 2);
            }
        }
        vis[x][y] = false;
        return;
    }
}
