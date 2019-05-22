package leetCode;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * m = 3, n = 2  out = 3
 */
public class _不同路径 {
    static int m;
    static int n;
    static int ans = 0;

    public static void main(String[] args) {
        m = 23 ;
        n = 12;
        find(0, 0);
        System.out.println(ans);
    }

    /**
     * 应该要使用记忆性递归，来降低程序的时间复杂度
     * @param i
     * @param j
     */
    public static void find(int i, int j) {
        if (i == m - 1 && j == n - 1) {
            ans++;
            return;
        }
        if (i >= m || j >= n) {
            return;
        }

        find(i + 1, j);
        find(i, j + 1);

    }


}
