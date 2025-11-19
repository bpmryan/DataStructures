import java.math.BigInteger;

public class Inverse {
    public static void main(String[] args) {
        // Space is required so that you don't get an "index out of bounds" error
        // Put the alphabet into a character array with a length of 27 (26 letters + space)
        char[] alphabet = " abcdefghijklmnopqrstuvwxyz".toCharArray();

        // plug in encrypted message into number and set it equal to "test" 
        BigInteger number = new BigInteger("144644361721427313922062331675403123867343950242520475640707597283261643774925737501589409076350039814");   
        BigInteger test = number; //Test is used to put into while loop 
        int places = 0;

        // place of letter * 27
        // reverse engineer by dividing by 27
        // Finding the number of places by finding the highest power of 27 that can go into "test"
        while (test.compareTo(BigInteger.ONE) > 0) {
            test = test.divide(BigInteger.valueOf(27));
            places++;
        }  
        places--;

        String result = "";
        while (places >= 0) {
            // Value is the index that you use to compare to character array
            // number/(27^n)
            BigInteger value = number.divide(BigInteger.valueOf(27).pow(places));
            // number - (27^n * value) 
            number = number.subtract((BigInteger.valueOf(27).pow(places)).multiply(value));
            // Adding on every letter(string) decryphered and subtracting the places to end loop
            result += alphabet[value.intValue()];
            places--;
        }
        System.out.println(result);
    }
}
