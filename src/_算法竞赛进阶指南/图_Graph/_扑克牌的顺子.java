package _算法竞赛进阶指南.图_Graph;

import java.util.Arrays;

public class _扑克牌的顺子 {
    public static void main(String[] args) {
        int randArr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int nums[] = new int[5];
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < 5; i++) {
                nums[i] = randArr[(int) (Math.random() * 12)];
            }
            System.out.println(Arrays.toString(nums));
            System.out.println(isContinues(nums));
        }
    }

    /**
     * 把题的思路整理清楚：
     * 其实题的不成立条件就两种，
     * 1.除0以外任何数不能有重复
     * 2.两张牌之间的数量差不能超过0的数量，每次要对大小王的数量进行迭代
     *
     * @param nums
     * @return
     */
    public static boolean isContinues(int[] nums) {
        if (nums.length != 5) return false;
        Arrays.sort(nums);
        int anyNums = 0;//表示大小王的数量
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                anyNums += 1;
            } else {
                if (nums[i] == nums[i + 1] || nums[i + 1] - nums[i] - 1 > anyNums) {
                    return false;
                }
                anyNums -= nums[i + 1] - nums[i] - 1;
            }
        }
        return true;
    }

}
