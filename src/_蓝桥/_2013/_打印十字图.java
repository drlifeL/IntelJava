package _蓝桥._2013;

import java.util.Scanner;

public class _打印十字图 {
    /**
     * 问题描述
     * 小明为某机构设计了一个十字型的徽标（并非红十字会啊），如下所示：
     *
     * ..$$$$$$$$$$$$$..
     * ..$...........$..
     * $$$.$$$$$$$$$.$$$
     * $...$.......$...$
     * $.$$$.$$$$$.$$$.$
     * $.$...$...$...$.$
     * $.$.$$$.$.$$$.$.$
     * $.$.$...$...$.$.$
     * $.$.$.$$$$$.$.$.$
     * $.$.$...$...$.$.$
     * $.$.$$$.$.$$$.$.$
     * $.$...$...$...$.$
     * $.$$$.$$$$$.$$$.$
     * $...$.......$...$
     * $$$.$$$$$$$$$.$$$
     * ..$...........$..
     * ..$$$$$$$$$$$$$..
     *
     * 对方同时也需要在电脑dos窗口中以字符的形式输出该标志，并能任意控制层数。
     *
     * 输入格式
     * 一个正整数 n (n<30) 表示要求打印图形的层数。
     * ---------------------
     * @param args
     */
    static int l = 0,r,k;
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        r = 9+(n*4)-4;
        char [][]  arr = new char[r][r];
        //把格子分成三个部分分别打印
        //头
        k = r-1;
        while(n!=0) {
            for (int i = l + 2; i < k - 1; i++) {
                arr[l][i] = '$';
                arr[k][i] = '$';
            }
            //头下一层
            arr[l + 1][l + 2] = '$';
            arr[l + 1][k - 2] = '$';
            arr[k - 1][l + 2] = '$';
            arr[k - 1][k - 2] = '$';
            //中间两层
            for (int i = l; i < l + 3; i++) {
                arr[l + 2][i] = '$';
                arr[l+2] [k-(i-l)] = '$';
                arr[k - 2][i] = '$';
                arr[k - 2][k -(i-l)] = '$';
            }

          for (int i = l+2; i <= k-2; i++) {
                arr[i][l] = '$';
                arr[i][k] = '$';
            }
            l += 2;
            k -= 2;
            n--;
        }
        //中间十字
        for (int i = l; i <=k ; i++) {
            arr[l+2][i]='$';
            arr[k-(i-l)][l+2] = '$';

        }
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr.length ; j++) {
                if(arr[i][j]!='$')
                    System.out.print(".");
                else
                    System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}

