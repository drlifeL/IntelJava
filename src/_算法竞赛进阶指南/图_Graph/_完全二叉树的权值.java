package _算法竞赛进阶指南.图_Graph;

import java.util.Scanner;

public class _完全二叉树的权值 {
    static int[] arr = new int[1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr[0] = sc.nextInt();
        int i = 1;
        int curNum = 1;//当前层数需要读入的数量
        for (int c = 1; c < n - 1; i++) {
            int sum = 0;
            int t = 1;
            curNum *= 2;
            while (t <= curNum) {
                sum += sc.nextInt();
                t++;
            }
            arr[i] = sum;
            c += curNum;
        }
        int index = 0;
        int curMax = arr[0];
        for (int j = 1; j < i; j++) {
            if (arr[j] > curMax) {
                index = j;
                curMax = arr[j];
            }
        }
        System.out.println(index + 1);
    }
}
