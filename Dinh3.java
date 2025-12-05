// 6857
public class Dinh3 {
    /*
     * The prime factors of 13195 are 5, 7, 13, and 29.
     * What is the largest prime factor of the number 600851475143?
     */

    
    public static void main(String[] args) {
        long number = 600851475143L;
        long result = PrimeFactor(number);
        System.out.println(result);
        // Create a loop that divides number by 2 until it is not longer divisable
        // Create a loop that divides number by odd numbers starting from 3
    }

    public static long PrimeFactor(long number) {
        long largePrime = -1;

        // check factors of 2
        while (number % 2 == 0) {
            largePrime = 2;
            number /= 2;
        }

        // check for odd factors starting from 3
        for (long i = 3; i * i <= number; i += 2) {
            while (number % i == 0) {
                largePrime = i;
                number /= i;
            }
        }

        // if number is greater than 2, it returns as a prime number
        if (number > 2) {
            largePrime = number;
        }

        return largePrime;
    }


}