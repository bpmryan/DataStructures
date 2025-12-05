// 142913828922
public class Dinh10 {
    /**
     * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
     * Find the sum of all the primes below two million.
     * 
     */
    public static void main(String[] args) {
        // Have a loop that adds all primes below 2 million
        // Create a function that checks if the number is prime
        // If is is prime, add it to the sum
        // use the seieve of Eratosthenes to generate primes

        int limit = 2000000;
        int[] primes = sieve(limit);
        long solution = 0;
        for (int i = 0; i < primes.length; i++) {
            solution += primes[i];
        }
        System.out.println(solution);
    }

    // implement the sieve of Eratosthenes
    private static int[] sieve(int number) {
        boolean[] isPrime = new boolean[number + 1];
        int count = 0;

        // nested loop that runs through the numbers using the sieve of Eratosthenes
        // checks through 2 first, then every other number after that and checking the mod of each number
        for (int i = 2; i * i <= number; i++) {
            for (int j = i * i; j <= number; j += i) {
                if (j % i == 0 && !isPrime[j]) {
                    isPrime[j] = true;
                    count++;
                }
            }
        }
        int[] primes = new int[number - count + 2];
        int x = 0;

        for (int i = 2; i <= number; i++) {
            if(!isPrime[i]) {
                primes[x] = i;
                x++;
            }
        }

        return primes;
    }
}
