// 25164150
public class Dinh6 {
    /*
     * The sum of the squares of the first ten natural numbers is,
     * 1^2 + 2^2 + ... + 10^2 = 385
     * 
     * The square of the sum of the first ten natural numbers is,
     * (1 + 2 + ... + 10)^2 = 55^2 = 3025
     * 
     * Hence the difference between the sum of the squares of the first ten natural
     * numbers and the square of the sum is 3025 - 385 = 2640.
     * 
     * Find the difference between the sum of squares of the first one hundred
     * natural numbers and the square of the sum.
     */
    public static void main(String[] args) {
        // Loop to find the square of 1-100 and get the sum of it = sumLoop
        // Add 1-100 and square it = sumSquare
        // Subtract the sumLoop from sumSquare

        // Function that returns the sum of all squared numbers 1-100
        int squareSum = 0;
        for (int i = 1; i <= 100; i++) {
            int square = i * i;
            squareSum += square;
        }

        // Function that returns the sum of 1-100 and THEN squaring it
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        int sumSquare = sum * sum;

        // subtract the squareSum from sumSquare
        int solution = sumSquare - squareSum;
        System.out.println(solution);
    }
}
