package _笔试;

/**
 * 给定一个N*M的矩阵，按1-n计算，蛇形打印其值
 */
public class _蛇形矩阵 {
    public static void main(String[] args) {
        int n = 5;
        int[][] arr = new int[n][n];
        init(arr);
        print_Arr(arr, n);

    }

    private static void print_Arr(int[][] arr, int n) {
        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};


    }

    private static void init(int[][] arr) {
        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = num++;
            }
        }
    }

}
