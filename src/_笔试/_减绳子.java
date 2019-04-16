package _笔试;

import java.util.Scanner;

/**
 * 典型的二分枚举题
 */
public class _减绳子 {
    static int n;
    static int m;
    static int[] len;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        len = new int[n];
        for (int i = 0; i < n; i++) {
            len[i] = sc.nextInt();
        }
        double l = 0, r = 1e9;
        System.out.println(r - 1);
        while (r - l > 1e-4) {
            double mid = (l + r) / 2;
            if (check(mid)) l = mid;
            else r = mid;
        }
        System.out.println(String.format("%.2f",r));
    }

    private static boolean check(double mid) {
        int s = 0;//记录当前绳子的条数
        for (int i = 0; i < n; i++) {
            s += len[i] / mid;
            if (s >= m) return true;
        }
        return false;
    }
}
