package leetCode;

import java.util.Arrays;

/**
 * 特殊案例，没有通过，思路存在问题 130/174
 */
public class _火柴棍拼正方形 {
    public static void main(String[] args) {
        int[] nums = {5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3};
        System.out.println(makesquare(nums));

    }

    /**
     * 先对数组进行排序，然后传递最大值
     *
     * @param nums
     * @return
     */
    public static boolean makesquare(int[] nums) {
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            flag = dfs(nums, sum, 1, i, sum);
            if (flag) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param nums
     * @param edgeMax  最大一条边的值
     * @param edgeNum  当前一共有几条边
     * @param curIndex 当前的坐标是在哪里
     * @param curValue 当前这条边的值
     * @return
     */
    public static boolean dfs(int[] nums, int edgeMax, int edgeNum, int curIndex, int curValue) {
        if (edgeNum == 4 && curIndex == nums.length - 1) {
            return true;
        }
        if (curIndex == nums.length) {
            return false;
        }
        boolean flag = false;
        boolean flag1 = false;
        if (curValue > edgeMax) {//如果当前边的值已经大于最大一条边的值，那么不可能构成一个正方形
            return false;
        }
        if (curValue < edgeMax && curIndex + 1 < nums.length) {
            flag = dfs(nums, edgeMax, edgeNum, curIndex + 1, nums[curIndex + 1] + curValue);
        }
        if (curValue == edgeMax && curIndex + 1 < nums.length) {
            flag1 = dfs(nums, edgeMax, edgeNum + 1, curIndex + 1, nums[curIndex + 1]);
        }
        return flag1 || flag;
    }

}
