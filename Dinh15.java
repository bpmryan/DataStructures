// 137846528820
import java.math.BigInteger;

public class Dinh15 {
    /**
     * Starting in the top left corner of a 2 × 2
     * grid, and only being able to move to the right and down, there are exactly 6
     * routes to the bottom right corner.
     * 
     * How many such routes are there through a 20 × 20 grid?
     */
    public static void main(String[] args) {
        /**
         * There are a total of 40 moves to get from the top left to the bottom right of a 20x20
         * C(40, 20) = 40! / (20! * 20!)
         * use big integer to calculate factorials
         */

        System.out.println(binomial(40, 20));
    }
    // computes n choose k (40, 20)
    public static BigInteger binomial(int n, int k) {
        BigInteger result = BigInteger.ONE;

        for (int i = 1; i <= k; i++) {
            result = result.multiply(BigInteger.valueOf(n - (i- 1)));
            result = result.divide(BigInteger.valueOf(i));
        }

        return result;
    }
}
