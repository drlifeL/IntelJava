package java核心技术1.ThreadStudy_02;

/**
 * 线程礼让，让线程重新回到就绪状态，可能会礼让失败
 */
public class YieldDemo1 {
    public static void main(String[] args) {
        MyYield my = new MyYield();
        new Thread(my).start();
        new Thread(my).start();
    }
}

class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--》start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "--》end");
    }
}
