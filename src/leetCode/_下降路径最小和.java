package leetCode;

import java.util.Arrays;

/**
 * 感觉该题是一个动态规划题
 */
public class _下降路径最小和 {
    public static void main(String[] args) {
        int A[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //不知所错...，应该是算法问题/但是考虑了一下，如果使用dfs,感觉会溢出
        int B[][] = {{-51, -35, 74}, {-62, 14, -53}, {94, 61, -10}};
        System.out.println(minFallingPathSum(B));
    }


    public static int minFallingPathSum(int[][] A) {
        int arr[] = Arrays.copyOf(A[0], A[0].length);
        int last = A[0].length - 1;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (j == 0) {
                    arr[j] += Math.min(A[i + 1][j], A[i + 1][j + 1]);
                } else if (last == j) {
                    arr[j] += Math.min(A[i + 1][j - 1], A[i + 1][j]);
                } else {//在中间的位置
                    int mid = Math.min(A[i + 1][j - 1], A[i + 1][j]);
                    arr[j] += Math.min(mid, A[i + 1][j + 1]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < ans) {
                ans = arr[i];
            }
        }
        return ans;
    }

}
