package java核心技术1._多线程.ThreadStudy_01;
public class Test {
    public static void main(String[] args) {
        MyThread my = new MyThread();
        my.start();
        MyThread my1 = new MyThread();
        my1.start();
        MyThread my2 = new MyThread();
        my2.start();

        //继承接口的实现
        MyThread2 my3 = new MyThread2();
        //因为我们没有Run方法..
        new Thread(my3).start();
        MyThread2 my4 = new MyThread2();
        new Thread(my4).start();


    }
}
