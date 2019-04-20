package _蓝桥;

import java.util.Arrays;

public class _数独游戏 {
    static long curTime;
    static boolean exit;
    static char[][]copy;
    public static void main(String[] args) {
        char[][] g = {
                {'0', '0', '5', '3', '0', '0', '0', '0', '0'},
                {'8', '0', '0', '0', '0', '0', '0', '2', '0'},
                {'0', '7', '0', '0', '1', '0', '5', '0', '0'},
                {'4', '0', '0', '0', '0', '5', '3', '0', '0'},
                {'0', '1', '0', '0', '7', '0', '0', '0', '6'},
                {'0', '0', '3', '2', '0', '0', '0', '8', '0'},
                {'0', '6', '0', '5', '0', '0', '0', '0', '9'},
                {'0', '0', '4', '0', '0', '0', '0', '3', '0'},
                {'0', '0', '0', '0', '0', '9', '7', '0', '0'}
        };
        char[][] z = {
                {'5', '3', '0', '0', '7', '0', '0', '0', '0'},
                {'6', '0', '0', '1', '9', '5', '0', '0', '0'},
                {'0', '9', '8', '0', '0', '0', '0', '6', '0'},
                {'8', '0', '0', '0', '6', '0', '0', '0', '3'},
                {'4', '0', '0', '8', '0', '3', '0', '0', '1'},
                {'7', '0', '0', '0', '2', '0', '0', '0', '6'},
                {'0', '6', '0', '0', '0', '0', '2', '8', '0'},
                {'0', '0', '0', '4', '1', '9', '0', '0', '5'},
                {'0', '0', '0', '0', '8', '0', '0', '7', '9'}
        };
        char[][] z1 = {
                {'0', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'3', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'4', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'5', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'6', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'7', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'8', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'9', '0', '0', '0', '0', '0', '0', '0', '0'}
        };
//        dfs(g,0,0);
        curTime = System.currentTimeMillis();
        copy = new char[z.length][z[0].length];
        dfs(z, 0, 0);
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < z[i].length; j++) {
                 z[i][j]= copy[i][j];
            }
        }
        System.out.println(Arrays.deepToString(z));
    }

    public static void dfs(char[][] g, int x, int y) {
        if (exit) {
            return;
        }
        if (x == 9) {//已经找到答案
            long lastTime = System.currentTimeMillis();
            System.out.println(lastTime - curTime);
            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < g[i].length; j++) {
                    copy[i][j] = g[i][j];
                }
            }
            exit = true;
            return;//可以直接退出虚拟机，因为我们是求唯一解,其实也只有一个唯一解
        }
        if (g[x][y] == '0') {
            for (int i = 1; i <= 9; i++) {
                boolean flag = check(g, x, y, i);//如果当前的值是合法的
                if (flag) {
                    g[x][y] = (char) ('0' + i);//转移状态
                    dfs(g, x + (y + 1) / 9, (y + 1) % 9);//这句不好写转换成下面的就是
//                    if (y == 8) {//如果已经到了当前行的最后一列
//                        dfs(g, x + 1, 0);
//                    } else {
//                        dfs(g, x, y + 1);
//                    }

                }
            }
            g[x][y] = '0';//回溯

        } else {
            dfs(g, x + (y + 1) / 9, (y + 1) % 9);//如果当前行已经有数字
//            if (y == 8) {//如果已经到了当前行的最后一列
//                dfs(g, x + 1, 0);
//            } else {
//                dfs(g, x, y + 1);
//            }
        }
    }

    public static boolean check(char[][] g, int x, int y, int value) {
        char in = (char) ('0' + value);
        for (int i = 0; i < 9; i++) {
            if (g[x][i] == in || g[i][y] == in) {
                return false;
            }
        }

        //别人的代码
        for (int i = (x / 3) * 3; i < (x / 3 + 1) * 3; i++) {
            for (int j = (y / 3) * 3; j < (y / 3 + 1) * 3; j++) {
                if (g[i][j] == in) return false;
            }
        }


//        处理小九宫格，自己写的..
//        if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
//            for (int i = 0; i < 3; i++) {
//                for (int j = 0; j < 3; j++) {
//                    if (g[i][j] == in) {
//                        return false;
//                    }
//                }
//            }
//        }
//        if (x >= 0 && x <= 2 && y >= 3 && y <= 5) {
//            for (int i = 0; i < 3; i++) {
//                for (int j = 3; j < 6; j++) {
//                    if (g[i][j] == in) {
//                        return false;
//                    }
//                }
//            }
//        }
//        if (x >= 0 && x <= 2 && y >= 6 && y <= 8) {
//            for (int i = 0; i < 3; i++) {
//                for (int j = 6; j < 9; j++) {
//                    if (g[i][j] == in) {
//                        return false;
//                    }
//                }
//            }
//        }
//
//        if (x >= 3 && x <= 5 && y >= 0 && y <= 2) {
//            for (int i = 3; i < 6; i++) {
//                for (int j = 0; j < 3; j++) {
//                    if (g[i][j] == in) {
//                        return false;
//                    }
//                }
//            }
//        }
//        if (x >= 3 && x <= 5 && y >= 3 && y <= 5) {
//            for (int i = 3; i < 6; i++) {
//                for (int j = 3; j < 6; j++) {
//                    if (g[i][j] == in) {
//                        return false;
//                    }
//                }
//            }
//        }
//        if (x >= 3 && x <= 5 && y >= 6 && y <= 8) {
//            for (int i = 3; i < 6; i++) {
//                for (int j = 6; j < 9; j++) {
//                    if (g[i][j] == in) {
//                        return false;
//                    }
//                }
//            }
//        }
//
//        if (x >= 6 && x <= 8 && y >= 0 && y <= 2) {
//            for (int i = 6; i < 9; i++) {
//                for (int j = 0; j < 3; j++) {
//                    if (g[i][j] == in) {
//                        return false;
//                    }
//                }
//            }
//        }
//        if (x >= 6 && x <= 8 && y >= 3 && y <= 5) {
//            for (int i = 6; i < 9; i++) {
//                for (int j = 3; j < 6; j++) {
//                    if (g[i][j] == in) {
//                        return false;
//                    }
//                }
//            }
//        }
//        if (x >= 6 && x <= 8 && y >= 6 && y <= 8) {
//            for (int i = 6; i < 9; i++) {
//                for (int j = 6; j < 9; j++) {
//                    if (g[i][j] == in) {
//                        return false;
//                    }
//                }
//            }
//        }
        return true;
    }
}
