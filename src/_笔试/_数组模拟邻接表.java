package _笔试;

import java.util.Scanner;

/**
 * 该类只完成了一点，还是没有想的明白
 */
public class _数组模拟邻接表 {
    static int[] s;
    static int[] e;
    static int index = 0;
    static int[] first;//再用一个first数组来存储每个顶点其中一条边的编号,以便待会我们来枚举每个顶点所有的边
    static int[] next;//如果当前这条“编号为i的边”，是我们发现的以u[i]为起始点的第一条边，就将next[i]的值设为-1

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //我们假设他没有0号节点
        int n = sc.nextInt();
        int m = n * 2;//因为是无向图，最多存储为2N
        s = new int[m];
        e = new int[m];
        first = new int[n + 1];
        next = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            //存储每一条边的信息,建立双向存储
            add(x, y);
            add(y, x);
        }
        for (int i = 0; i < index; i++) {
            System.out.println(s[i] + "---->" + e[i]);
        }
        for (int i = 0; i < first.length; i++) {
            System.out.println(first[i]);
        }

    }

    private static void add(int x, int y) {
        s[index] = x;
        e[index++] = y;
        first[x] = x;
        next[x] = -1;
    }
}
