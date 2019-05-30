package java核心技术1._多线程.ThreadStudy_01;

/**
 * 使用lambda推导
 */
public class LambdaTest2 {
    public static void main(String[] args) {
        //不带参数的
        lambda l = () -> {
            System.out.println("hhhhh");
        };
        l.show();
        //===========带参数的============================
        //完整写法
        lambda2 l2 = (int a) -> {
            System.out.println("This---------->" + a);
        };
        l2.add(10);
        //参数类型声明可以省略,他会根据接口声明自动推导
        l2 = (a) -> {
            System.out.println("This---------》" + a);
        };
        l2.add(500);
        //如果只有一个参数，括号也可以省略
        l2 = a -> {
            System.out.println("This------------>" + a);
        };
        l2.add(600);
        //如果其代码只有一行，大括号也可以省略
        l2 = a -> System.out.println("最终形态:----->" + a);
        l2.add(700);

        //===================带返回值的====================
        //其类型可以没有，但是多个参数，括号必须有
        lambda3 l3 = (a, b) -> {
            return a + b;
        };
        System.out.println(l3.sum(10, 20));

        //如果你想直接一行代码返回，可以直接写成如下格式
        l3 = (a, b) -> a + b;
        System.out.println(l3.sum(50, 80));
    }

}

//推到lambda不带参数
interface lambda {
    void show();
}

//推导lambda带参数
interface lambda2 {
    void add(int a);
}

//推导lambda带返回值
interface lambda3 {
    int sum(int a1, int a2);
}

class ZZ extends CC {
    public static void main(String[] args) {
        ZZ zz1 = new ZZ();//子类对象
        zz1.add();
        CC cc1;
        CC cc2 = new CC();//父类对象
        cc1 = zz1;//父类引用可以指向子类对象
        cc1.add();

        zz1 = (ZZ) cc2;//子类不能强制转换成父类
        zz1.add();
    }
}

class CC {
    public void add() {
        System.out.println("我是父类的方法");
    }
}

