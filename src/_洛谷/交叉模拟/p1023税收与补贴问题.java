package _洛谷.交叉模拟;

import java.util.Scanner;

/**
 * 1.价格越低，其销量就会相应增大
 * 2.已知某种商品的成本及其在若干价位上的销量
 * 3.假设相邻价位间销量的变化是线性的且在价格高于给定的最高价位后，销量以某固定数值递减,且都是整数
 * 4.已经知道政府对某种商品的预期价格，以及在各种价位上的销售情况。要求你确定政府对此商品是应收税还是补贴的最少金额（也为整数）
 * 才能使商家在这样一种政府预期的价格上，获取相对其他价位上的最大总利润。
 * 总利润=单位商品利润 × 销量
 *
 * 单位商品利润=单位商品价格 - 单位商品成本 （- 税金 or + 补贴）
 */
public class p1023税收与补贴问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();//政府对商品的预期价格
        int c = sc.nextInt();//商品成本
        int l = sc.nextInt();//以成本价销售时的销量
        while(true) {
            int n = sc.nextInt();//以其他价格销售的价格及销量
            int m = sc.nextInt();
            if(n==-1 && m==-1){
                break;
            }
        }
    }
}
