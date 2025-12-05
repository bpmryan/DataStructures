// 31875000
public class Dinh9 {
    public static void main(String[] args) {
        /*
         * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
         * 
         * a^2 + b^2 = c^2
         * 
         * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
         * 
         * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
         * Find the product abc.
         */

        /**
         * run a loop from 1-1000 for "a" and "b"
         * calculate "c" as 1000 - a - b
         * check if a^2 + b^2 = c^2
         */
        for (int a = 1; a < 1000; a++) {
            for (int b = a + 1; b < 1000 - a; b++) {
                int c = 1000 - a - b;
                if (a * a + b * b == c * c) {
                    int product = a * b * c;
                    System.out.println(product);
                    return;
                }
            }
        }
    }
}
