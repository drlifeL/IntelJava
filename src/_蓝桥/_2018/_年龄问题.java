package _蓝桥._2018;

public class _年龄问题 {
    //i是丈夫，j是夫人
    public static void main(String[] args) {
        for (int i = 21; i < 100; i++) {
            for (int j = 21; j < 100; j++) {
                if ((i - 20) == (j - 20) * 2 && j * 1.5 == i) {
                    System.out.println(i + "z::f" + j);
                }
            }
        }
    }

}
