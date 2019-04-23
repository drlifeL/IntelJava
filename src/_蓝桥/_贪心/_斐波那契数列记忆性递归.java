package _蓝桥._贪心;

import java.util.Arrays;
import java.util.Scanner;

public class _斐波那契数列记忆性递归 {
    static long v[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        v = new long[n + 1];
        Arrays.fill(v, -1);
        v[1] =1;
        v[2] =1;
        v[0] = 0;
        System.out.println(dfs(n));
        System.out.println(feibolaqie(n));
    }

    /**
     * 使用记忆性递归秒出答案
     * @param n
     * @return
     */
    private static long dfs(int n) {
        if (v[n] >= 0) {
            return v[n];
        }
        long ans = dfs(n - 1) + dfs(n - 2);
        v[n] = ans;
        return ans;
    }

    public static int feibolaqie(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        return feibolaqie(n - 1) + feibolaqie(n - 2);
    }
}
