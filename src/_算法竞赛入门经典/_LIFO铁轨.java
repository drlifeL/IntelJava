package _算法竞赛入门经典;

import java.util.Scanner;

/**
 * Last in First out
 * 栈数据结构
 */
public class _LIFO铁轨 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = n; i >0 ; i--) {
            if(i!=arr[i-1]){
                System.out.println("No!");
                return ;
            }
        }
        System.out.println("yes!");
    }
}
