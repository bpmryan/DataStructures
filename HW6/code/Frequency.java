// import java.io.BufferedReader;
// import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Frequency {
    public static void main(String[] args) {
        String contents = read("../media/TheStrangeCase.txt");
        StringBuilder filterContent = new StringBuilder();  
        for (int i = 0; i <= contents.length(); i++) {
            char c = contents.charAt(i);
            if ('a' <= c && c <= 'z' || c == ' ') {
                
            }
        }

    }

    // String filePath = "../media/TheStrangeCase.txt";
        // try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        //     String line;
        //     while ((line = reader.readLine()) != null) {
        //         System.out.println(line);
        //     }
        // } catch (IOException e) {
        //     System.err.println("Error readin file: " + e.getMessage());
        // }

    public static String read(String path) {
        byte[] ret = null;
        try {
            ret = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(ret);
    }

}