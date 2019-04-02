package _洛谷.贪心;

import java.util.Arrays;
import java.util.Scanner;

public class p1090合并果子 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//果子的种类
        int a[] = new int[n];//存储数据
        long ans = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        //对a进行排序
        Arrays.sort(a);
        for (int i = 1; i < n; i++) {//遍历
            a[i] = a[i] + a[i - 1];
            ans += a[i];
        }
        System.out.println(ans);
    }
}
