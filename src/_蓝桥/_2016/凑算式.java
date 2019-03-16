package _蓝桥._2016;

/**
 * 全排列交换法，适用于应对没有相同的元素的全排列
 *
 */
public class 凑算式 {
    static int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static int cout = 0;

    public static void main(String[] args) {
        f(0);
        System.out.println(cout);
    }

    /**
     * 递归回溯生成全排列，适用于无重复元素的情况
     * 考虑第K位，前面已经排定
     *
     * @param k
     */
    private static void f(int k) {
        if (k == 9) {//一种排列已经产生
            if (check()) {
                cout++;
            }
        }
        //从k往后的每个数字都可以放在k位
        for (int i = k; i < 9; i++) {
            int t = a[i];
            a[i] = a[k];
            a[k] = t;
            f(k + 1);//递归
            t = a[i];
            a[i] = a[k];
            a[k] = t;//回溯
        }

    }

    private static boolean check() {
        int x = a[3] * 100 + a[4] * 10 + a[5];
        int y = a[6] * 100 + a[7] * 10 + a[8];
        if ((a[1] * y + a[2] * x) % (y * a[2]) == 0 &&a[0]+ (a[1] * y + a[2] * x) / (y * a[2]) == 10)
            return true;
        return false;
    }
}
