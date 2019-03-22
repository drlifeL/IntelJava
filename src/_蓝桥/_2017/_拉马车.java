package _蓝桥._2017;
/**
 * 标题：拉马车
 * 小的时候，你玩过纸牌游戏吗？
 * 有一种叫做“拉马车”的游戏，规则很简单，却很吸引小朋友。
 * 其规则简述如下：
 * 假设参加游戏的小朋友是A和B，游戏开始的时候，他们得到的随机的纸牌序列如下：
 * A方：[K, 8, X, K, A, 2, A, 9, 5, A]
 * B方：[2, 7, K, 5, J, 5, Q, 6, K, 4]
 *
 * 其中的X表示“10”，我们忽略了纸牌的花色。
 *
 * 从A方开始，A、B双方轮流出牌。
 *
 * 当轮到某一方出牌时，他从自己的纸牌队列的头部拿走一张，放到桌上，并且压在最上面一张纸牌上（如果有的话）。
 *
 * 此例中，游戏过程：
 * A出K，B出2，A出8，B出7，A出X，此时桌上的序列为：
 *
 * K,2,8,7,X
 *
 * 当轮到B出牌时，他的牌K与桌上的纸牌序列中的K相同，则把包括K在内的以及两个K之间的纸牌都赢回来，放入自己牌的队尾。注意：为了操作方便，放入牌的顺序是与桌上的顺序相反的。
 * 此时，A、B双方的手里牌为：
 * A方：[K, A, 2, A, 9, 5, A]
 * B方：[5, J, 5, Q, 6, K, 4, K, X, 7, 8, 2, K]
 *
 * 赢牌的一方继续出牌。也就是B接着出5，A出K，B出J，A出A，B出5，又赢牌了。
 * 5,K,J,A,5
 * 此时双方手里牌：
 * A方：[2, A, 9, 5, A]
 * B方：[Q, 6, K, 4, K, X, 7, 8, 2, K, 5, A, J, K, 5]
 *
 *     注意：更多的时候赢牌的一方并不能把桌上的牌都赢走，而是拿走相同牌点及其中间的部分。但无论如何，都是赢牌的一方继续出牌，有的时候刚一出牌又赢了，也是允许的。
 *
 *     当某一方出掉手里最后一张牌，但无法从桌面上赢取牌时，游戏立即结束。
 *
 *     对于本例的初始手牌情况下，最后A会输掉，而B最后的手里牌为：
 *
 * 9K2A62KAX58K57KJ5
 *
 *     本题的任务就是已知双方初始牌序，计算游戏结束时，赢的一方手里的牌序。当游戏无法结束时，输出-1。
 *
 * 输入为2行，2个串，分别表示A、B双方初始手里的牌序列。
 * 输出为1行，1个串，表示A先出牌，最后赢的一方手里的牌序。
 *
 * 例如，
 * 输入：
 * 96J5A898QA
    6278A7Q973
 *
 * 则程序应该输出：
 * 2J9A7QA6Q6889977
 * 再比如，
 * 输入：
 * 25663K6X7448
 * J88A5KJXX45A
 * 则程序应该输出：
 * 6KAJ458KXAX885XJ645
 *
 * 我们约定，输入的串的长度不超过30
 */

import java.util.Scanner;

/**
 * 该题我们可以直接对这道题进行字符串字面意思的操作，直接模拟程序实现，但是要注意，这里我们尽量使用StringBuilder 因为这样可以减少我们不断操作字符串的负担、
 */
public class _拉马车 {
    static StringBuilder A;
    static StringBuilder B;
    static StringBuilder C = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = new StringBuilder(sc.nextLine());
        B = new StringBuilder(sc.nextLine());
        boolean flagA = true;
        boolean flagB = false;

        while (true){
            if(flagA){
                flagA = op(A,C);
                if(A.length()==0){//如果该字符串已经被取完了
                    System.out.println(B);
                    break;
                }
                flagB = !flagA;//取反操作，如果A为true,B为false;如果B为false，A为true
            }
            if (flagB){
                flagB = op(B,C);
                if(B.length()==0){
                    System.out.println(A);
                    break;
                }
                flagA = !flagB;
            }
        }

    }

    /**
     * 取字符和判断是否出牌操作
     * @param x
     * @param y
     * @return
     */
    private static boolean op(StringBuilder x, StringBuilder y) {

        char t = x.charAt(0);//取出字符串的第一个字符
        int index = y.indexOf(t+"");//查出该字符串的索引
        boolean ans = true;//定义返回值
        if(index!=-1){//如果该字符存在
            x.append(t);//将字符加入到x中
            x.append(y.toString().substring(0,index+1));//将序列中的字符串截取出来并添加到x中国
            y.delete(0,index+1);//删掉刚刚截取的字符串
        }else{//如果该字符不存在序列中
            y.insert(0,t);//将他插入到序列中
            ans = false;//换人出牌
        }
        x.delete(0,1);//删掉第一个字符
        return ans;
    }

}
