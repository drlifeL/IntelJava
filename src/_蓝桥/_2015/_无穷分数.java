package _蓝桥._2015;

import java.math.BigDecimal;
import java.math.BigInteger;

public class _无穷分数 {
    public static void main(String[] args) {
        BigDecimal fn = new BigDecimal(BigInteger.ONE);
        for (int i = 1000; i >=1 ; i--) {
            BigDecimal ii = new BigDecimal(BigInteger.valueOf(i));
            fn = ii.divide(fn.add(ii),6,BigDecimal.ROUND_HALF_UP);
        }
        System.out.println(fn.toString());
    }
}
