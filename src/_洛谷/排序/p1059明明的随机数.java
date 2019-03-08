package _洛谷.排序;

import java.util.Scanner;

public class p1059明明的随机数 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        int arr[] = new int[1000];
        int max = 0;
        for (int i = 0; i <n ; i++) {
            int k = sc.nextInt();
            max = Math.max(max,k);
            if(arr[k]==0){
                arr[k]=1;
                ans++;
            }
        }
        System.out.println(ans);
        for (int i = 0; i <=max; i++) {
            if(arr[i]!=0){
                System.out.print(i+" ");
            }
        }
    }
}
