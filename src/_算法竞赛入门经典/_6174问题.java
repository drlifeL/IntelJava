package _算法竞赛入门经典;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _6174问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> s = new HashSet<Integer>();
       while(true){
            if(s.add(n)) {
                System.out.println(n);
            }else{
                return;
            }
           n = get_next(n);
       }
    }

    /**
     * 将字符串排序并拆分
     * @param n
     */
    private static int get_next(int n) {
        String s= n+"";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(s.charAt(i)<s.charAt(j)){
                    s = swap(s.toCharArray(),i,j);
                }
            }
        }//顺序排好的s

        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        int a = Integer.parseInt(s);
        int b = Integer.parseInt(sb.toString());

        return a-b;

    }


    private static String swap(char[] s, int i, int j) {

        char a = s[i];
        s[i] = s[j];
        s[j] = a;
        String t = "";
        for (int k = 0; k < s.length; k++) {
            t+=s[k];
        }
        return t;
    }
}
