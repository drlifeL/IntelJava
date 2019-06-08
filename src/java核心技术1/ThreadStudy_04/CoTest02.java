package java核心技术1.ThreadStudy_04;

/**
 * 信号灯法
 */
public class CoTest02 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

//生产者
class Player extends Thread {
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                tv.play("你们好啊！");
            } else {
                tv.play("今天怎么样！");
            }
        }
    }
}

//消费者
class Watcher extends Thread {
    Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

//信号灯
class Tv {
    boolean flag = true;//信号
    String voice;

    //T 表示演员表演 观众等待
    //F 表示观众观看 演员等待
    public synchronized void play(String voice) {
        //演员等待
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("表演了" + voice);
        this.voice = voice;
        this.notify();
        flag = !flag;
    }

    public synchronized void watch() {

        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("听到了" + voice);
        this.notify();
        flag = !flag;
    }

}
