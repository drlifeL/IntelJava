package java核心技术1.ThreadStudy_04;

import sun.awt.windows.ThemeReader;

/**
 * 协作模型：生产者消费者实现方式一：管程法
 * 借助缓冲区
 */
public class CoTest01 {
    public static void main(String[] args) {
        SynConrtainer conrtainer = new SynConrtainer();
        new Productor(conrtainer).start();
        new Consumer(conrtainer).start();
    }
}

//生产者
class Productor extends Thread {
    SynConrtainer conrtainer;

    public Productor(SynConrtainer conrtainer) {
        this.conrtainer = conrtainer;
    }

    @Override
    public void run() {
        //生产
        for (int i = 0; i < 100; i++) {
            System.out.println("生产-->" + (i + 1) + "个馒头");
            conrtainer.push(new Steamedbun((i + 1)));
        }
    }
}

// 消费者
class Consumer extends Thread {
    SynConrtainer conrtainer;

    public Consumer(SynConrtainer conrtainer) {
        this.conrtainer = conrtainer;
    }

    @Override
    public void run() {
        //消费
        for (int i = 0; i < 200; i++) {
            System.out.println("消费-->" + conrtainer.pop().id + "个馒头");

        }
    }
}

//缓冲区
class SynConrtainer {
    Steamedbun[] buns = new Steamedbun[10];
    int count = 0;//计数器

    //存储
    public synchronized void push(Steamedbun bun) {
        //何时能生产 容器存在空间
        //不能生产
        if (count == buns.length) {
            try {
                this.wait();//线程阻塞，消费者通知生产解除
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在空间 可以生产
        buns[count++] = bun;
        this.notifyAll();
    }

    //获取,因为下标每次都提前了一个位置，所以要先减去才能取到正确的值
    public synchronized Steamedbun pop() {
        //何时消费 容器中是否存在数据
        //没有数据 只有等待
        if (count == 0) {
            try {
                this.wait();//线程阻塞 生产者通知消费
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Steamedbun s = buns[count];
        //存在数据可以消费
        this.notifyAll();//存在空间可以唤醒对方
        return s;
    }


}

//馒头
class Steamedbun {
    int id;

    public Steamedbun(int id) {
        this.id = id;
    }
}
