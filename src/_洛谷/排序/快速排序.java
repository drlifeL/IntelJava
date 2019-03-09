package _洛谷.排序;

import java.util.Arrays;
import java.util.Scanner;

public class 快速排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr [] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sort(0,arr.length-1,arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 	 快速排序模块代码：
     * 	 1.随机选择一个数作为中间数 k。
     * 	 2.双指针扫描，尾指针最先开始扫。如果当前尾指针的值h小于k,指针暂停
     * 	   头指针开始扫描数组,如果头指针l上当前的值大于k,指针要暂停，交换a[k][l]
     * 	 3.递归的调用排序每个部分。
     * 	 4.当l ==h 递归结束，整个数组就自然有序了
     *
     * 	 注意：需要考虑优化问题，第一种情况是如果一个数组本身就是有序的，且数量特别大的话(会造成栈溢出)
     * 	 需要重新考虑
     * @param lo
     * @param hi
     */
    public static void sort(int lo,int hi,int []a){
        if(lo >= hi){
            return;
        }
        int k = a[lo];
        int i = lo;
        int j = hi;
        while(i!=j){
            while(a[j]>=k && i<j){
                j--;
            }
            while(a[i]<=k && i<j){
                i++;
            }
            if(i<j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        //注意，这里是让这个和基准位置交换
        a[lo] = a[j];
        a[j] = k;
        sort(lo,i-1,a);
        sort(i+1,hi,a);
    }
}
