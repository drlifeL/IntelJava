package _洛谷.字符串;

import java.util.Scanner;

/**
 * 基于桶排序的柱状图
 * AC的感觉太舒服了，昨天才看完这个桶排序，今天就用上了
 * 思路：构建一个26长度的一维数组，将每个数字的数量读入到数组对应的元素下标中
 *      拿到数组中最大的值，做为列循环。复制一个最大数，用于递减 然后双层循环，外层是max内层是26，
 *      如果当前值大于0 并且等于当前最大值，就输入* 然后t要进行递减，否则就输出"  "内层循环完一次 .最大值要递减，依次即可构建
 *      最后在来一层循环打印下面的26个字母  Ac
 */
public class p1598垂直柱状图 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String []arr = new String [4];//存放输入的字符串
        arr[0] = sc.nextLine();
        arr[1] = sc.nextLine();
        arr[2] = sc.nextLine();
        arr[3] = sc.nextLine();
        int []t = new int[26];
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <arr[i].length() ; j++) {
                if(arr[i].charAt(j)-65 >=0 && arr[i].charAt(j)-65<=25){
                    t[arr[i].charAt(j)-65]+=1;
                }
            }
        }
        int max  = ArrMax(t);
        int n = max;
        for (int i = 0; i <max ; i++) {
            for (int j = 0; j <26 ; j++) {
                    if(t[j]>0 && t[j]==n){
                        System.out.print("* ");
                        t[j]--;
                    }else{
                        System.out.print("  ");
                    }
            }
            n--;
            System.out.println();
        }
        for (char i = 'A'; i <='Z' ; i++) {
            System.out.print(i+" ");
        }
    }

    private static int ArrMax(int[] arr) {
        int temp = 0;
        for (int i = 0; i <arr.length ; i++) {
            temp = Math.max(temp,arr[i]);
        }
        return temp;
    }
}
