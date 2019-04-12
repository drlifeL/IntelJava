package 算法4._子字符串查找;

public class _子字符串暴力查找 {
    /**
     * 暴力子字符串查找
     *
     * @param pat
     * @param txt
     * @return 在不匹配的时候返回N的值，匹配的时候返回他的具体位置
     */
    public static int search(String pat, String txt) {
        //在txt中查找pat
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i <= N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            }
            if (j == M)
                return i;//找到匹配
        }
        return -1;//未找到匹配
    }

    /**
     * 改进版本暴力查找算法
     *
     * @param pat
     * @param txt
     * @return
     */
    public static int serarchDemo(String pat, String txt) {
        int i, M = txt.length();
        int j, N = pat.length();
        for (i = 0, j = 0; i < M && j < N; i++) {
            if (pat.charAt(j) == txt.charAt(i)) {//匹配则相加
                j++;
            } else {//如果不匹配，回溯i,j
                i -= j;
                j = 0;
            }
        }
        if (j == N) {//找到匹配
            return i - j;
        }

        return -1;
    }

    public static void main(String[] args) {
        String b = "ABACADABRAC";
        String a = "E";
        System.out.println(search(a, b));
        System.out.println(serarchDemo(a, b));
    }

}
