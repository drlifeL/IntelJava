package java核心技术1._泛型;

import java.io.Serializable;

/**
 * 泛型类可以有多个类型变量 例如：public class Pair<T,V>
 * @param <T>
 */
public class Pair<T> implements Serializable {
    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return first;
    }

    public T getSecond(){
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
