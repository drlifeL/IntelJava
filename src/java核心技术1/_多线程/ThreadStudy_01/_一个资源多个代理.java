package java核心技术1._多线程.ThreadStudy_01;

/**
 * 并发情况,我只创建一个对象，但是我开启多个Start()
 */
public class _一个资源多个代理 implements Runnable {
    private int num = 90;

    @Override
    public void run() {
        try {
            Thread.sleep(200);//如果我让其线程进行沉睡，就会出现并发问题
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "->" + num--);
    }

    public static void main(String[] args) {
        _一个资源多个代理  a = new _一个资源多个代理();
        //开启多个start,共享资源
        new Thread(a,"1号").start();
        new Thread(a,"2号").start();
        new Thread(a,"3号").start();
        new Thread(a,"4号").start();
        new Thread(a,"5号").start();
        new Thread(a,"6号").start();
    }
}
