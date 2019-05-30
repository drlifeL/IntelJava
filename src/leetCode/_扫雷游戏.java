package leetCode;

public class _扫雷游戏 {
    public static void main(String[] args) {
        char[][] map = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};

        char[][] map1 = {{'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}};

        map = updateBoard(map1, new int[]{1, 2});
        print(map);
    }


    static int[] x = new int[]{-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] y = new int[]{0, 0, -1, 1, -1, 1, -1, 1};
    public static void print(char[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        dfs(board, click[0], click[1]);
        return board;
    }

    private static void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) return;
        if (board[i][j] == 'E') {
            if (jujde(board, i, j)) {
                board[i][j] = ((char) (count(board, i, j) + 48));
            } else {
                board[i][j] = 'B';
                for (int k = 0; k < 8; k++) {
                    dfs(board, i + x[k], j + y[k]);
                }
            }

        }


    }

    private static int count(char[][] board, int i, int j) {
        int count = 0;
        for (int k = 0; k < 8; k++) {
            int x1 = x[k] + i;
            int y1 = y[k] + j;
            if (x1 < 0 || y1 < 0 || x1 >= board.length || y1 >= board[x1].length) continue;
            if (board[x1][y1] == 'M') {
                count += 1;

            }
        }
        return count;
    }

    /**
     * 判断周围有五相邻的地雷
     *
     * @param board
     * @param i
     * @param j
     * @return
     */
    private static boolean jujde(char[][] board, int i, int j) {
        boolean flag = false;
        for (int k = 0; k < 8; k++) {
            int x1 = x[k] + i;
            int y1 = y[k] + j;
            if (x1 < 0 || y1 < 0 || x1 >= board.length || y1 >= board[x1].length) continue;
            if (board[x1][y1] == 'M') {
                return true;
            }
        }
        return false;
    }
}
