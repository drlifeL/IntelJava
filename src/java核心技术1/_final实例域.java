package java核心技术1;
public class _final实例域 {
    /**
     * 可以直接进行初始化，
     * 也可以通过构造方法进行初始化，甚至还可以通过静态代码块进行初始化。只要在构造方法执行完毕之前对值进行初始化就可以了。
     */
    static{
        name = "hah";
    }
    public static final String name;//如果类中的成员加了final关键字，则必须在类的构造方法执行完毕之前，对其进行初始化，否则就不符合语法。
    public final String address;
    public final StringBuilder sb = new StringBuilder();

    public _final实例域(String address){
        this.address = address;//这里是因为上面的要配合使用静态代码块的初始化才出现的，因为类的构造方法是new的时候调用，而name 字段是static ，静态变量
    }
    public void setAddress(String address){
        /**
         * 如果使用final关键字，是无法对其的值进行修改的，但是如果这个是一个对象的话，我们可以修改对象中的值，但是不可以修改对象的引用、
         */
//        this.address = address;
    }
    /**
     * 对对象进行测试
     */
    public void updateBuf(){
        getSb().append("dad");//对这个值进行修改是没有问题
    }

    public StringBuilder getSb() {
        return sb;
    }

}