package _蓝桥._2015;

/**
 * 该题目的解法多样，首先要注意的就是数据会溢出，
 * 1.将该值得三次方运算后，把运算后的数值转换成字符串同当前数值进行比较，转换的时候，用立方的字符串.subString()减去该数转换的字符串，然后equals运算
 * 2.也可以直接分类求余同i比较  如果i<10 对10取余，小于100，对100取余，...
 */
public class 立方尾不变 {
    public static void main(String[] args) {
        int ans = 0;
        for (long i = 1; i < 10000; i++) {
            if(i<10 && i*i*i%10==i){
                ans++;
            }else if(i<100 &&i*i*i%100==i){
                ans++;
            }else if(i<1000 &&i*i*i%1000==i){
                ans++;
            }else if(i<10000 &&i*i*i%10000==i){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
