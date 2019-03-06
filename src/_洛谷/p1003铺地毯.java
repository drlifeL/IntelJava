package _洛谷;

import java.util.Scanner;
/**
 *   别人的Ac做法，直接从后往前判断边界，而不是直接开数组，开数组会导致内存溢出，并且开数组，数组的大小无法被确定下来。
 * import java.util.Scanner;
 * public class _蓝桥.Main {
 *     public static void main(String[] args) {
 *         Scanner scanner = new Scanner(System.in);
 *         int n = scanner.nextInt();
 *         int index = -1;
 *         int[][] array = new int[n+1][4];
 *         for (int i = 1; i <= n; i++) {
 *             array[i][0] = scanner.nextInt();
 *             array[i][1] = scanner.nextInt();
 *             array[i][2] = scanner.nextInt();
 *             array[i][3] = scanner.nextInt();
 *         }
 *
 *         int x = scanner.nextInt();
 *         int y = scanner.nextInt();
 *
 *         for (int i = n; i > 0; i--) {
 *             if( x >= array[i][0] && y >= array[i][1]
 *                     &&x <= array[i][2]+array[i][0] && y <= array[i][3]+array[i][1] ) {
 *                 index = i;
 *                 break;
 *             }
 *
 *         }
 *
 *         System.out.println(index);
 *     }
 * }
 *
 */
public class p1003铺地毯 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]arr = new int [10000][10000];
        int temp = 1;//地毯编号
        for (int i = 0; i <n ; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int g = sc.nextInt();
            int k = sc.nextInt();
            for (int j = k; j>=b ; j--) {
                for (int l = a; l <=g ; l++) {
                    arr[j][l] = temp;
                }
            }
            temp++;
        }
        int c = sc.nextInt();
        int d = sc.nextInt();
        System.out.println(arr[c][d]==0?-1:arr[c][d]);
    }
}


