package _洛谷.排序;

import java.util.Scanner;

public class p1068分数线划定 {
    public static void main(String[] args) {
        /**
         * 采用两个数组来存储
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[n+1];//存储编号
        int b[] = new int[n+1];//存储分数
        int p = (int)(m*1.5);
        for (int i = 0; i <n ; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        for (int i = 0; i <n ; i++) {
            for (int j = i + 1; j < n; j++) {
                if (b[i] < b[j]) {
                    //同步换位置
                    swap(i, j, a);
                    swap(i, j, b);
                } else if (b[i] == b[j] && a[i] > a[j]) {//如果两个值相等，但是i的编号大于j  交换
                    swap(i, j, a);
                    swap(i, j, b);
                }
            }
        }
        while(b[p-1]==b[p]){//防止最后一名出现重复分数的情况
            p++;
        }
        System.out.println(b[p-1]+" "+p);//输出录取最低分和实际进入面试的人数
        for (int i = 0; i <p ; i++) {
            System.out.println(a[i]+" "+b[i]);
        }

    }
    private static void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
