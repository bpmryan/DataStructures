package code;

public class Stack<T extends Comparable<T>> extends Structure<T> {
    public T pop() {
        T ret = tail.x;
        this.tail.before.next = null;
        this.tail = this.tail.before;
        return ret;
    }
}



