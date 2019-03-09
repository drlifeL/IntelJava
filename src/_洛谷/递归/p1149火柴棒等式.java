package _洛谷.递归;

import java.util.HashSet;
import java.util.Scanner;

public class p1149火柴棒等式 {
    static int a[] = new int[]{6,2,5,5,4,5,6,3,7,6};//0到9火柴棍的总数
    static int n ;
    static int ans = 0;
    static HashSet set = new HashSet();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt()-4;//减去加号和等号的火柴棍
        //前面这里的上界枚举出现了错误,错误的将范围缩小了，以后记住，首先跑大范围的数值，然后再逐步缩小范围来确实大概取值范围。
        for (int i = 0; i <1111 ; i++) {
            for (int j = 0; j <1111 ; j++) {
                if( check(i,j,i+j)){
                    ans++;
                    System.out.println(i+"+"+j+"="+(i+j));
                }
            }
        }
//        f(0,0);
        System.out.println(ans);
    }
    public static void f(int i,int j){
        if( i>=18 || j>=18 || set.contains(i+""+j+"")){
            return;
        }
        if(check(i,j,i+j)){
            ans++;
            set.add(i+""+j+"");
            System.out.println(i+"+"+j+"="+(i+j));
        }
        f(i,j+1);
        f(i+1,j);
    }
    private static boolean check(int i, int j, int i1) {
        if(i1==0)
            return false;
        if(i1>=10){
            int sum = 0;
            String s = i+"";
            String s1 = j+"";
            String s2 = i1+"";
            for (int k = 0; k <s.length() ; k++) {
                sum+=a[(s.charAt(k)-48)];
            }
            for (int k = 0; k <s1.length() ; k++) {
                sum+=a[(s1.charAt(k)-48)];
            }
            for (int k = 0; k <s2.length() ; k++) {
                sum+=a[(s2.charAt(k)-48)];
            }
            if(sum==n)return true;
        } else if(a[i]+a[j]+a[i1]==n){
            return true;
        }
        return false;
    }

}
