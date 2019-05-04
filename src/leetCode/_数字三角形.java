package leetCode;

import java.util.Scanner;

public class _数字三角形 {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }
        System.out.println(dfs(triangle, 0, 0, 0));

        System.out.println(maxSumUseMemory(triangle, 0, 0, new int[n][n]));

        System.out.println(maxSumUsedp(triangle));
    }

    /**
     * poj Time Limit
     *
     * @param triangle
     * @param i
     * @param j
     * @param v
     * @return
     */
    private static int dfs(int[][] triangle, int i, int j, int v) {
        if (i == n) {
            return v;
        }
        v += triangle[i][j];
        return Math.max(dfs(triangle, i + 1, j, v), dfs(triangle, i + 1, j + 1, v));
    }

    /**
     * 记忆型递归可以不超时，但是效率不如dp
     *
     * @param triangle
     * @param i
     * @param j
     * @param map
     * @return
     */
    public static int maxSumUseMemory(int[][] triangle, int i, int j, int[][] map) {
        int rowIndex = triangle.length;
        int value = triangle[i][j];
        if (i != rowIndex - 1) {
            //缓存有值，不递归
            int v1 = map[i + 1][j];
            if (v1 == 0) {
                v1 = maxSumUseMemory(triangle, i + 1, j, map);
            }
            //缓存有值，便不递归
            int v2 = map[i + 1][j + 1];
            if (v2 == 0) {
                v2 = maxSumUseMemory(triangle, i + 1, j + 1, map);
            }
            value += Math.max(v1, v2);
        }
        //放入缓存
        map[i][j] = value;
        return value;
    }

    /**
     * 动态规划+滚动数组
     *
     * @param triangle
     * @return
     */
    public static int maxSumUsedp(int[][] triangle) {
        int rowCount = triangle.length;
        int loopArr[] = new int[rowCount];
        for (int i = 0; i < rowCount; i++) {//初始化最后一行
            loopArr[i] = triangle[rowCount - 1][i];
        }
        for (int i = rowCount - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                loopArr[j] = triangle[i][j] + Math.max(loopArr[j], loopArr[j + 1]);
            }
        }
        return loopArr[0];
    }


}
