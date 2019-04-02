package java核心技术1;

/**
 * 如果将域定义为static ,每个类中只有一个这样的域。而每一个对象对于所有的实例域却都有自己的一份拷贝。
 * A类中每一个对象都是自己的id域，但这个类中所有的实例将共享一个Next_id域。换句话说，如果有1000个A类的对象
 * 则有1000个实例域id,但是，只有一个静态域,next_id.即使没有一个A类的对象，静态域nextId也存在，它属于类。而不属于任何独立的对象
 * 这里就还引出了一些其他的概念，例如：如果类中存在静态域，那么一般情况下这个静态域都会被声明成为final  即初始化后就不能够修改，因为他是类对象，是所有实例共享的。
 */
public class _静态域 {
    public static void main(String[] args) {
        A a1 = new A();
        a1.setNext_id();
        System.out.println(a1.id);
        System.out.println(a1.getNext_id());

        A a2 = new A();
        System.out.println(a2.id);
        System.out.println(a2.getNext_id());
    }
}
class A{
    public static int next_id = 180;//静态域对象，无论有多少个类的对象，都是共享一个静态对象

    public int id;//每一个对象都有各自的一份id拷贝，独立的

    public void setNext_id(){
        id = next_id;
        next_id++;
    }
    public int getNext_id(){
        return next_id;
    }


}
