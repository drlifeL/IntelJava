package _算法竞赛入门经典._链表;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 移动小球
 * A X Y  表示把小球X移动到小球Y左边  BXY 表示把小球X移动到小球Y的右边
 * 小球从左到右编号：1-n  输入两个数  代表n 个小球和m条指令
 * 输出指令后的小球
 *
 * 切记：写函数时，不要把函数写死，要把函数写活，在传参上面做文章，而不是在函数内部进行文章
 *  该算法，是利用数组模拟，实际上在java中可以直接使用ArrayList来实现 ArrayList底层就是一个链表
 */
public class MoveBall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = init(n);
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String[] opt = sc.nextLine().split(" ");
            int x = Integer.parseInt(opt[1]);
            int y = Integer.parseInt(opt[2]);
            int p = search(arr,x);//小球x
            int q = search(arr, y);//小球y
            if (opt[0].equals("A")) {
                if(p<q){
                    move_left(arr,p,q-1);
                }else{
                    move_right(arr,q,p);
                }
            } else {
                if(p>q){
                    move_right(arr,q+1,p);
                }else{
                    move_left(arr,p,q);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 向右滑动
     * @param arr
     * @param p
     * @param q
     */
    private static void move_right(int[] arr, int p, int q) {
        int t = arr[q];
        for (int i = q; i >p ; i--) {
            arr[i] = arr[i-1];
        }
        arr[p] = t;
    }

    /**
     * 向左滑动
     * @param arr
     * @param p
     * @param q
     */
    private static void move_left(int[] arr, int p, int q) {
        int t = arr[p];
        for (int i = p; i <q ; i++) {
            arr[i] = arr[i+1];
        }
        arr[q] = t;
    }
    private static int search(int[] arr, int key) {

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==key){
                return i;
            }
        }
        return -1;
    }
    private static int[] init(int n) {
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;

    }
}
