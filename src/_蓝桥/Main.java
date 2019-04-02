package _蓝桥;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
            System.out.println((int)'a');
            System.out.println("Hello World!");
            String s = "c";

             * compareTo用这个比较字符串的时候，如果当前串和比较串相等，则返回0 比较串b比当前串s大返回其正得差值，否则就是负数的插值

            System.out.println(s.compareTo("b"));
            String s1 = "Hello";
            System.out.println(s1.substring(2));//从当前到最后

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char []a = s.toCharArray();
        f(a,0,a.length);
         */
//        System.out.println(new BigDecimal(5.55).toString());
//        System.out.println(new BigDecimal(5.55).toPlainString());
//        System.out.println(Math.abs(5-6));
//        System.out.println(Math.abs(6-5));
        System.out.println('A'^32);//直接可以使用大小写转换
        System.out.println('a'^32);
        String s = "a";
        String s1  = "a";
        System.out.println(s1.compareTo(s));


    }

    private static void f(char []c,int i,int j) {
        if(i==j){
            System.out.println(Arrays.toString(c));
            return;
        }
        for (int k = i; k < j; k++) {
            swap(k,i,c);
            f(c,i+1,j);
            swap(k,i,c);
        }
    }

    private static void swap(int i, int j, char[] c) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
}
