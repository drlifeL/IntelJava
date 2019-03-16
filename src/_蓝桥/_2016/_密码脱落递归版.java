package _蓝桥._2016;

import java.util.Scanner;

/**
 * 此版本只能适合部分数据
 * 不能得到满分，但可以记录下，给自己思路
 */
public class _密码脱落递归版 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int ans = f(str,0,str.length()-1,0);
        System.out.println(ans);
    }

    /**
     * 可以把整体想象成一颗二叉树
     * 第一次判断有两种结果，要么相等，要么不相等
     * 相等则左边指针+1，右边-1，
     * 不相等：又有两种可能，要么是左边指针不动，右边加1.要么右边不动，左边加1.依次递归
     * @param s1
     * @param left
     * @param right
     * @param count
     * @return
     */
    private static int f(String s1, int left, int right, int count) {
        if(left>=right){
            return count;
        }
        if(s1.charAt(left)!=s1.charAt(right)){
            return Math.min(f(s1,left+1,right,count+1),f(s1,left,right-1,count+1));
        }else{
            return f(s1,left+1,right-1,count);
        }

    }
}
