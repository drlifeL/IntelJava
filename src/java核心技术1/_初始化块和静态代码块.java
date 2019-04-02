package java核心技术1;

/**
 * 静态代码块：随着类的加载而执行，且只执行一次
 * 初始化块：只要构造类的对象，这些块就会被执行
 * 优先级：静态代码块>初始化块>构造器>普通代码块
 */
public class _初始化块和静态代码块 {
    static{
         System.out.println("静态代码块执行！");
    }

    {
        System.out.println("初始化块执行");
    }

    public _初始化块和静态代码块() {
        this("哈哈哈");//使用this方法调用其他构造器，也可以在构造器中调用构造器
        System.out.println("构造器");
    }
    public _初始化块和静态代码块(String s ){
        System.out.println(s);
    }

    public static void main(String[] args) {
        _初始化块和静态代码块 x = new _初始化块和静态代码块();
        System.out.println("-------------------------------");
        _初始化块和静态代码块 x1 = new _初始化块和静态代码块();
    }

}
