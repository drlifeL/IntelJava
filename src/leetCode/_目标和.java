package leetCode;

public class _目标和 {
    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 1, 1};
        int S = 3;
        findTargetSumWays(nums, S);
        System.out.println(ans);
    }

    static int ans = 0;

    public static int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0, 0, "");
        return ans;
    }

    public static void dfs(int[] nums, int S, int curSum, int index, String path) {
        if (S == curSum && index == nums.length) {
            System.out.println(path);
            ans++;
            return;
        }
        if (index == nums.length) return;


        dfs(nums, S, curSum+nums[index], index + 1, path + "+" + nums[index] + ",");//记住：传递状态的时候，切勿更新原状态，否则会造成异想不到的BUG

        dfs(nums, S, curSum-nums[index], index + 1, path + "-" + nums[index] + ",");

    }

}
