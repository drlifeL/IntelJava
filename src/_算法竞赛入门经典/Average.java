package _算法竞赛入门经典;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();

        BigDecimal b1 = new BigDecimal(b);
        BigDecimal b2 = new BigDecimal(c);
        BigDecimal b3 = new BigDecimal(d);
        b1 = b1.add(b2).add(b3);
        System.out.println(b1.divide(new BigDecimal(3),3, RoundingMode.HALF_UP));
    }
}
