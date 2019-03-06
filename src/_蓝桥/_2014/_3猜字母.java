package _蓝桥._2014;

/**
 * 标题：猜字母
 *
 *     把abcd...s共19个字母组成的序列重复拼接106次，得到长度为2014的串。
 *
 *     接下来删除第1个字母（即开头的字母a），以及第3个，第5个等所有奇数位置的字母。
 *
 *     得到的新串再进行删除奇数位置字母的动作。如此下去，最后只剩下一个字母，请写出该字母。
 *
 *        答案是一个小写字母，请通过浏览器提交答案。不要填写任何多余的内容。
 */
public class _3猜字母 {
    /**
     * 采用快慢指针的思想
     * @param args
     */
    public static void main(String[] args) {
        char []list = new char[2014];
        int n = 0;
        for (int i = 0; i <106 ; i++) {
            for (int j = 0; j <19 ; j++) {
                list[n++] = (char)('a'+j);
            }
        }
        int len = 2014;
        int m = 0;//慢指针
        while(len!=1){
            m = 0;//注意..每次这个值需要被还原，否则数据的结构会发生错误
            //快指针每次移动两步
            for (int i = 1; i <=len ; i+=2) {
                list[m++] = list[i];
            }
            len = m;
        }
        System.out.println(list[0]);
    }
}
