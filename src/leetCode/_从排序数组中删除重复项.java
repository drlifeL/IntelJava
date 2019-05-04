package leetCode;

import java.util.Arrays;

public class _从排序数组中删除重复项 {
    public static void main(String[] args) {
        int[] nums = {1,1};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 相等的情况下，尾指针动，不相等的情况下 front+1 与 tail交换
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1 || nums.length == 2) {
            return 1;
        }
        int front = 0;
        int tail = 1;
        while (tail != nums.length) {
            if (nums[front] != nums[tail]) {
                nums[front + 1] = nums[tail];
                front++;
            }
            tail++;
        }
        return front + 1;
    }

}
