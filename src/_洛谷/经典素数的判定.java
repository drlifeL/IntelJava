package _洛谷;

import java.util.Scanner;

/**
 * 目前对素数的判断在计算机中一般是枚举加开方
 * 例如：判断N是否是素数，
 *  从2开始枚举到根号n（用Math库中sqrt函数,为了减少枚举范围），如果在枚举过程中n被整除，这个数就不是素数，
 *  否则就是素数
 */

public class 经典素数的判定 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  =sc.nextInt();
        System.out.println(isPrime(n));
        System.out.println(isPrime2(n));
    }

    /**
     * 也可以不使用Sqrt函数
     * @param n
     * @return
     */
    private static boolean isPrime2(int n) {
        for (int i = 2; i*i <=n ; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用函数
     * @param n
     * @return
     */
    private static boolean isPrime(int n) {
        for (int i = 2; i <=Math.sqrt(n) ; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
