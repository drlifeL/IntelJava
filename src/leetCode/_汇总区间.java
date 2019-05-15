package leetCode;

import java.util.ArrayList;
import java.util.List;

public class _汇总区间 {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{1, 3, 5}));
    }

    /**
     * 双指针加游标解决
     *
     * @param nums
     * @return
     */
    public static List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<String>();
        }
        List<String> list = new ArrayList<>();
        if (nums.length == 1) {
            list.add(nums[0] + "");
            return list;
        }
        int head = 0;
        int tail = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 == nums[tail]) {
                tail++;
            } else {
                if (tail == head) {
                    list.add(nums[head] + "");
                } else {
                    list.add(nums[head] + "->" + nums[tail]);
                }
                head = tail + 1;
                tail++;
            }
            if (i == nums.length - 1) {
                if (tail == head) {
                    list.add(nums[head] + "");
                } else {
                    list.add(nums[head] + "->" + nums[tail]);
                }
            }
        }
        return list;
    }

}
