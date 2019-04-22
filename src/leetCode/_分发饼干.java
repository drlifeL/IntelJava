package leetCode;

import java.util.Arrays;

public class _分发饼干 {
    public static void main(String[] args) {
        int[] gi = {7,8,9,10};//孩子的胃口值
        int[] sj = {5,6,7,8};//饼干的尺寸
        //我们的是让饼干的尺寸和孩子的胃口尽量相等，即小孩子吃小饼干，大孩子吃大饼干
        System.out.println(findContentChildren(gi, sj));
    }

    public static int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0;
        int r = 0;
        while (l < g.length && r < s.length) {
            if (g[l] <= s[r]) {
                l++;
                ans++;
            }
            r++;
        }
        return ans;
    }

}
