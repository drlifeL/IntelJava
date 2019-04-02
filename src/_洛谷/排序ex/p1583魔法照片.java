package _洛谷.排序ex;

import java.util.Scanner;

/**
 * 题都没有读懂....
 */
public class p1583魔法照片 {
    static int e[] = new int[10];//额外权值
    static int w [];//友好程度
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        w = new int[n];
        for (int i = 0; i <10 ; i++) {
            e[i] = sc.nextInt();
        }
        for (int i = 0; i <n ; i++) {
            w[i] = sc.nextInt();
        }

    }
}
