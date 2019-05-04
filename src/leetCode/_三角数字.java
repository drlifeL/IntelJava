package leetCode;

import java.util.Scanner;

public class _三角数字 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(f(n));
        System.out.println(loopF(n));
    }

    /**
     * 递归方式求解
     * @param n
     * @return
     */
    private static int f(int n) {
        if (n == 1) {
            return 1;
        }
        return f(n - 1) + n;
    }


    /**
     * 循环方式求解
     * @param n
     * @return
     */
    public static int loopF(int n) {
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            ans = ans + i;
        }
        return ans;
    }


}
