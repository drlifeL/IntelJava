package leetCode;

import org.omg.CORBA.INTERNAL;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _快乐数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        while (true) {
            int num = 0;
            while (n != 0) {
                num += (n % 10) * (n % 10);
                n /= 10;
            }
            n = num;
            if (num == 1) {
                System.out.println("Ok");
                break;
            }
            if (!set.add(n)) {
                System.out.println("no");
                break;
            }
        }

    }
}
