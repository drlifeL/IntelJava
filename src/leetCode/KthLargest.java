package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthLargest {

    List<Integer> list = new ArrayList<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
    }

    public int add(int val) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= val) {
                list.add(i, val);
                System.out.println(list);
                return list.get(k);
            }
        }
        list.add(val);
        System.out.println(list);
        return list.get(k);
    }
}
