package leetCode;

import java.util.Scanner;

/**
 * 问题描述：如果一个字符串包含两个相邻的重复子串，则称他为容易的串，其他串称为困难的串
 * 如：BB,ABCDACABCAB,ABCDABCD都是容易的,D,DC,ABDAB,CBABCBA都是困难的
 *
 * 输入正整数n,L，输出由前L个字符组成的，字典序第N小的困难的串
 * 例如：当L=3时，前7个困难的串分别为：
 * A,AB,ABA,ABAC,ABACA,ABACAB,ABACABA
 * n指定为4的话，输出ABAC
 *
 */
public class _困难的串 {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int l = sc.nextInt();
        dfs(l,n,"");

    }
    public static void dfs(int l,int n,String prefix){

        //尝试在prefix后追加一个字符
        for (char i = 'A'; i <'A'+l ; i++) {
            if(isHard(prefix,i)){//是困难的串，就组合起来输出
                String x = prefix + i;
                System.out.println(x);
                count++;
                if(count==n){
                   System.exit(0);
                }
                dfs(l,n,x);
            }
        }
    }

    /**
     * 判断prefix+i 是否一个困难的串
     * 1.遍历所有的长度为偶数的子串，看是否对称
     * 2.prefix是一个困难的串
     * @param prefix
     * @param i
     * @return
     */
    private static boolean isHard(String prefix, char i) {
        int count = 0;//截取的宽度
        for (int j = prefix.length()-1; j >=0 ; j-=2) {
            final String s1 = prefix.substring(j,j+count+1);
            final String s2 = prefix.substring(j+count+1)+i;
            if(s1.equals(s2))
                return false;
            count++;
        }
        return true;
    }

}
