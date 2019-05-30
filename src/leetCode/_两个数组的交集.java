package leetCode;

import java.lang.reflect.Array;
import java.util.*;

public class _两个数组的交集 {
    public static void main(String[] args) {
        //[4,7,9,7,6,7]
        //[5,0,0,6,1,6,2,2,4]
        int[] nums1 = {4, 7, 9, 7, 6, 7}, nums2 = {5, 0, 0, 6, 1, 6, 2, 2, 4};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> s1 = new HashSet();
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                s1.add(nums2[i]);
            }
        }
        return s1.stream().mapToInt(Integer::intValue).toArray();
    }
}
