package leetCode;

import java.util.Arrays;

public class _八皇后问题 {
    static int ans = 0;

    public static void main(String[] args) {
        char[][] g = new char[8][8];
        dfs(g, 0, 0);
        System.out.println(ans);
//        System.out.println(check2(g,7,7));
    }

    public static void dfs(char[][] g, int x, int y) {
        if (x == 8) {
            ans++;
            print(g);
            return;
        }
        for (int i = 0; i < 8; i++) {
            boolean flag = check2(g, x, i);
            if (flag) {
                g[x][i] = 'Q';
                dfs(g, x + 1, 0);
                g[x][i] = '\0';
            }
        }
    }

    /**
     * 精简版的第一个答案，
     * @param g
     * @param x
     * @param y
     * @return
     */
    private static boolean check(char[][] g, int x, int y) {
        for (int i = 0; i < 8; i++) {
            if (g[x][i] == 'Q' || g[i][y] == 'Q') return false;
        }
        int fx = x >= y ? x - y : 0;
        int fy = x >= y ? 0 : y - x;
        while (fx <= 7 && fy <= 7) {//从左往右,且为左上到右下
            if (g[fx][fy] == 'Q') return false;
            fx++;
            fy++;
        }
        if (x == 7 && y == 7) {//这里是个特殊的例子，需要单独判断，否则就会少四个结果，
            //如果不判断，那么rx和ry的值会取错
            return !(g[7][7] == 'Q');
        } else {
            int rx = x + y >= 8 ? (x + y) % 7 : 0;//通过表格得到的结论
            int ry = x + y >= 8 ? 7 : (x + y);

            while (rx <= 7 && ry >= 0) {//从右往左，右上到左下
                if (g[rx][ry] == 'Q') return false;
                rx++;
                ry--;
            }
        }
        return true;
    }


    /**
     * 耗费无数精力总结出来的第一个答案,用写表法写总结出来的规律，两个对角线特别不好判断
     * @param g
     * @param x
     * @param y
     * @return
     */
    public static boolean check2(char[][] g, int x, int y) {
        for (int i = 0; i < 8; i++) {
            if (g[x][i] == 'Q' || g[i][y] == 'Q') return false;
        }
        //对于任意的x>=y 未能解决：x>=y从右往左的扫描办法，x<y的所有办法
        if (x >= y) {
            int fx = x - y;
            int fy = 0;
            while (fx <= 7 && fy <= 7) {//从左往右,且为左上到右下
                if (g[fx][fy] == 'Q') return false;
                fx++;
                fy++;
            }
            if (x == 7 && y == 7) {//这里是个特殊的例子，需要单独判断，否则就会少四个结果，
                //如果不判断，那么rx和ry的值会取错
                return !(g[7][7] == 'Q');
            } else {
                int rx = x + y >= 8 ? (x + y) % 7 : 0;//通过表格得到的结论
                int ry = x + y >= 8 ? 7 : (x + y);
                while (rx <= 7 && ry >= 0) {//从右往左，右上到左下
                    if (g[rx][ry] == 'Q') return false;
                    rx++;
                    ry--;
                }
            }
        } else {
            int fx = 0;
            int fy = y - x;
            while (fx <= 7 && fy <= 7) {//从左往右,且为左上到右下
                if (g[fx][fy] == 'Q') return false;
                fx++;
                fy++;
            }
            int rx = x + y >= 8 ? (x + y) % 7 : 0;//通过表格得到的结论
            int ry = x + y >= 8 ? 7 : (x + y);
            while (rx <= 7 && ry >= 0) {//从右往左，右上到左下
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
                System.out.print((g[i][j] == '\0' ? "" : (j + 1) + " "));
            }

        }
        System.out.println();
    }
}
