package java核心技术1.ThreadStudy_02;

/**
 * 线程默认都是用户线程
 * JVM会等待所有的用户执行完毕后在关闭，
 * 但是他不会管守护线程，我们可以进行修改
 */
public class DaemonTest {

    public static void main(String[] args){
        Thread t = new Thread(new God());
        t.setDaemon(true);//将其设置为守护线程
        t.start();
        new Thread(new Man()).start();
    }
}

class Man implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i < 365 * 100; i++) {
            System.out.println("happyLife");
        }
    }
}

class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("protected！");
        }
    }
}
