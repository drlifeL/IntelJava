package _蓝桥._2015;

/**
 * 格子中输出
 * <p>
 * stringInGrid方法会在一个指定大小的格子中打印指定的字符串。
 * 要求字符串在水平、垂直两个方向上都居中。
 * 如果字符串太长，就截断。
 * 如果不能恰好居中，可以稍稍偏左或者偏上一点。
 * <p>
 * 下面的程序实现这个逻辑，请填写划线部分缺少的代码。
 * <p>
 * public static void stringInGrid(int width, int height, String s)
 * {
 * if(s.length()>width-2) s = s.substring(0,width-2);
 * System.out.print("+");
 * for(int i=0;i<width-2;i++) System.out.print("-");
 * System.out.println("+");
 * <p>
 * for(int k=1; k<(height-1)/2;k++){
 * System.out.print("|");
 * for(int i=0;i<width-2;i++) System.out.print(" ");
 * System.out.println("|");
 * }
 * <p>
 * System.out.print("|");
 * <p>
 * String ff = _______________________________________________________;  //填空
 * System.out.print(String.format(ff,"",s,""));
 * <p>
 * System.out.println("|");
 * <p>
 * for(int k=(height-1)/2+1; k<height-1; k++){
 * System.out.print("|");
 * for(int i=0;i<width-2;i++) System.out.print(" ");
 * System.out.println("|");
 * }
 * <p>
 * System.out.print("+");
 * for(int i=0;i<width-2;i++) System.out.print("-");
 * System.out.println("+");
 * }
 */
public class _格子中输出 {
    //该题考察的是对字符串API的使用,还有就是对%s的中间嵌套宽度的使用，如果不知道%s中间可以嵌套字符串的话，很坑！
    public static void main(String[] args) {
        stringInGrid(20, 6, "abcd1234");
    }

    public static void stringInGrid(int width, int height, String s) {
        if (s.length() > width - 2) s = s.substring(0, width - 2);
        System.out.print("+");
        for (int i = 0; i < width - 2; i++) System.out.print("-");
        System.out.println("+");

        for (int k = 1; k < (height - 1) / 2; k++) {
            System.out.print("|");
            for (int i = 0; i < width - 2; i++) System.out.print(" ");
            System.out.println("|");
        }

        System.out.print("|");
        /**
         *           % 和 d ,f ,s ,c之间可以有数字，表示精度或占有字符数。
         *           %10d 这个整数输出的时候，一般情况下，占用10个宽度。如果输出的整数位数小于10，左边加空格，空格和
         *                数字一共10个字符宽度。
         *           %-10d 同上一个。只不过当数字个数不足10个的时候右边补充空格，就是数字后边补充空格。
         *           %10.2f 表示一共10个有效数字，其中最多2个小数。
         *           %-10.2f 同上，但文字后面补充空格。
         *           %10s 字符串占有10个位置。
         */
        //主要考察的还是%s的使用,这里长知识了，%s中间可以加上int类型的数值，然后用format函数可以格式化输出
        String ff = "%" + (width - 2 - (s.length())) / 2 + "s%s%" + (width - 2 - (width - 2 - s.length()) / 2 - s.length()) + "s";  //填空
        System.out.print(String.format(ff, "", s, ""));

        System.out.println("|");

        for (int k = (height - 1) / 2 + 1; k < height - 1; k++) {
            System.out.print("|");
            for (int i = 0; i < width - 2; i++) System.out.print(" ");
            System.out.println("|");
        }

        System.out.print("+");
        for (int i = 0; i < width - 2; i++) System.out.print("-");
        System.out.println("+");
    }
}
