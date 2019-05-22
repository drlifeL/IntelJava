package _蓝桥;

import java.util.Arrays;
import java.util.Scanner;

public class _神奇的fans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            int t = sc.nextInt();
            int arr[] = new int[t];
            for (int i = 0; i < t; i++) {
                arr[i] = sc.nextInt();
            }
            if (arr.length < 2) {
                System.out.println("yes");
            } else {
                Arrays.sort(arr);
                int gc = arr[1] - arr[0];//先求公差
                boolean flag = true;
                for (int i = 2; i < arr.length; i++) {
                    if (!(arr[i] - arr[i - 1] == gc)) {
                        flag =false;
                        break;
                    }
                }
                if(flag){
                    System.out.println("yes");
                }else{
                    System.out.println("no");
                }
            }
            n--;
        }
    }
}
