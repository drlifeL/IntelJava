package _算法竞赛进阶指南.图_Graph;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _学霸的迷宫 {
    private static class Node{
        int i;
        int j;
        int val;

        public Node(int i, int j, int val) {
            this.i = i;
            this.j = j;
            this.val = val;
        }
    }
    static int n;
    static int m;
    static char graph[][];
    static int res[][];
    static int x[] = {-1, 1, 0, 0};
    static int y[] = {0, 0, -1, 1};
    static char[] dir ={'U', 'D', 'L', 'R'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new char[n][m];
        res = new int[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            graph[i] = sc.nextLine().toCharArray();
        }
        bfs();
        String ans = "";
        int i = 0, j = 0;
        while (i != n - 1 || j != m - 1) {

            for (int k = 0; k < 4; k++) {

                int nx = i + x[k], ny = j + y[k];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && graph[nx][ny] == '1') {
                    if(res[nx][ny] == 1 +res[i][j]){
                        i = nx;
                        j = ny;
                        ans += dir[k];
                        break;
                    }

                }
            }
        }

        System.out.println(res[n-1][m-1]);
        System.out.println(ans);
    }

    /**
     * 数据中0可以通过但是1不可以通过
     */
    private static void bfs() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(0, 0, 0));
        graph[0][0] = '1';
        while (!queue.isEmpty()) {
            Node out = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ox = out.i ,oy = out.j,ov = out.val;
                if (check(ox+ x[i], oy+ y[i])) {
                    queue.add(new Node(ox + x[i], oy + y[i], ov + 1));
                    res[ox+ x[i]][oy + y[i]] = ov + 1;//保存结果
                }
            }
        }
    }

    private static boolean check(int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= n || graph[i][j] == '1') {
            return false;
        }
        graph[i][j] = '1';
        return true;
    }
}