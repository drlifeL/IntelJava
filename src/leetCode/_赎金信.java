package leetCode;

public class _赎金信 {
    public static void main(String[] args) {
        System.out.println(canConstruct("aac", "aab"));
    }

    /**
     * 题意：能不能通过B串来构建A串
     *
     * @param ransonNode
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransonNode, String magazine) {
        char[] a = ransonNode.toCharArray();

        char[] b = magazine.toCharArray();

        int[] charNum = new int[26];
        for (int i = 0; i < b.length; i++) {
            charNum[(b[i] - 'a')]++;
        }

        for (int i = 0; i < a.length; i++) {
            charNum[a[i] - 'a'] -= 1;
            if (charNum[a[i] - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
