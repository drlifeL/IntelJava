package _洛谷;

/**
 * 原理:
 *  gcd(a,b) = gcd(b,a mod b)。
 *  两个整数的最大公约数等于其中较小的那个数和两数相除余数的最大公约数   用来约分的
 *
 *  设：两个正整数m,，已知M>N
 *  E1.令r = m%n;
 *  E2.若r==0(即N整除M,结束运算，N即为结果)
 *  E3.否则令M=N,N=r,返回步骤E1
 *
 *  查阅词条发现，只要求出了最大公约数，或者最小公倍数，可以直接反向推导出来两者中的任意一数
 *  有公式：两数最大公约数 * 最小公倍数  = 两数之积   (a,b)*[a,b] = ab;
 *
 */
public class _欧几里得算法最大公约数 {
    public static void main(String[] args) {
        System.out.println(gcd(25,5));
        System.out.println(dgcd(25,5));
    }
    static int gcd(int a,int b){
        int r = a%b;
        while(r!=0){
            a = b;
            b = r;
            r = a%b;
        }
        return b;
    }
    //如果使用递归，只需要两步
    static int dgcd(int a,int b){
        //使用整体的思想看递归，这里可以把下面的if条件修改为a%b==0，但是转念一想，a%b的值不就是b再次递归的值，虽然多了一次递归
        //但是不必要的重复运算，对比较循环，感觉上更好理解
        if(b==0){
            return a;
        }
        return dgcd(b,a%b);
    }

}
