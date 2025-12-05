// 232792560
public class Dinh5 {
    /*
     * 2520 is the smallest number that can be divided by each of the numbers from
     * to without any remainder.
     * What is the smallest positive number that is evenly divisible by all of the
     * numbers from 1 to 20?
     */

    // Initial Idea:
    // Create 2 loops similar to Dinh4
    // One to generate a number to be divided by
    // Another dividing the number from 1-20
    // Method to check if the number is less than the last
    // Save the smaller number

    // Quicker idea:
    // Apply the prime factorization method
    // Use all primes from 1-20
    // Find highest power of each prime <= 20
    // Multiply them

    public static void main(String[] args) {
        int smallPosNum = 16 * 9 * 5 * 7 * 11 * 13 * 17 * 19;
        System.out.println(smallPosNum);
    }
}
