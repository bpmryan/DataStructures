import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Palindrome {
    public static void main(String[] args) {
        // System.out.println("hello world");
        String[] lines = new String[370105];
        fillLines("../data/words_alpha.txt", lines);

        int count = 0;
        for (String ln : lines) {
            if (ln.length() > 2 && isPalindrome(ln)) {
                System.out.printf("%s, ", ln, 1);
                count++;
            }
        }
        System.out.printf("%n%d two or more letter-palindromes found. %n", count);
    }

    public static void fillLines(String path, String[] lines) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int i = 0;
            String line;
            while ((line = br.readLine()) != null)
                lines[i++] = line;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left++ < right--) {
            if (s.charAt(left - 1) != s.charAt(right + 1))
                return false;
        }
        return true;
    }
}
