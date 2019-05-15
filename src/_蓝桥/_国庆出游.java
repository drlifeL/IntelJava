package _蓝桥;

import java.util.Arrays;
import java.util.Scanner;

public class _国庆出游 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//测试数据的数量
        while (t != 0) {
            int n = sc.nextInt();//城市的数目
            int[][] con = new int[n + 1][n + 1];
            for (int i = 0; i < n - 1; i++) {
                int sx = sc.nextInt();
                int sy = sc.nextInt();
                con[sx][sy] = 1;
                con[sy][sx] = 1;
            }
            int m = sc.nextInt();//游历顺序
            int[] ex = new int[m];
            for (int i = 0; i < m; i++) {
                ex[i] = sc.nextInt();
            }

            System.out.println(Arrays.deepToString(con));
            System.out.println(Arrays.toString(ex));
            t--;
        }
    }
}
