package java核心技术1._多线程.ThreadStudy_01;

import java.util.concurrent.Callable;

/**
 * 开启线程的第二种方式，实现Runnable接口
 * 这个时候，如果我们想要开启线程，就必须借助Thread来帮我们开启
 */
public class MyThread2 implements Runnable {

    @Override
    public void run() {
        add();
    }

    public void add() {
        System.out.println(Thread.currentThread().getName() + "::" + "我被运行了！");
    }

}
