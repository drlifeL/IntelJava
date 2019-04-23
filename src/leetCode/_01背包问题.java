package leetCode;

import java.util.Arrays;
import java.util.Scanner;

public class _01背包问题 {
    static int n;
    static int W;
    static int[] w;//物品的重量
    static int[] v;//物品的价值


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();//物品的数量
        W = sc.nextInt();//背包的最大承重
        w = new int[n];
        v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        System.out.println(dp());
    }

    /**
     * 经典动态规划，01背包问题
     */
    private static int dp() {
        int[][] dp = new int[n][W + 1];
        //初始化第一行
        for (int i = 0; i < W + 1; i++) {
            if (w[0] <= i) {//这个东西可以被装进背包
                dp[0][i] = v[0];
            } else {
                dp[0][i] = 0;//这里可以不写，但是为了明显还是写上
            }
        }
        //通过第一行推到下面的N行
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (w[i] <= j) {
                    int v1 = v[i] + dp[i - 1][j - w[i]];//选他的情况下，现在的价值应该是我物品的价值+剩下重量在上一个的价值
                    int v2 = dp[i - 1][j];//不选的情况下
                    dp[i][j] = Math.max(v1, v2);//取他们的最大值
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][W];
    }
}
