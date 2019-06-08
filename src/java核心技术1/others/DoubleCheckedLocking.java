package java核心技术1.others;

/**
 * DCL单例模式：懒汉式套路基础上加入并发控制，保证在多线程环境下，对外存在一个对象
 * 1.构造器私有化-->避免外部new 构造器
 * 2.提供私有的静态属性 -->存储对象的地址
 * 3.提供公共的静态方法 -->获取属性
 */
public class DoubleCheckedLocking {
    //多线程下的单例懒汉模式
    //因为对象只能有一个，所有我们不提供公开的构造方法,私有化构造
    private DoubleCheckedLocking() {

    }

    private static volatile DoubleCheckedLocking instance;//要返回的对象
    //加上volatile 防止Cpu指令重排，快速的刷新值，减少我们同步代码块的判断。

    public static DoubleCheckedLocking getInstance() {
        if (instance != null) {//双重判断，防止每次都要排队等候
            return instance;
        }
        synchronized (DoubleCheckedLocking.class) {//这里就不可以锁我们的变量了，锁变量就会出现空指针异常
            if (null == instance) {
                instance = new DoubleCheckedLocking();
                //1.开辟空间 //2.初始化对象 3、返回对象的地址给引用
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                System.out.println(DoubleCheckedLocking.getInstance());
            }).start();
        }


    }


}


