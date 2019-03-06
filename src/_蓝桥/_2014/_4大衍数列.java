package _蓝桥._2014;

/**
 * 标题：大衍数列
 * <p>
 *     中国古代文献中，曾记载过“大衍数列”, 主要用于解释中国传统文化中的太极衍生原理。
 * <p>
 *     它的前几项是：0、2、4、8、12、18、24、32、40、50 ...
 * <p>
 *     其规律是：对偶数项，是序号平方再除2，奇数项，是序号平方减1再除2。
 * <p>
 *     以下的代码打印出了大衍数列的前 100 项。
 * <p>
 * for(int i=1; i<100; i++)
 * {
 *     if(________________)  //填空
 *         System.out.println(i*i/2);
 *     else
 *         System.out.println((i*i-1)/2);
 * }
 */

public class _4大衍数列 {
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0) //填空
                System.out.println(i * i / 2);
            else
                System.out.println((i * i - 1) / 2);
        }
    }
}
