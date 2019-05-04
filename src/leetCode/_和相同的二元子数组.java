package leetCode;

public class _和相同的二元子数组 {
    public static void main(String[] args) {
        int[] A = {1, 0, 1, 0, 1};

        int S = 2;
        System.out.println(numSubarraysWithSum(A,S));
        System.out.println(ans);
    }

    static int ans = 0;

    /**
     * 该题是dfs的一个变种，不能直接用选和不选来生成非空子数组，子数组的
     * @param A
     * @param S
     * @return
     */
    public static int numSubarraysWithSum(int[] A, int S) {

        return dfs(A, S, 0);
    }

    private static int dfs(int[] a, int s, int i) {
        if (i == a.length || s < 0) return 0;
        if (s == 0) {
            ans++;
        }
        return Math.max(dfs(a, s - a[i], i + 1), dfs(a, s, i + 1));
    }
}
