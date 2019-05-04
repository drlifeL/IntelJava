package _蓝桥;

import java.util.Scanner;

/**
 * 不知道当前dfs的错误点在哪里
 */
public class _地宫取宝 {
    static int n;
    static int m;
    static int[][] g;
    static int k;
    static int ans;
    static int mod = 1000000007;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        g = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0, 0, 0, "");
        System.out.println(ans);
    }
    //|| (i == n - 1 && j == m - 1 && value > maxVal && curNum + 1 == k)

    /**
     * @param i      当前行
     * @param j      当前列
     * @param curNum 宝贝的数量
     * @param maxVal 当前宝贝中的最大值
     */
    private static void dfs(int i, int j, int curNum, int maxVal, String path) {

        if (i >= n || j >= m) return;
        if (curNum > k) return;//如果当前手中的宝贝数量已经超过了k值，直接可以return了
        int value = g[i][j];
        if (i == n - 1 && j == m - 1 && curNum == k ) {
            ans++;
            System.out.println(path);
            return;
        }
        if( (i == n - 1 && j == m - 1 && value > maxVal && curNum + 1 == k)){
            ans++;
            System.out.println(path+value);
            return;
        }
        //前面的意思是我到了出口，这个出口的东西我不要都够，满足条件，第二个是我到了出口，最后一个东西我也可以取，并且加上最后一个东西值正好等于k
        if (value > maxVal) {//可以拿的情况下
            //拿上它，往下走
            dfs(i + 1, j, curNum + 1, value, path + value + "||");
            dfs(i + 1, j, curNum, maxVal, path+"下");
            //拿上它，往右走
            dfs(i, j + 1, curNum + 1, value, path + value + "->");
            dfs(i, j + 1, curNum, maxVal, path+"右");
        }


        //不拿的情况

    }




}
