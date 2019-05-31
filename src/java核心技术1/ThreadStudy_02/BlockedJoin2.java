package java核心技术1.ThreadStudy_02;

/**
 * 通过儿子给老爸买烟，老爸要等儿子把烟买回来以后，才可以抽烟的例子来体现多线程的join方法
 */
public class BlockedJoin2 {
    public static void main(String[] args) {
        new Thread(new Father()).start();
    }
}

class Father extends Thread {
    @Override
    public void run() {
        System.out.println("想抽烟");
        System.out.println("叫来儿子去买烟");
        Thread t = new Thread(new Son());
        t.start();
        try {
            t.join();//等待儿子把烟拿回来
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("接过烟把零钱给了儿子");
    }
}

class Son extends Thread {
    @Override
    public void run() {
        System.out.println("接过钱去买眼");
        System.out.println("路过游戏厅去玩了10秒");
        for (int i = 1; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("想起了要买烟");
        System.out.println("买了烟回去了");
    }
}
