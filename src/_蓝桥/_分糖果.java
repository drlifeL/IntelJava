package _蓝桥;

import java.util.Scanner;

public class _分糖果 {
    /**
     * 测试用例存在一个错误，没找到...
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }
        int ans = 0;//老师需要发的糖果

        while (true) {
            int t = c[c.length - 1];//记录最后一个小朋友的糖果数
            for (int i = c.length - 1; i > 0; i--) {
                c[i] = c[i - 1] / 2 + (c[i] % 2 == 0 ? c[i] / 2 : c[i] / 2 + 1);
            }
            c[0] = t / 2 + (c[0] % 2 == 0 ? c[0] / 2 : c[0] / 2 + 1);
            boolean flag = true;
            for (int i = 0; i < c.length; i++) {
                if (c[i] % 2 != 0) {
                    c[i]++;
                    ans++;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        System.out.println(ans);

    }
}
