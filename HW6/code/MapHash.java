import java.util.ArrayList;
import java.util.LinkedList;

// Tashfeen's implementation of hashmap instead of java library version
public class MapHash {

    private LinkedList<String>[] domain;
    private LinkedList<Integer> keys;

    public MapHash() {
        this.domain = LinkedList<String>[Integer.MAX_VALUE];
        this.keys = new LinkedList<Integer>();
    }

    public LinkedList<String> get(int key) {
        return this.domain.get(key);
    }

    public String put(String value) {
        int hash = (int) HashBrown.hash(value);
        this.keys.add(hash);
        if (this.domain[hash] == null) {
            this.domain[hash] = new LinkedList<String>();
        }
        return value;
    }
}
