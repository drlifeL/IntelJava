package _蓝桥._贪心;

import java.util.Scanner;

/**
 * 有1,5,10,50,100,500的硬币，需要来支付A元
 */
public class _硬币支付问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int coins[] = new int[6];
        int price[] = {1, 5, 10, 50, 100, 500};
        for (int i = 0; i < 6; i++) {
            coins[i] = sc.nextInt();
        }
        int A = sc.nextInt();
        int ans = 0;
        for (int i = 5; i >= 0; i--) {//该题也可以使用递归解决，都是同样的思路。
            if (coins[i] == 0) continue;
            //理想情况下最多可以取的数量
            int curNum = A / price[i];
//            while (curNum > coins[i]) {//实际可以取的数量，没必要用循环，也可以使用Math.min,只需要拿到最小的就可以了。
//                curNum--;
//            }
            curNum = Math.min(curNum,coins[i]);
            ans += curNum;//实际取的数量
            A -= curNum * price[i];
        }
        System.out.println(ans);

    }
}
