package java核心技术1;

/**
 * 相同的名称，不能的参数，便产生了重载
 *
 * 编译器通过用各个方法给出的参数类型与特定方法调用所使用的值类型进行匹配来挑选出相应的方法，如果找不到就会参数编译错误
 * 这个过程被称为重载解析。、
 * 注意：
 *  java允许重载任何方法，而不只是构造方法。因此，要完整的描述一个方法，需要指出方法名以及参数类型。
 *  这叫做方法的签名。例如：String 类有4个称为indexOf()的公有方法。他们的签名是：
 *         indexOf(int)
 *         indexOf(int,int )
 *         indexOf(String)
 *         indexOf(String,int )
 *  返回类型不是方法签名的一部分，也就是说，不能有两个名字相同、参数类型也相同但返回不同类型值得方法
 */
public class _重载 {
    public static void main(String[] args) {

    }
}
class overLoad{
    private String x ;

    /**
     * 构造方法的重载
     */
    public overLoad(){

    }
    public overLoad(String x){
        this.x = x;
    }

    /**
     * 方法的重载
     * @return
     */
    public String getX(){
        return x;
    }
/*
    不能有两个方法名字相同，但返回值不同的方法
    public void getX(){

    }*/
    public String getAddX(String z){
        return x+z;
    }


}
