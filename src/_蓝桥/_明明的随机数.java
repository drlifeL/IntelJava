package _蓝桥;

import java.util.Scanner;

public class _明明的随机数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[1001];
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            a[t] = 1;
        }
        String s = "";
        int num = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == 1) {
                num++;
                s += i + " ";
            }
        }
        System.out.println(num);
        System.out.println(s.substring(0, s.length()));
    }
}
