package _蓝桥;

import java.util.Scanner;

public class _不容易系列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            int sum = 3;
            int z = sc.nextInt();
            for (int i = z; i > 0; i--) {
                sum = (sum - 1) * 2;
            }
            System.out.println(sum);
            n--;
        }
    }


}
