package _算法竞赛入门经典;

import java.util.Scanner;

public class _因子和阶乘 {
    static int prime[] = new int[25];

    public static void main(String[] args) {
        init();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int maxp = 0;
        int p[] = new int[100];
        for (int i = 1; i <= n; i++) {
            //必须把i复制到变量M中，而不要在做除法时直接修改他
            int m = i;
            for (int j = 0; j < prime.length; j++) {
                while (m % prime[j] == 0) {//反复除以Prime[j]，并累加p[j]
                    m /= prime[j];
                    p[j]++;
                    if (j < maxp) maxp = j;//更新最大素因子下标

                }
            }
            for (int j = 0; j <= maxp; j++) {
                System.out.println(p[j]);
            }
        }

    }

    /**
     * 构造1-100之内的素数数组
     */
    private static void init() {
        int k = 0;
        for (int i = 2; i < 100; i++) {
            if (is_prime(i)) {
                prime[k++] = i;
            }
        }
    }

    /**
     * 判断是不是素数
     *
     * @param i
     * @return
     */
    private static boolean is_prime(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
