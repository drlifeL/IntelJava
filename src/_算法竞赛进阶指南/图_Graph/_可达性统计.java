package _算法竞赛进阶指南.图_Graph;

import java.util.Scanner;

/**
 * 给定一张N个点M条边的有向无环图，分别统计从每个点出发能够到达的点的数量。
 *
 * 输入格式
 * 第一行两个整数N,M，接下来M行每行两个整数x,y，表示从x到y的一条有向边。
 *
 * 输出格式
 * 输出共N行，表示每个点能够到达的点的数量。
 *
 * 数据范围
 * 1≤N,M≤30000
 *  拓扑排序，很懵圈
 */
public class _可达性统计 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M= sc.nextInt();
        int []res = new int[N];
        for (int i = 0; i < M; i++) {
            int x = sc. nextInt();
            int y = sc.nextInt();
        }
    }
}
