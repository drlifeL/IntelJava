package _蓝桥._2014;

/**
 * 1.两个人年龄相差不超过8岁
 * 2.年龄的积是和的6倍
 * 3.输出较小的
 */
public class _1猜年龄 {
    public static void main(String[] args) {
        for (int i = 1; i <20 ; i++) {
            for (int j = 1; j <20 ; j++) {
                if(i>j && i*j==(i+j)*6){
                    System.out.println(i+" "+j);
                }
            }
        }
    }
}
