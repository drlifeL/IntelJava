package _蓝桥;

public class Main {
    public static void main(String[] args) {

        System.out.println((int)'a');
        System.out.println("Hello World!");
        String s = "c";
        /**
         * compareTo用这个比较字符串的时候，如果当前串和比较串相等，则返回0 比较串b比当前串s大返回其正得差值，否则就是负数的插值
         */
        System.out.println(s.compareTo("b"));
        String s1 = "Hello";
        System.out.println(s1.substring(2));//从当前到最后
    }
}
