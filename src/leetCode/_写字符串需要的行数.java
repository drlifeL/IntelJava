package leetCode;
import java.util.Arrays;

public class _写字符串需要的行数 {
    public static void main(String[] args) {
        String s = "bbbcccdddaaa";
        int[] widths = new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        numberOfLines(widths, s);
    }

    /**
     *  读题不清，导致思路总体错误，还想成贪心，你是真的骄傲，我的哥。
     * @param widths
     * @param S
     * @return
     */
    public static int[] numberOfLines(int[] widths, String S) {
        int line = 1;
        int line_num = 0;
        int num;
        for(char c: S.toCharArray()){

            num = widths[(int)c-97];
            if(line_num+num<=100){
                line_num += num;
            }else {
                line+=1;
                line_num = num;
            }
        }

        int[] res = {line, line_num};
        return res;
    }

}
