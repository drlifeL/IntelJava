package leetCode;

import java.util.Arrays;

public class _至少有K个重复字符的最长子串 {
    /*
    "abcdedghijklmnopqrstuvwxyz"
2
     */

    public static void main(String[] args) {
        System.out.println(longestSubstring("ababacb", 3));
        slove("abcdedghijklmnopqrstuvwxyz", 2);
        System.out.println(ans);
    }

    /**
     * 阅读问题出错，没有找到想求的到底是什么
     * 其实该题真实需要求的是在子串T中的所有字符均满足>=k ，我却
     * 错误的理解为满足k个字符的字母有多少个
     * <p>
     * 该题参照大佬的解法：核心思想：如果字母存在x小于k,那么x是不可能出现在T中
     * 因此，问题就变成了，对x左边串和x右边串求解的过程....
     */
    public static int longestSubstring(String s, int k) {
        if (s.equals("") && s.length() == 0) {
            return 0;
        }
        int ans = 0;
        char[] str = s.toCharArray();
        if (str.length == 1) {
            return k == 1 ? 1 : 0;
        }
        char t = str[0];
        int len = 1;
        for (int i = 1; i < str.length - 1; i++) {
            if (t == str[i]) {
                len++;
            } else {
                if (len >= k) {
                    ans += len;
                }
                t = str[i];
                len = 1;
            }
        }
        len = str[str.length - 1] == str[str.length - 2] ? len + 1 : len;
        ans = len >= k ? (ans + len) : ans;
        return ans;
    }

    static int ans = 0;

    /**
     * 还是会超时.....
     * @param s
     * @param k
     * @return
     */
    public static int slove(String s, int k) {
        char[] a = s.toCharArray();
        int[] len = new int[26];
        for (int i = 0; i < s.length(); i++) {
            len[a[i] - 'a']++;
        }
        boolean flag = true;
        for (int i = 0; i < len.length; i++) {
            if (len[i] < k && len[i] != 0) {
                flag = false;
                char t = (char) (i + 97);
                int index = s.indexOf(t + "");
                slove(s.substring(0, index), k);
                slove(s.substring(index + 1), k);
            }
        }
        if (flag) {
            ans = ans>s.length()?ans:s.length();
        }
        return ans;
    }


}
