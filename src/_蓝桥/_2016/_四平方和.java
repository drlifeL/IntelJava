package _蓝桥._2016;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 枚举加优化
 * 假设变量为a b c d
 * 首先缓存cd 逆推ab
 * AC....
 */
public class _四平方和 {
    static int N;
    static Map<Integer,Integer> cache = new HashMap<Integer,Integer>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N  = sc.nextInt();
        for (int c = 0; c*c <=N/2 ; c++) {
            for (int d = c; c*c+d*d <=N ; d++) {
                if(cache.get(c*c+d*d)==null){
                    cache.put(c*c+d*d,c);
                }
            }
        }

        for (int a = 0; a*a <=N/4 ; a++) {
            for (int b = a; a*a+b*b <=N/2 ; b++) {
               if(cache.get(N-a*a-b*b)!=null) {
                   int c = cache.get(N-a*a-b*b);
                   int d = (int)Math.sqrt(N-a*a-b*b-c*c);
                   System.out.printf("%d %d %d %d\n",a,b,c,d);
                   return;
               }
            }
        }
    }
}
