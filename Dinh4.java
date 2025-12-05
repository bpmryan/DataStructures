// 906609
public class Dinh4 {
    /*
     * A palindromic number reads the same both ways.
     * The largest palindrome made from the product of two 2-digit numbers is 9009 =
     * 91 * 99
     * Find the largest palindrome made from the product of two 3-digit numbers.
     */

    // Create 2 random 3-digit numbers and check if they generate a palindrome
    // number
    // 2 loops that generate two 3-digit numbers
    // Check the product if its reverse is the exact same number

    public static void main(String[] args) {
        int finalPal = 0;

        // first number
        for (int i = 100; i <= 999; i++) {
            // second number
            for (int j = i; j <= 999; j++) {
                // multiply the 2 generated numbers
                // set product = tempPal
                int tempPal = i * j;

                // check if tempPal < finalPal
                // finalPal can't be a smaller number according to directions
                if (tempPal < finalPal) {
                    break;
                }

                // Goes to isPal method to check if the number is a Palindrome
                // sets tempPal = finalPal if the tempPal > finalPal
                // finalPal has to be the largest palindrome according to the directions
                if (isPal(tempPal)) {
                    if (tempPal > finalPal) {
                        finalPal = tempPal;
                    }
                }
            }
        }
        System.out.println(finalPal);

    }

    // method to check if tempPal is a palindrome
    public static boolean isPal(int currentTemp) {
        int originalTemp = currentTemp;
        int reversedTemp = 0;

        while (currentTemp > 0) {
            // reads the last digit of currentTemp
            int digit = currentTemp % 10;
            // Constructs currentTemp in reverse
            reversedTemp = reversedTemp * 10 + digit;
            // counter to remove each digit from currentTemp to end loop
            currentTemp /= 10;
        }
        return originalTemp == reversedTemp;
    }
}
