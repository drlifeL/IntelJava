package leetCode._数组;

import java.util.Arrays;

public class _加一 {
    public static void main(String[] args) {
        int[] nums = {9, 9, 9};
        nums = plusOne(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] plusOne(int[] nums) {
        boolean flag = true;
        for (int i = (nums.length - 1); i >= 0 && flag; i--) {
            if (nums[i] != 9) {
                nums[i] += 1;
                flag = false;
            } else {
                nums[i] = 0;
            }
        }
        if (flag) {
            int[] newNums = new int[nums.length + 1];
            newNums[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                newNums[i] = nums[i - 1];
            }
            return newNums;
        }

        return nums;
    }
}
