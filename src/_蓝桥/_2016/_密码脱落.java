package _蓝桥._2016;

import java.util.Scanner;

public class _密码脱落 {
    static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        int len = s.length();
        int l = lcs(s, new StringBuffer(s).reverse().toString(), len);
        System.out.println(len - l);
    }

    /**
     * 动态规划求最长公共子串
     * @param s1
     * @param s2
     * @param len
     * @return
     */
    private static int lcs(String s1, String s2, int len) {
        int dp[][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) == s2.charAt(0)) dp[0][i] = 1;
            else dp[0][i] = (i == 0 ? 0 : dp[0][i - 1]);
        }

        for (int j = 0; j < len; j++) {
            if (s2.charAt(j) == s1.charAt(0)) dp[j][0] = 1;
            else dp[j][0] = (j == 0 ? 0 : dp[j - 1][0]);
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if (s2.charAt(i) == s1.charAt(j)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[len - 1][len - 1];
    }
}
