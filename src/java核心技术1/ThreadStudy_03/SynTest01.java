package java核心技术1.ThreadStudy_03;

/**
 * 线程安全：在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 1.同步方法
 *    1）成员方法锁This
 * 2.同步块
 *
 *
 */
public class SynTest01 {
    public static void main(String[] args) {
        SafeWeb s1 = new SafeWeb();
        new Thread(s1).start();
        new Thread(s1).start();
    }
}

class SafeWeb implements Runnable {

    private int ticketNums = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            test();
        }
    }


    public synchronized void test() {
        if (ticketNums <=0) {
            flag = false;
            return;
        }
        //模拟延时
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "->" + ticketNums--);

    }
}
