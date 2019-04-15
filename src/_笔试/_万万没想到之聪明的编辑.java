package _笔试;

import java.util.Scanner;

/**
 * 双指针算法
 *  在不删除原有数组元素的情况下，通过覆盖和两个指针的交替来完成对字符串的修改
 */
public class _万万没想到之聪明的编辑 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {

            char[] s = sc.nextLine().toCharArray();
            int k = 0;
            for (int j = 0;j < s.length; j++) {
                s[k++] = s[j];
                if (k >= 3 && s[k - 3] == s[k - 2] && s[k - 2] == s[k - 1]) k--;
                if (k >= 4 && s[k - 4] == s[k - 3] && s[k - 2] == s[k - 1]) k--;
            }
            for (int j = 0; j < k; j++) {
                System.out.print(s[j]);
            }
            System.out.println();
        }

    }
}
