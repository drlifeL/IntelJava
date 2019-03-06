package _洛谷.dfs;

import java.util.Arrays;
import java.util.Scanner;

public class _历届试题九宫重排 {
    static char [][]g = new char[3][3];//九宫格
    static char [][]fi = new char[3][3];
    static boolean [][]vis = new boolean[3][3];
    static int fx;
    static int fy;
    static int ans = Integer.MAX_VALUE;
    public static void dfs(int i,int j,int steps){

        if(i<0 || i==3 || j<0 || j==3)return;

        if(i==fx && j==fy){
            if(Arrays.equals(g,fi)){
                ans = Math.min(ans,steps);
            }
            return;
        }
        if(i+1!=3 && !vis[i+1][j]){
            swap(i,j,i+1,j);
            vis[i][j] =true;
            dfs(i+1,j,steps+1);
            vis[i][j] = false;
        }
        if(i-1>=0 && !vis[i-1][j]) {
            swap(i,j,i-1,j);
            vis[i][j] =true;
            dfs(i - 1, j, steps + 1);
            vis[i][j] = false;
        }
        if(j+1!=3 && !vis[i][j+1]) {
            swap(i,j,i,j+1);
            vis[i][j] =true;
            dfs(i , j+1, steps + 1);
            vis[i][j] =false;
        }
        if(j-1>=0 && !vis[i][j-1]) {
            swap(i,j,i,j-1);
            vis[i][j] = true;
            dfs(i , j+1, steps + 1);
            vis[i][j] = false;
        }

    }

    private static void swap(int i1, int j1, int i, int j) {
        char temp = g[i1][j1];
        g[i1][j1] = g[i][j];
        g[i][j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  s = sc.nextLine();
        String  f = sc.nextLine();
        int temp = 0;
        int sx = -1,sy= -1;//开始的起点

        for (int i = 0; i < 3 ; i++) {//初始化开始形态
            for (int j = 0; j <3 ; j++) {
                char  c = (s.charAt(temp++));
                if(c=='.'){
                    sx = i;sy = j;
                }
                g[i][j] = c;
            }
        }
        temp = 0;
        for (int i = 0; i < 3 ; i++) {//初始化最终态
            for (int j = 0; j <3 ; j++) {
                char  c = (f.charAt(temp++));
                if(c=='.'){
                    fx = i;fy = j;
                }
                fi[i][j] = c;
            }
        }
        dfs(sx,sy,0);
        System.out.println(ans);
    }

}
