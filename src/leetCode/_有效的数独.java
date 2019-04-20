package leetCode;

import java.util.Arrays;

public class _有效的数独 {
    static boolean ans;

    public static void main(String[] args) {
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
                {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0', '0', '0'}
        };
        dfs(z, 0, 0);
        System.out.println(ans);
    }

    public static void dfs(char[][] g, int x, int y) {
        if (x == 9) {
            System.out.println(Arrays.deepToString(g));
            ans = true;
            return;
        }
        if (g[x][y] == '0') {
            for (int i = 1; i <= 9; i++) {
                boolean flag = check(g, x, y, i);
                if (flag) {
                    g[x][y] = (char) ('0' + i);
                    if (y == 8) {
                        dfs(g, x + 1, 0);
                    } else {
                        dfs(g, x, y + 1);
                    }
                }
            }
            g[x][y] = '.';

        } else {
            if (y == 8) {
                dfs(g, x + 1, 0);
            } else {
                dfs(g, x, y + 1);
            }
        }
    }

    public static boolean check(char[][] g, int x, int y, int val) {
        char in = (char) ('0' + val);
        for (int i = 0; i < 9; i++) {
            if (g[i][y] == in || g[x][i] == in) {
                return false;
            }
        }

        if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (g[i][j] == in) {
                        return false;
                    }
                }
            }
        }
        if (x >= 0 && x <= 2 && y >= 3 && y <= 5) {
            for (int i = 0; i < 3; i++) {
                for (int j = 3; j < 6; j++) {
                    if (g[i][j] == in) {
                        return false;
                    }
                }
            }
        }
        if (x >= 0 && x <= 2 && y >= 6 && y <= 8) {
            for (int i = 0; i < 3; i++) {
                for (int j = 6; j < 9; j++) {
                    if (g[i][j] == in) {
                        return false;
                    }
                }
            }
        }

        if (x >= 3 && x <= 5 && y >= 0 && y <= 2) {
            for (int i = 3; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    if (g[i][j] == in) {
                        return false;
                    }
                }
            }
        }
        if (x >= 3 && x <= 5 && y >= 3 && y <= 5) {
            for (int i = 3; i < 6; i++) {
                for (int j = 3; j < 6; j++) {
                    if (g[i][j] == in) {
                        return false;
                    }
                }
            }
        }
        if (x >= 3 && x <= 5 && y >= 6 && y <= 8) {
            for (int i = 3; i < 6; i++) {
                for (int j = 6; j < 9; j++) {
                    if (g[i][j] == in) {
                        return false;
                    }
                }
            }
        }

        if (x >= 6 && x <= 8 && y >= 0 && y <= 2) {
            for (int i = 6; i < 9; i++) {
                for (int j = 0; j < 3; j++) {
                    if (g[i][j] == in) {
                        return false;
                    }
                }
            }
        }
        if (x >= 6 && x <= 8 && y >= 3 && y <= 5) {
            for (int i = 6; i < 9; i++) {
                for (int j = 3; j < 6; j++) {
                    if (g[i][j] == in) {
                        return false;
                    }
                }
            }
        }
        if (x >= 6 && x <= 8 && y >= 6 && y <= 8) {
            for (int i = 6; i < 9; i++) {
                for (int j = 6; j < 9; j++) {
                    if (g[i][j] == in) {
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
