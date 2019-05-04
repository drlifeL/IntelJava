package _蓝桥;

import java.util.Scanner;

public class _队列操作 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[55];
        int first = 0;
        int last = 0;
        for (int i = 0; i < n; i++) {
            int in = sc.nextInt();
            if(in==1){
                arr[last++] = sc.nextInt();
            }
            if(in==2){
                if(first==last){
                    System.out.println("no");
                    return;
                }else{
                    System.out.println(arr[first++]);
                }
            }
            if(in==3){
                System.out.println(last-first);
            }
        }
    }
}
