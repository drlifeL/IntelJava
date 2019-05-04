package leetCode;

public class _不相交的线 {
    public static void main(String[] args) {
        int[] A = {2, 5, 1, 2, 5};
        int[] B = {10, 5, 2, 1, 5, 2};
        int[] A1 = {1, 3, 7, 1, 7, 5}, B1 = {1, 9, 2, 5, 1};
        int[] A2 = {1, 2}, B2 = {1, 1};
        int[] A3 = {5, 1, 2, 5, 1, 2, 2, 3, 1, 1, 1, 1, 1, 3, 1};
        int[] B3 = {2, 5, 1, 3, 4, 5, 5, 2, 2, 4, 5, 2, 2, 3, 1, 4, 5, 3, 2, 4, 5, 2, 4, 4, 2, 2, 2, 1, 3, 1};
        int[] A4 = {2, 3, 1};
        int[] B4 = {3, 1, 3, 3, 3, 3};

        System.out.println(maxUncrossedLines(A1, B1));
//        System.out.println(sannerLine1(A3, B3, 0, 0, 0));
        int[][][] memoey = new int[50][50][50];
        System.out.println(sannerLine2(A1, B1, 0, 0, 0, memoey));
    }

    static int maxLine = 0;

    public static int maxUncrossedLines(int[] A, int[] B) {
        sannerLine(A, B, 0, 0, 0);
        return maxLine;
    }

    private static void sannerLine(int[] a, int[] b, int aStart, int bStart, int curLine) {
        if (aStart >= a.length || bStart >= b.length) {
            maxLine = Math.max(curLine, maxLine);
            return;
        }
        for (int i = aStart; i < a.length; i++) {
            for (int j = bStart; j < b.length; j++) {
                if (a[i] == b[j]) {
                    sannerLine(a, b, i + 1, j + 1, curLine + 1);
                }
            }
        }
    }

    /**
     * 就这样写会超出限制，因为存在重复求解，可以选择使用一下记忆性递归
     *
     * @param a
     * @param b
     * @param aStart
     * @param bStart
     * @param curLine
     * @return
     */
    private static int sannerLine1(int[] a, int[] b, int aStart, int bStart, int curLine) {
        if (aStart >= a.length || bStart >= b.length) {
            return curLine;
        }
        int len = curLine;
        int x = curLine;
        if (a[aStart] == b[bStart]) {
            len = sannerLine1(a, b, aStart + 1, bStart + 1, curLine + 1);
        } else {
            x = Math.max(sannerLine1(a, b, aStart, bStart + 1, curLine), sannerLine1(a, b, aStart + 1, bStart, curLine));
        }
        return Math.max(x, len);
    }

    /**
     * 即使使用记忆性递归+三维数组，还是超出时间限制，该题正确的思路应该是动态规划，线性dp.扎心了。
     * @param a
     * @param b
     * @param aStart
     * @param bStart
     * @param curLine
     * @param memory
     * @return
     */
    private static int sannerLine2(int[] a, int[] b, int aStart, int bStart, int curLine, int[][][] memory) {
        if (aStart >= a.length || bStart >= b.length) {
            return curLine;
        }
        if (memory[aStart][bStart][curLine] != 0) {
            return memory[aStart][bStart][curLine];
        }
        int len = curLine;
        int x = curLine;
        if (a[aStart] == b[bStart]) {
            len = sannerLine2(a, b, aStart + 1, bStart + 1, curLine + 1, memory);
        } else {
            x = Math.max(sannerLine2(a, b, aStart, bStart + 1, curLine, memory), sannerLine2(a, b, aStart + 1, bStart, curLine, memory));
        }
        int ans = Math.max(x, len);
        memory[aStart][bStart][curLine] = ans;
        return ans;
    }

}
