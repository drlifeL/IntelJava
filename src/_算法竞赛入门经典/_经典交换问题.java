package _算法竞赛入门经典;

/**
 * 定义变量a,b 交换ab的值并输出a  b
 * 但是一般的情况下，我们还是使用第三变量来进行交换，因为我们的重点在于解决问题。
 */
public class _经典交换问题 {
    public static void main(String[] args) {
        int a  = 10;
        int b  = 20;
        //1.第三变量交换
        int t = a;
        a = b;
        b = t;
        System.out.println(a+"::"+b);
        //2.如果值是int类型，或者说可以加减、利用加法和变量的性质
        a = 10;
        b = 20;
        a = a+b;
        b = a-b;//b已经变成a
        a = a-b;//
        System.out.println(a+"::"+b);
        System.out.println(111111*111111);

    }
}
