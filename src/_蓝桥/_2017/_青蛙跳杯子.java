package _蓝桥._2017;

import java.util.*;

/**
 * 标题：青蛙跳杯子

 * X星球的流行宠物是青蛙，一般有两种颜色：白色和黑色。
 * X星球的居民喜欢把它们放在一排茶杯里，这样可以观察它们跳来跳去。
 * 如下图，有一排杯子，左边的一个是空着的，右边的杯子，每个里边有一只青蛙。

 * WWWBBB

 * 其中，W字母表示白色青蛙，B表示黑色青蛙，*表示空杯子。

 * X星的青蛙很有些癖好，它们只做3个动作之一：
 * 1. 跳到相邻的空杯子里。
 * 2. 隔着1只其它的青蛙（随便什么颜色）跳到空杯子里。
 * 3. 隔着2只其它的青蛙（随便什么颜色）跳到空杯子里。

 * 对于上图的局面，只要1步，就可跳成下图局面：

 * WWW*BBB

 * 本题的任务就是已知初始局面，询问至少需要几步，才能跳成另一个目标局面。

 * 输入为2行，2个串，表示初始局面和目标局面。
 * 输出要求为一个整数，表示至少需要多少步的青蛙跳。

 * 例如：
 * 输入：
 * WWBB
 * WWBB*

 * 则程序应该输出：
 * 2

 * 再例如，
 * 输入：
 * WWW*BBB
 * BBB*WWW

 * 则程序应该输出：
 * 10

 * 我们约定，输入的串的长度不超过15

 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 1000ms
 */
public class _青蛙跳杯子 {
    private static class StateAndLevel {
        int post;//当前星号的坐标
        StringBuilder state;//当前的状态
        int level;//当前的步数

        public StateAndLevel(StringBuilder state, int post, int level) {
            this.post = post;
            this.state = state;
            this.level = level;
        }
    }

    static Set<String> result = new HashSet<String>();
    static StringBuilder state;
    static StringBuilder target;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        state = new StringBuilder(sc.nextLine());
        target = new StringBuilder(sc.nextLine());

        bfs();

    }

    private static void bfs() {
        Queue<StateAndLevel> queue = new LinkedList<StateAndLevel>();//创建一个队列
        queue.add(new StateAndLevel(state, state.indexOf("*"), 0));//将第一个状态加入队列
        result.add(state.toString());//将第一次的状态也加入到集合中，为了去重
        while (!queue.isEmpty()) {
            StateAndLevel temp = queue.poll();//将第一个元素出队，并缓存下来
            /**
             * 还有对于可以重复使用的变量，预定义一些局部变量来记录他们，这样可以利用代码的阅读性
             * 而且，自己对于变量的命名现在也是很恼火，导致容易出问题，希望在以后的代码书写中注意
             */
            for (int i = -3; i <= 3; i++) {//将他可以演变的状态的循环的加入队列
                if (i == 0) continue;
                StateAndLevel new_State1 = temp;//拷贝出队的状态

                StringBuilder sb = new_State1.state;

                int pos = new_State1.post;

                int l = new_State1.level;

                if (sb.toString() .equals( target.toString())) {
                    System.out.println(l);
                    return;
                }

                if (pos + i >= 0 && pos + i < sb.length()) {//如果不越界的情况。我们就交换情况，越界情况这里，自己犯了一个大的错误。 错误的将可演变状态放在这里来了，导致了问题半天没解决

                    sb = swap(sb, pos, pos + i);//进行交换，生成结果

                    if (!result.contains(sb.toString())) {
                        result.add(sb.toString());//结果加入集合

                        queue.add(new StateAndLevel(sb, pos+i, l + 1));//加进去的时候，必须把步数和位置信息进行变化

                    }
                }
            }
        }

    }

    /**
     * 该方法看出了自己对于StringBuilder的API的不熟悉
     * 这里面，除了可以按照下面定义的方法来对状态进行变更以外，还可以使用API来解决
     * 首先拿到一个字符
     * 调用StringBuilder的setChar(要变成的样子，索引)，传递参数，就可以实现替换。
     * temp = state.charAt(i)
     *
     * @param state
     * @param i
     * @param post
     * @return
     */
    private static StringBuilder swap(StringBuilder state, int i, int post) {

        char[] a = state.toString().toCharArray();
        char t = a[i];
        a[i] = a[post];
        a[post] = t;
        return  new StringBuilder(new String(a));

    }
}
