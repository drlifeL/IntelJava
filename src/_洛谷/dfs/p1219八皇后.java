package _洛谷.dfs;

import java.util.Scanner;

public class p1219八皇后 {
    static boolean [][]vis;
    static int ans  = 0;
    static int n;
    static int [][] result;
    static int temp = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        vis  = new boolean[n][n];
        result  = new int[3][n];
        dfs(0);
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(ans);
    }

    private static void dfs(int i) {

        if(i>(n-1)){//满足条件
            if(temp<3){//存储前三项数据
                for (int k = 0; k <n ; k++) {
                    result[temp][k] = checkvis(k);
                }
                temp++;
            }
            ans++;
            return;
        }

        for (int j = 0; j <n ; j++) {
            if(check(i,j)){
                vis[i][j] = true;
                dfs(i+1);
                vis[i][j] = false;
            }
        }

    }

    /**
     * 检查其对角有没有王
     * @param k
     * @param j
     * @return
     */

    public static boolean check(int k,int j){//判断节点是否合适
        for(int i=0;i<8;i++){//检查行列冲突
            if(vis[i][j]){
                return false;
            }
        }
        for(int i=k-1,m=j-1; i>=0 && m>=0; i--,m--){//检查左对角线
            if(vis[i][j]){
                return false;
            }
        }
        for(int i=k-1,m=j+1; i>=0 && m<=7; i--,m++){//检查右对角线
            if(vis[i][j]){
                return false;
            }
        }
        return true;
    }


    /**
     * 拿到j坐标
     * @param k
     * @return
     */
    private static int checkvis(int k) {
        for (int i = 0; i <n ; i++) {
            if(vis[k][i]){
                return i;
            }
        }
        return -1;
    }
}
