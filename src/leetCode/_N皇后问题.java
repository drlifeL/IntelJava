package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _N皇后问题 {
    static int n;
    static int ans;
    static List<List<String>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        char g[][] = new char[n][n];
        dfs(g, 0);
        System.out.println(ans);
        System.out.println(list);
//        System.out.println(check(g, 1, 3));
    }

    public static void formatAddtoList(char [][]g){
        List<String> temp = new ArrayList<>();
        String s  = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s+=g[i][j]=='\0'?'.':'Q';
            }
            temp.add(s);
            s = "";
        }
        list.add(temp);
    }
    public static void dfs(char[][] g, int x) {
        if (x == n) {
            ans++;
            formatAddtoList(g);
            print(g);
            return;
        }

        for (int i = 0; i < g.length; i++) {
            boolean flag = check(g, x, i);
            if (flag) {
                g[x][i] = 'Q';
                dfs(g, x + 1);
                g[x][i] = '\0';
            }
        }

    }

    private static boolean check(char[][] g, int x, int y) {
        for (int i = 0; i < n; i++) {
            if (g[i][y] == 'Q') return false;//这里可以只判断一个，我们的行可以不用判定。
        }
        int fx = x >= y ? x - y : 0;
        int fy = x >= y ? 0 : y - x;
        while (fx <= n - 1 && fy <= n - 1) {//从左往右,且为左上到右下
            if (g[fx][fy] == 'Q') return false;
            fx++;
            fy++;
        }
        if (x == n - 1 && y == n - 1) {//这里是个特殊的例子，需要单独判断，否则就会少四个结果，
            //如果不判断，那么rx和ry的值会取错
            return !(g[n - 1][n - 1] == 'Q');
        } else {
            int rx = x + y >= n ? (x + y) % (n - 1) : 0;//通过表格得到的结论
            int ry = x + y >= n ? (n - 1) : (x + y);
            while (rx <= (n - 1) && ry >= 0) {//从右往左，右上到左下
                if (g[rx][ry] == 'Q') return false;
                rx++;
                ry--;
            }
        }
        return true;
    }

    public static void print(char[][] g) {
        System.out.print(ans + " : ");
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                System.out.print((g[i][j] == '\0' ?"": (j + 1) + " "));
            }

        }
        System.out.println();
    }
}
