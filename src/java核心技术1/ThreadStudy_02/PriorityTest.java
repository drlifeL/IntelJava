package java核心技术1.ThreadStudy_02;

/**
 * 线程的优先级 1-10，默认为5
 * static int MAX_PRIORITY  10
 * 一个线程可以拥有的最高优先级。
 * static int MIN_PRIORITY  1
 * 一个线程可以拥有的最低优先级。
 * static int NORM_PRIORITY  5
 * 分配给线程的默认优先级。
 * 优先级只是代表一个概率，优先级高的只是被提前执行的概率大
 */
public class PriorityTest {

    public static void main(String[] args) {
        MyPriority priority = new MyPriority();

        Thread t1 = new Thread(priority, "a");
        Thread t2 = new Thread(priority, "b");
        Thread t3 = new Thread(priority, "c");
        Thread t4 = new Thread(priority, "d");
        Thread t5 = new Thread(priority, "e");
        Thread t6 = new Thread(priority, "f");

        t1.setPriority(10);
        t2.setPriority(10);
        t3.setPriority(10);
        t4.setPriority(5);
        t5.setPriority(5);
        t6.setPriority(5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();


    }
}

class MyPriority extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }
}
