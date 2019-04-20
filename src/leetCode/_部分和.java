package leetCode;

import java.util.ArrayList;

/**
 * 给定整数序列 a1...an，判断是否可以从中选取若干数，使他们的和恰好为l
 * <p>
 * 1<=n<=20
 * -10^8<=ai<=10^8
 * -10^8<=k<=10^8
 */
public class _部分和 {
    public static void main(String[] args) {
        int nums[] = {1, 8, 4, 7, 5};
        dfs(nums, 0, 13, 0, "");
        System.out.println("------------------");
        dfs(nums, 13, 0, "");
        System.out.println("--------------------");
        dfs(nums,13,0,new ArrayList<>());
    }

    public static void dfs(int[] nums, int curSum, int k, int index, String path) {

        if (curSum == k) {
            System.out.println(k + "=" + path.substring(0, path.length() - 1));
            return;
        }
        if (index >= nums.length) return;
        dfs(nums, curSum + nums[index], k, index + 1, path + nums[index] + "+");

        dfs(nums, curSum, k, index + 1, path);
    }

    //少传递一个参数
    public static void dfs(int[] nums, int k, int index, String path) {

        if (k == 0) {
            System.out.println(13 + "=" + path.substring(0, path.length() - 1));
            return;
        }
        if (index >= nums.length || k < 0) return;
        dfs(nums, k, index + 1, path);

        dfs(nums, k - nums[index], index + 1, path + nums[index] + "+");
    }

    //使用引用数据传参
    public static void dfs(int[] nums, int k, int index, ArrayList<Integer> ints) {
        if (k == 0) {
            System.out.print(13+"=");
            for (int i = 0; i < ints.size(); i++) {
                System.out.print(ints.get(i) + (i == ints.size() - 1 ? "" : "+"));
            }
            System.out.println();
            return;
        }
        if (index >= nums.length || k < 0) return;
        //不选的的时候直接传递
        dfs(nums, k, index + 1, ints);
        //要选的话，直接在这里加上以后传递到下一个函数继续递归，
        ints.add(nums[index]);
        int idex = ints.size() - 1;
        dfs(nums, k - nums[index], index + 1, ints);
        ints.remove(idex);//回溯
    }

}
