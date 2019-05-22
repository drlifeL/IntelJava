package _蓝桥._贪心;

import java.util.Scanner;

public class _发工资了 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.nextInt();
        int arr[] = new int[]{100, 50, 10, 5, 2, 1};
        int num = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = a[i];
            for (int j = 0; j < arr.length; j++) {
                if (sum == 0) break;
                if (arr[j] > sum) continue;
                num += sum / arr[j];
                sum = sum % arr[j];
            }
        }
        System.out.println(num);

    }
}
