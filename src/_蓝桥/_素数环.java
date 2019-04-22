package _蓝桥;

import java.util.Arrays;
import java.util.Scanner;

public class _素数环 {

    static boolean[] vis;
    static int ans;
    static int ans1;

    static int suSu[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] g = new int[n];
        vis = new boolean[n];
        g[0] = 1;
        dfs(g, n, 1);
        System.out.println("------------------------");
        dfs2(n, g, 1);

        System.out.println(ans);
        System.out.println(ans1);
    }

    /**
     * @param g
     * @param n
     * @param cur 下一个应该求的地方
     */
    public static void dfs(int[] g, int n, int cur) {

        if (cur == n && isSusu(g[cur - 1] + 1)) {//找到了一种可能
            ans++;
            System.out.println(Arrays.toString(g));
            return;
        }
        for (int i = 2; i <= n; i++) {
            if (check(i, cur, g)) {//两个加起来是一个素数，n的范围是<=16,可以直接枚举
                g[cur] = i;
                dfs(g, n, cur + 1);
                g[cur] = 0;
            }
        }
    }

    private static boolean check(int i, int cur, int[] g) {//这里存在问题的，素数判定的范围不应该是N的范围，而应该N+N的最大值

        for (int j = 0; j < cur; j++) {
            if (g[j] == i) return false;
        }
        int cnt = g[cur - 1] + i;
        return isSusu(cnt);
    }

    public static boolean isSusu(int n) {
        for (int i = 0; i < suSu.length; i++) {
            if (n == suSu[i]) {
                return true;
            }
        }
        return false;
    }

    public static void dfs2(int n, int[] r, int cur) {
        if (cur == n && isP(r[0] + r[n - 1])) {
            ans1++;
            System.out.println(Arrays.toString(r));
            return;
        }
        for (int i = 2; i <= n; i++) {
            if (check1(r, i, cur)) {
                r[cur] = i;
                dfs2(n, r, cur + 1);
                r[cur] = 0;
            }
        }


    }

    public static boolean check1(int[] r, int i, int cur) {
        for (int e : r) {
            if (e == i || !isP(r[cur - 1] + i)) return false;
        }
        return true;
    }

    public static boolean isP(int k) {
        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) return false;
        }
        return true;
    }

}
