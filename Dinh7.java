// 104743
public class Dinh7 {
    /**
     * By listing the first six prime number: 2, 3, 5, 7, 11, and 13, we can see
     * that the 6th prime is 13
     * What is the 100001st prime number?
     */

    public static void main(String[] args) {
        /**
         * set target prime index
         * have a boolean check for every number to see if it is prime (similar to
         * Dinh3)
         * count for every prime number it passes through until the 100001st prime
         * number
         * sieve of eratosthenes?
         */
        int count = 0;
        int number = 1;

        // checks through each number (from 2 onwards) until it finds the 10001st prime
        // increase count for every prime found
        while (count < 10001) {
            number++;

            if (isPrime(number)) {
                count++;
            }
        }

        System.out.println(number);
    }

    // method to check if a number is prime
    public static boolean isPrime(int n) {
        if (n < 2)
            return false;

        // Only check up to sqrt(n)
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
