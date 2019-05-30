package leetCode;

import java.util.Arrays;

public class _最后一块石头的重量 {
    public static void main(String[] args) {
        int[] a = new int[]{2, 2, 3, 5, 7, 7, 8, 9, 10, 32};
        System.out.println(lastStoneWeight(a));
    }

    public static int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        Arrays.sort(stones);
        int len = stones.length;
        int i = len - 2; //x
        int j = len - 1; //y
        while (j >= 0 && i >= 0) {
            if (stones[i] == stones[j]) {
                i -= 2;
                j -= 2;
                len -= 2;

            } else {
                stones[i] = stones[j] - stones[i];
                i--;
                j--;
                len -= 1;
            }
            Arrays.sort(stones);
        }

        return len == 0 ? 0 : stones[0];
    }
}
