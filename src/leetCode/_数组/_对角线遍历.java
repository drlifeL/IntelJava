package leetCode._数组;

import java.util.Arrays;

public class _对角线遍历 {
    public static void main(String[] args) {
        int[][] matrix = init(3, 3);

        System.out.println(Arrays.toString(findDiagonalOrder(matrix)));
    }

    private static int[][] init(int M, int N) {
        int k = 1;
        int matrix[][] = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = k++;
            }
        }
        return matrix;
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        int cx = 0;//当前
        int cy = 1;
        int ans[] = new int[matrix.length * matrix[0].length];//新数组的长度
        boolean flag = true;//左上往右下
        ans[0] = matrix[0][0];
        int k = 1;
        while (flag && cx != cy && cy != cx) {
            ans[k++] = matrix[cx][cy];
            cx += 1;
            cy -= 1;
        }
        while (true) {


//            ans[k++] = matrix[x][y];
//            if (flag) {
//                x += 1;
//                y -= 1;
//            } else {
//                x -= 1;
//                y += 1;
//            }
//            if (y == 0) {
//                flag = false;
//                x += 1;
//            }
//            if (x == 0) {
//                flag = true;
//                y += 1;
//            }
//            if (x == matrix.length - 1 && y == matrix[0].length - 1) {
//                ans[k++] = matrix[x][y];
//                break;
//            }
            return ans;
        }
    }
}
