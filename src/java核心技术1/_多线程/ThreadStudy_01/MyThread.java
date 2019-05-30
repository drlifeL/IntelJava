package java核心技术1._多线程.ThreadStudy_01;

/**
 * 实现多线程的第一种方法，继承Thread类，重写其中的Run方法
 * 类中的方法只有通过run方法来运行才可以运行，否则即使开启线程，但是不会运行
 */
public class MyThread extends Thread {
    public static int num = 10;

    public void run() {
        System.out.println(--num);
    }

    public static void main(String[] args) {
        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();
        MyThread m3 = new MyThread();
        MyThread m4 = new MyThread();
        MyThread m5 = new MyThread();
        MyThread m6 = new MyThread();
        MyThread m7 = new MyThread();
        MyThread m8 = new MyThread();
        m1.start();
        m2.start();
        m3.start();
        m4.start();
        m5.start();
        m6.start();
        m7.start();
        m8.start();
    }
}
