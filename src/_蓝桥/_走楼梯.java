package _蓝桥;

import java.util.Scanner;

/**
 * 有个小孩上楼梯，楼梯有n阶台阶，小孩一次可以上1，2,3个台阶
 * 实现一个方法，计算小孩有多少种上楼的方式，为了防止溢出，结果mod1000000007
 */
public class _走楼梯 {
    final static int mod = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans[] = new long[n + 1];
        ans[1] = 1;
        ans[2] = 2;
        ans[3] = 4;
        //循环方法实现，正着想，正着写
        for (int i = 4; i <= n; i++) {//i代表当前台阶数
            long x = ans[i - 1];
            long y = ans[i - 2];//走两步
            long z = ans[i - 3];//走三遍
            ans[i] = (x + y + z) % mod;
        }
        System.out.println(ans[n]);

        System.out.println(upL(n));
    }

    /**
     * 递归方法实现
     * 正着想，反着写
     *
     * @param n
     * @return
     */
    public static int upL(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) return 4;
        return (upL(n - 1) % mod + upL(n - 2) % mod + upL(n - 3) % mod) % mod;
    }

}
