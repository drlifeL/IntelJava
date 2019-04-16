package java核心技术1._继承;

public class Manager extends Employee {
    public Manager(){

        /*
        如果子类的构造器没有显示的调用超类的构造器，则将自动的调用超类（无参构造器）默认的构造器，
        如果超类没有默认的构造器，并且在子类构造器中没有显示的调用超类的其他构造器，则java编译器会报错
         */
//        super(200);
    }
    public Manager(double bonus){
        this.bonus = bonus;
    }
    private double bonus = 100;

    public double getSalary(){

//        return bonus+getSalary();//这里因为子类中复写了父类的方法，没有使用supper关键字前，一直都是递归的调用自己的方法，会出现栈溢出
        return bonus+super.getSalary()+super.x;

    }

    @Override
    public String toString() {
        return "ManagertoString";
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

}
