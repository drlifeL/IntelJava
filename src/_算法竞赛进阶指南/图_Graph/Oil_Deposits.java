package _算法竞赛进阶指南.图_Graph;

import java.util.Scanner;

/**
 * 油的存储量
 * 首次输入一个 m n 分别代表 接下里含有m行n 的矩阵
 *
 * @ 代表油  *代表无油
 * 一个@符号代表一个油田 多个@ 联通起来的也只代表一个油田
 * 输入以m和n 为0结束
 */
public class Oil_Deposits {
    static char g[][];
    static int M;
    static int N;
    static int ans[] = new int[100];
    static int k = 0;
    static int x[] = {-1, 1, 0, 0, -1, -1, 1, 1,};
    static int y[] = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            M = sc.nextInt();
            N = sc.nextInt();
            if (M == 0 || N == 0) {
                break;
            }
            sc.nextLine();
            g = new char[M][N];
            for (int i = 0; i < M; i++) {
                g[i] = sc.nextLine().toCharArray();
            }
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (g[i][j] == '@') {
                        dfs(i, j);
                        ans[k]++;
                    }
                }
            }
            k++;
        }
        for (int i = 0; i < k; i++) {
            System.out.println(ans[i]);
        }
    }

    /**
     * 拿到图后，对八个方向进行遍历操作
     * 属于同一块，直接将其置为 *
     */
    private static void dfs(int i, int j) {

        if (i < 0 || i >= M || j < 0 || j >= N || g[i][j] == '*') {
            return;
        }
        g[i][j] = '*';

        /**
         * 这里也可以进行修改成为两个存储变量，然后用一层循环就可以解决
         * 这样代码的可阅读性可以得到提升
         */

        for (int l = 0; l < 8; l++) {
            dfs(i+x[l],j+y[l]);
        }
        /*        dfs(i - 1, j);//往上走

        dfs(i + 1, j);//往下走

        dfs(i, j - 1);//往左走

        dfs(i, j + 1);//往右走

        dfs(i - 1, j - 1);//左上

        dfs(i - 1, j + 1);//右上

        dfs(i + 1, j - 1);//左上

        dfs(i + 1, j + 1);//右下*/


    }
}
