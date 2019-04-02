package _洛谷.递归;

import java.util.Scanner;



public class p1036选数实现 {
    private static int K;
    private static int[] a;
    private static boolean[] b;
    private static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        K  = sc.nextInt();
        a = new int[n];
        b = new boolean[n];
        for (int i = 0; i <n ; i++) {
            a[i] = sc.nextInt();
        }
        dfs(1,0,0);
        System.out.println(ans);
    }

    public static void dfs(int step,int sum,int i){

        if(step==K && isSusu(sum)){
            ans++;
            System.out.println(sum);
        }
        for (int j = i; j <a.length ; j++) {
            if(b[j]){
                continue;
            }
            b[j] = true;
            dfs(step+1,sum+a[j],j+1);
            b[j] = false;
        }



    }

    /**
     *  一进入这个函数就有一步！
     *  代码存在错误！error
     * @param
     * @param
     * @param sum

    public static void dfs(int i ,int j,int sum){
        if(j==K && isSusu(sum)){
            ans++;
        }
        if(i>=a.length || b[i] || j>K){
            return;
        }
        b[i] = true;
        dfs(i+1,j+1,sum+=a[i]);
        dfs(i+1,j,sum-=a[i]);
        b[i] = false;
    }
     */

    private static boolean isSusu(int sum) {
        for (int i = 2; i <=Math.sqrt(sum) ; i++) {
            if(sum%i==0){
                return false;
            }
        }
        return true;
    }
}

