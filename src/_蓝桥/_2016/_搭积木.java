package _蓝桥._2016;

/**
 * 全排列模块
 */
public class _搭积木 {
    static int a[] = {0,1,2,3,4,5,6,7,8,9};

    private static int ans =0;

    public static void main(String[] args) {
        f(0);
        System.out.println(ans);
    }

    /**
     * 全排列
     * @param k
     */
    private static void f(int k) {
        if(k==10){
            if(check()){
                ans++;
            }
        }
        for (int i = k; i <10 ; i++) {
            int t = a[i];
            a[i] = a[k];
            a[k] = t;
            f(k+1);
            t = a[i];
            a[i] = a[k];
            a[k] = t;
        }
    }

    private static boolean check() {
        if(a[0]<a[1] && a[0]<a[2] && a[1]<a[3]&& a[1]<a[4] &&a[2]<a[4] && a[2]<a[5] &&a[3]<a[6] && a[3]<a[7] && a[4]<a[7] && a[4]<a[8] && a[5]<a[8] && a[5]<a[9]){
            return true;
        }
        return false;
    }
}
