package _蓝桥._贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有n项工作，每项工作分别在si时间开始，在ti时间结束
 * 对于每项工作，你都可以选择参与与否，如果选择了参与，那么自始至终都必须全程参与、
 * 此外，参加工作的时间段不能重复（即使是开始的瞬间和结束的瞬间的重叠也是不允许的）
 * 你的目标是参与尽可能多的工作，那么最多能参与多少项工作
 * 100000
 * si<=ti <=10^9
 * 输入：
 * 第一行：n
 * 第二行：n个整数空格隔开，代表n个工作的开始时间
 * 第三行：n个整数空格隔开，代表n个工作的结束时间
 * <p>
 * 样例输入：
 * 5
 * 1 2 4 6 8
 * 3 5 7 9 10
 */
public class _区间调度问题 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] si = new int[n];
        int[] ti = new int[n];
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            si[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ti[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(si[i], ti[i]);
        }
        Arrays.sort(jobs);
        slove(n, jobs);
    }

    /**
     * 贪心解决策略：
     *     先对输入的数据进行排序，将结束时间最小的放在前面，每次选择结束时间最早，且他的起点是大于我们上一个线段的终点的。
     * @param n
     * @param jobs
     */
    private static void slove(int n, Job[] jobs) {
        int ans = 1;//已经选择了一个线段了
        int y = jobs[0].ti;//第一个的起点必然是最小的，所以我们一开始就可以使用它。
        for (int i = 1; i < n; i++) {
            int s = jobs[i].si;
            if (s > y) {//当前的起点是大于我们上一个选择线段的终点的
                ans++;
                y = jobs[i].ti;//y的值要发生变更
            }
        }
        System.out.println(ans);
    }

    private static class Job implements Comparable<Job> {
        int si;
        int ti;

        public Job(int si, int ti) {
            this.si = si;
            this.ti = ti;
        }

        @Override
        public int compareTo(Job o) {
            /**
             * 当x小于y时，返回一个负数，当x等于y时，返回0，否则返回一个正数
             */
            if (this.ti < o.ti) {
                return this.ti - o.ti;
            }
            return this.ti - o.ti;
        }
    }
}
