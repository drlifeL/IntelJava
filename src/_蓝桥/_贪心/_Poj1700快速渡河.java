package _蓝桥._贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一组人N个只有一艘船，他们希望快速过河，船上一次只能容纳两个人，划船的速度取决于速度慢的那个人，船是要来回滑动
 * 你的工作就是使用策略，让他们最短时间过河
 * 例：
 * in
 * 1
 * 4
 * 1 2 5 10
 * out
 * 17
 * 第一行是测试用例的数量
 * 第二行是N个人的速度
 */
public class _Poj1700快速渡河 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] speed = new int[n];
            for (int j = 0; j < n; j++) {
                speed[j] = sc.nextInt();
            }
            Arrays.sort(speed);//先排序
//            across(speed, 1);错误的解答
            slove(speed, n);
        }
    }

    private static void slove(int[] speed, int n) {
        int left = n;
        int ans = 0;
        while (left > 0) {
            if (left == 1) {//只有一种
                ans += speed[0];
                break;
            } else if (left == 2) {//已经排过序
                ans += speed[1];
                break;
            } else if (left == 3) {
                ans += speed[2] + speed[0] + speed[1];
                break;
            } else {
                //1，2出发，一返回，最后两名出发，2返回
                int s1 = speed[1] + speed[0] + speed[left - 1] + speed[1];
                //1,3出发，一返回，1,4出发，一返回，1,2,过河
                int s2 = speed[left - 1] + speed[left - 2] + 2 * speed[0];
                ans += Math.min(s1, s2);
                left -= 2;
            }

        }
        System.out.println(ans);


    }

    /**
     * 首先将数组进行排序，然后每次先派出最快能够通过先过去
     * 然后当n==3时候，只有三个人了，那么我们让最慢的两个先过去，然后让对面的最快的回来，搭配我们这边的最快的，一起回去。
     * 当前策略还是不对，如果例子是1 2 2 8 就会错，贪心主要靠猜+证明，要多举例子，再加以反证就可以实现
     * @param speed
     * @param n
     */
    private static void across(int[] speed, int n) {
        int len = speed.length;
        if (len == 1) {
            System.out.println(speed[0]);
            return;
        }
        if (len == 2) {
            System.out.println(Math.max(speed[0], speed[1]));
            return;
        }
        if (len == 3) {
            System.out.println(speed[0] + speed[1] + speed[2]);
            return;
        }
        int cur = speed[0];
        int ans = 0;
        while (n != len - 2) {
            ans += speed[n];//过去的，n当前的一定是最慢的
            ans += cur;//回来的
            n++;
        }
        ans += Math.max(speed[len - 1], speed[len - 2]);
        System.out.println(ans + speed[1] + speed[1]);
    }
}
