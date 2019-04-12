package 算法4._子字符串查找;

/**
 * KMP中使用next数组的形式来实现
 */
public class KMP_Next {
    public static void main(String[] args) {
        String s = "AABRAACADABRAACAADABRA";
        String p = "AACAA";
        System.out.println(indexOf(s, p));
        System.out.println(indexOf2(s, p));
    }

    /**
     * KMP算法 在串s中寻找p
     *
     * @param s
     * @param p
     * @return
     */
    public static int indexOf(String s, String p) {
        if (s.length() == 0 || p.length() == 0) return -1;//如果二者中任意一个长度为0直接退出
        if (p.length() > s.length()) return -1;//如果子串的长度已经超过了本串，直接退出
        int[] next = next(p);//计算next数组
        int i = 0;//s位置
        int j = 0;//p位置
        int sLen = s.length();
        int pLen = p.length();

        while (i < sLen) {
            //如果 j==-1.或者当前字符串匹配成功 即s[i]==p[j] 都令i++,j++;
            //j=-1,因为next[0] = -1;说明p的第一位和i这个位置无法匹配，这是i,j都增加1 i移位，j从0开始
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                //如果 j != -1 ，且当前字符串匹配失败 （即s[i] != p[j]），则令i不变， j = next[j]
                //next[j] 即为j所对应的next值
                j = next[j];
            }
            if (j == pLen) {//匹配成功了
                return (i - j);
            }
        }
        return -1;
    }

    public static int indexOf2(String s, String p) {
        if (p.length() == 0 || s.length() == 0) return -1;
        if (p.length() > s.length()) return -1;
        int[] next = next1(p);
        int i = 0;
        int j = 0;
        int pLen = p.length();
        int sLen = s.length();


        while (i < sLen) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == pLen) {
                return (i - j);
            }
        }
        return -1;
    }

    /**
     * 推导出next数组（核心）
     *
     * @param ps
     * @return
     */
    private static int[] next(String ps) {
        int pLength = ps.length();
        int[] next = new int[pLength];
        char[] p = ps.toCharArray();
        next[0] = -1;//第一位都为-1
        if (ps.length() == 1)//提前判断，如果匹配串只有一位字符的话，就没有必须初始化第二个
            return next;
        next[1] = 0;//第二位都是0

        int j = 1;//通过前面两位推出第三位
        int k = next[j];//看看位置j的最长匹配前缀在哪里

        while (j < pLength - 1) {
            //现在要推出next[j+1],检查j和k位置上的关系即可
            if (k < 0 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
    private static int[] next1(String ps) {
        int pLength = ps.length();
        int[] next = new int[pLength];
        char[] p = ps.toCharArray();
        next[0] = -1;
        if (pLength == 1) return next;
        next[1] = 0;
        int j = 1;
        int k = next[j];
        while (j < pLength - 1) {
            if (k < 0 || p[j] == p[k]) {
                next[++j] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;

    }






}
