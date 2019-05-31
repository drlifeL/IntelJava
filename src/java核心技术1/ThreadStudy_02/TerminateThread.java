package java核心技术1.ThreadStudy_02;

/**
 * 终止线程的两种方法：
 * 1.让线程执行完毕
 * 2.外部定义一个flag标记，用来让线程提前终止
 */
public class TerminateThread implements Runnable {
    //定义变量，让其在外部可以控制
    private static boolean flag = true;
    private int i = 1;

    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "我在运行" + i++);
        }
    }

    public static void main(String[] args) {
        TerminateThread t = new TerminateThread();
        new Thread(t).start();
        for (int i = 0; i < 100; i++) {
            if (i == 88) {
                flag = false;//即使这里改变了线程的状态，但是线程其实并没有立即切换到我们需要终于终止线程的线程上，如果CPU切换过去，那么该线程立即死亡。
            }
            System.out.println(Thread.currentThread().getName() + i);
        }

    }
}
