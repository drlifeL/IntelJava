package leetCode;

import java.util.Scanner;
/*
10
        12
        w........ww.
        .www.....www
        ....ww...ww.
        .........ww.
        .........w..
        ..w......w..
        .w.w.....ww.
        w.w.w.....w.
        .w.w......w.
        ..w.......w.
*/
public class _水洼数目 {
    static int fx[] = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int fy[] = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][]g = new char[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            g[i] = sc.nextLine().toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(g[i][j]=='w'){
                    dfs(g,i,j);
                    ans++;
                }
            }
        }
        System.out.println(ans);


    }

    public static void dfs(char[][] g, int x, int y) {
        if (x < 0 || x >= g.length || y < 0 || y >= g[0].length || g[x][y] == '.') return;
        g[x][y] = '.';
        for (int i = 0; i < 8; i++) {
            dfs(g, x + fx[i], y + fy[i]);
        }
    }

}
