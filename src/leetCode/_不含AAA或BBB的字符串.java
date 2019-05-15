package leetCode;

import java.util.Arrays;

public class _不含AAA或BBB的字符串 {
    public static void main(String[] args) {

        dg(0, new String[5], 4, 1);
        System.out.println(strWithout3a3b(100,100));
    }

    /**
     * 官方讲解的贪心算法
     * 思路上和自己想的递归差不多，但是怎么样把递归变成贪心，自己没想到，亏啊！！！
     * @param A
     * @param B
     * @return
     */
    public static String strWithout3a3b(int A, int B) {
        StringBuilder ans = new StringBuilder();

        while (A > 0 || B > 0) {
            boolean writeA = false;
            int L = ans.length();
            if (L >= 2 && ans.charAt(L-1) == ans.charAt(L-2)) {
                if (ans.charAt(L-1) == 'b')
                    writeA = true;
            } else {
                if (A >= B)
                    writeA = true;
            }

            if (writeA) {
                A--;
                ans.append('a');
            } else {
                B--;
                ans.append('b');
            }
        }

        return ans.toString();
    }

    /**
     * 递归做法，超时
     * @param index
     * @param arr
     * @param A
     * @param B
     */
    public static void dg(int index, String[] arr, int A, int B) {

        if (index == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        if (index > 1 && !("a".equals(arr[index - 1]) && "a".equals(arr[index - 2])) && A > 0) {
            arr[index] = "a";
            dg(index + 1, arr, A - 1, B);
        }
        if (index > 1 && !("b".equals(arr[index - 1]) && "b".equals(arr[index - 2])) && B > 0) {
            arr[index] = "b";
            dg(index + 1, arr, A, B - 1);
        }
        if (index <= 1) {
            if (A > 0) {
                arr[index] = "a";
                dg(index + 1, arr, A - 1, B);
            }
            if (B > 0) {
                arr[index] = "b";
                dg(index + 1, arr, A, B - 1);
            }
        }
    }
}
