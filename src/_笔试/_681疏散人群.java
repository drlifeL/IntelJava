package _笔试;

import java.util.Scanner;


/**
 * 该题没有必要进行模拟，
 * 题意还是要理解清楚：在该题中我们只要需要遍历根节点的下一层子节点，然后以这个子节点为跟节点，判断其下面有多少个节点，然后输出最大值就可以了
 */
public class _681疏散人群 {


    static int n;
    static int m;
    static int h[];
    static int e[];
    static int ne[];
    static int idx;
    static int q[];
    static boolean st[];

    /**
     * 先创建一个新的点
     * 让这个点的next指针指向h[a]
     * 再让h[a]指向他
     * 他让-1表示空指针 我们让其为0
     *
     * @param a
     * @param b
     */
    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public static int bfs(int u) {
        int hh = 0, tt = 0;
        q[0] = u;
        st[u] = true;

        while (hh <= tt) {
            int t = q[hh++];
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (!st[j]) {
                    q[++tt] = j;
                    st[j] = true;
                }
            }
        }
        return tt + 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        m = n * 2;

        h = new int[n+1];
        e = new int[m];
        ne = new int[m];
        q = new int[n];
        st = new boolean[n+1];

        for (int i = 0; i < n - 1; i++) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();
            add(a, b);
            add(b, a);
        }
        int res = 0;
        st[1] = true;
        for (int i = h[1]; i != 0; i = ne[i]) {
            res = Math.max(res, bfs(e[i]));
        }


    }

}
