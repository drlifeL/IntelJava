package _蓝桥._2013;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _买不到的数目 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        //System.out.println(a*b-a-b);  用数学的思维可以直接得到答案

        int max = a*b;
        Set<Integer> set = new HashSet<Integer>();
        for (int x = 0; a*x <  max ; x++) {
            for (int y = 0; a*x+b*y<max ; y++) {
                set.add(a*x +b*y);//用不小于0的x和y与系数能组合出来的数加入set中
            }
        }

        for (int i = max-1; i >=0 ; i--) {
            if(!set.contains(i)){//查找第一个不在set中的值
                System.out.println(i);
                break;
            }
        }

    }
}
