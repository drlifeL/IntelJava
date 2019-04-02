package _蓝桥;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 这个程序没有完成，只有当n和m相等的时候，程序才可以正确的执行，否则就会出现错误
 */
public class _顺时针打印二维数组 {
    static int a[][] = {{1,3,4,5},
                         {2,5,9,7},
                         {3,9,7,6},
                        {1,3,9,6}};
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n =sc.nextInt();
//        int m =sc.nextInt();
//        init(n,m);
//        printf(4,4);
        System.out.println(Arrays.deepToString(a));

    }


    private static void printf(int n, int m) {
        int i ,j;
        for (i = 0; i < n; i++) {
            for (j = i; j < m; j++) {
                System.out.print(a[i][j]+" ");
            }
            for (int k = i+1; k<n ; k++) {
                System.out.print(a[k][m-1]+" ");
            }
            for (int c = m-2; c >=i ; c--) {
                System.out.print(a[m-1][c]+" ");
            }
            for (int d = n-2; d >i ; d--) {
                System.out.print(a[d][i]+" ");
            }
            n-=1;
            m-=1;

        }
    }

    public static void init(int n, int m){
        a = new int[n][m];
        int k  = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
             a[i][j] = k++;
            }
        }
    }

}
