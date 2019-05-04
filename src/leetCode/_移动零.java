package leetCode;

import java.util.Arrays;

public class _移动零 {
    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        moveZeroesToLast(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 将0移动到最前面
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int front = 0;
        int tail = 1;
        while (tail != nums.length) {
            if (nums[tail] == 0) {
                int t = tail;
                while (t > front) {
                    nums[t] = nums[t - 1];
                    t--;
                }
                nums[front++] = 0;
            }
            tail++;
        }
    }

    public static void moveZeroesToLast(int[] nums) {
        int front = 0;
        int tail = nums.length - 1;
        while (front != tail) {
            if (nums[front] == 0) {
                int t = front;
                while (t < tail) {
                    nums[t] = nums[t + 1];
                    t++;
                }
                nums[tail--] = 0;
            }
            if (nums[front] != 0)
                front++;
        }
    }
}
