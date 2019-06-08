package leetCode._数组;

public class _寻找数组的中心索引 {

    public static void main(String[] args) {
        int nums1[] = {-1, -1, -1, -1, 0, 1};//预期1
        int nums[] = {-1, -1, -1, 0, 1, 1};//预期0
        int nums2[] = {-1, -1, 0, 1, 1, 0};//预期5

//        [-1,-1,0,1,1,0]  预期5
        System.out.println(pivotIndex(nums2));

    }

    /**
     * 如果当前数组的长度小于2
     *
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        if (nums.length < 2) {
            return -1;
        }
        int left = 0;
        int right = init(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (left == right) return i;//如果左边等于右边，直接返回中间值
            //否则就左边加上中间值，右边减去中间值
            left += nums[i];
            right -= nums[i + 1];
        }
        return left == right ? nums.length - 1 : -1;
    }

    /**
     * 先计算右边的所有值，排除中间
     *
     * @param nums
     * @return
     */
    private static int init(int[] nums) {
        int sum = nums[1];
        for (int i = 2; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
