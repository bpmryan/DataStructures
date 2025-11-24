import java.util.HashMap;
import java.util.LinkedList;

public class HashBrown {
  public static final long MAX = Integer.MAX_VALUE;
  // public static final long MAX = Long.MAX_VALUE;

  public static void main(String[] args) {
    String contents = Frequency.read("../media/words_alpha.txt");
    String words[] = contents.split("\\s+");
    HashMap<Long, LinkedList<String>> map;
    map = new HashMap<Long, LinkedList<String>>();
    for (String word : words) {
      long hash = base27(word);
      if (!map.containsKey(hash))
        map.put(hash, new LinkedList<String>());
      map.get(hash).add(word);
    }

    int collisions = 0;
    for (Long key : map.keySet())
      if (map.get(key).size() > 1) {
        collisions += 1;
        System.out.printf("%15d:%s%n", key, map.get(key).toString());
      }
    System.out.printf("%d total collisions. ", collisions);

  }

  public static long base27(Object toHash) {
    String s = String.format("%s", toHash);
    long base = 27; // 26 alphabet and a blank-space
    long offset = 'a' - 1;
    long x = 0, p = 1;
    for (int i = s.length() - 1; i > -1; i--) {
      long bit = s.charAt(i);
      bit = bit == ' ' ? 0 : (bit - offset);
      x += bit * p;
      p *= base;
    } // Long.MAX_VALUE = 2^(63) - 1, 64 bits but one sign bit
    return Math.floorMod(x, MAX);
  }

  public static long hash(Object toHash) {
    return Math.floorMod(base27(toHash), MAX);
  }
}
