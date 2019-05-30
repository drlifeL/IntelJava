package leetCode;

public class _单调数列 {
    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 1};
        System.out.println(isMonotonic(A));
    }

    /**
     * 首先判断其实递增还是递减
     *
     * @param A
     * @return
     */
    public static boolean isMonotonic(int[] A) {
        if (A.length == 1) {
            return true;
        }
        boolean flag = true;//递增
        int i;
        for (i = 1; i < A.length; i++) {
            if (A[0] == A[i]) continue;
            if (A[i - 1] > A[i]) {
                flag = false;//递减
                break;
            }
        }

        for (i = 1; i < A.length; i++) {
            if (flag) {
                if (A[i] < A[i - 1]) {
                    return false;
                }
            } else {
                if (A[i] > A[i - 1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
