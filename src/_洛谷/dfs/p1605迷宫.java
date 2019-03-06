package _洛谷.dfs;

import java.util.Scanner;

public class p1605迷宫 {
    static boolean [][] vis ;
    static int ans = 0;
    static int n;
    static int m;
    static int fx;
    static int fy;
    public static void main(String[] args) {
        Scanner sc  =new Scanner(System.in);
        n = sc.nextInt();//行
        m = sc.nextInt();//列
        int t = sc.nextInt();//障碍总数
        int sx = sc.nextInt(); int sy = sc.nextInt();//起点坐标
        fx = sc.nextInt(); fy = sc.nextInt();//终点坐标
        vis = new boolean[n][m];
        for (int i = 0; i <t ; i++) {
            int tx = sc.nextInt();
            int ty = sc.nextInt();
            vis[tx-1][ty-1] = true;
        }
        dfs(sx-1,sy-1);
        System.out.println(ans);
    }
    private static void dfs(int sx, int sy) {
        if(sx<0 || sx>=n || sy<0 || sy>=m || vis[sx][sy]){//如果超出边界或者已经被访问过 ，直接return
            return ;
        }
        if(sx==(fx-1) && sy==(fy-1)){//如果满足条件,答案+1直接退出
            ans++;
            return;
        }
        vis[sx][sy]= true;//标记为已经访问
        dfs(sx+1,sy);
        dfs(sx-1,sy);
        dfs(sx,sy-1);
        dfs(sx,sy+1);
        vis[sx][sy]= false;//回溯标记
    }
}
