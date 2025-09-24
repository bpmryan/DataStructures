package code;

public class Queue<T extends Comparable<T>> extends Structure<T> {
    public T pop() {
        // T ret = head.x;
        // this.head = this.head.next;
        // this.head.before.next = null;
        // this.head.before = null;
        // return ret; 

        // check if it pops on an empty queue
        // program will crash without the if statement 
        if(this.isEmpty()){
            return null;
        }
        Node<T> ret = this.head.next;
        this.head = this.head.next;
        this.head.before = null;
        return ret.x;
    }
}
