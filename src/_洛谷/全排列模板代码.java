package _洛谷;

import java.util.Arrays;

public class 全排列模板代码 {
    static int ans = 0;
    public static void main(String[] args) {
        int []a = new int[]{1,2,3};
        f(0,a.length,a);
        System.out.println(ans);
    }

    private static void f(int i, int j, int[] a) {
        if(i==j){
            ans++;
//            System.out.println(Arrays.toString(a));
            return;
        }
        for (int k = i; k <j ; k++) {
            swap(k,i,a);//将i固定,让每个k和i进行交换。
            f(i+1,j,a);
            swap(k,i,a);//将i固定,让每个k和i进行交换。

        }
    }

    private static void swap(int i, int k, int[] a) {
        if(k==i){//防止多余的交换
            return;
        }
        int temp = a[i];
        a[i] = a[k];
        a[k] = temp;
    }
}
