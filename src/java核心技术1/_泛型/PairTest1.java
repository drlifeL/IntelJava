package java核心技术1._泛型;


public class PairTest1 {
    public static void main(String[] args) {
        Pair<String> p = new Pair<String>("Mary", "hh");
        System.out.println(p.getFirst());
        System.out.println(p.getSecond());


    }

    /**
     * 普通类中也可以定义泛型方法，（泛型方法可以定义在普通类中，也可以定义在泛型类中）
     *
     * @param a
     * @param <T>
     * @return
     */
    public static <T> T getT(T... a) {
        return a[a.length / 2];
    }
}

class ArrayAlg {
    /**
     * 提供一个字符串的比较方法
     *
     * @param a
     * @return
     */
    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
        return new Pair<>(min, max);
    }

    public static <T extends Pair> void get(T a){
        System.out.println("我被调用了！");
    }
}
