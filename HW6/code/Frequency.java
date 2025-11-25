import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.Map.Entry;

public class Frequency {
    public static void main(String[] args) {
        String contents = read("../media/TheStrangeCase.txt").toLowerCase().replace("\n", " ");
        String[] tokens = contents.split("\\s+");
        StringBuilder filterContents = new StringBuilder();
        for (int i = 0; i < contents.length(); i++) {
            char c = contents.charAt(i);
            if ('a' <= c && c <= 'z' || c == ' ') {
                filterContents.append(c);
            }
        }
        String[] words = filterContents.toString().split(" ");
        // for (int i = 0; i < words.length; i++) {
        //     if (words[i] != " ")
        //         System.out.println(words[i]);
        // }
        HashMap<String, Integer> counts = new HashMap<>();

        for (String word : words) {
            if(word.length() < 6){
                continue;
            }
            if (counts.containsKey(word)) {
                counts.put(word, counts.get(word) + 1);
            } else {
                counts.put(word, 1);
            }
        }

        List<Entry<String , Integer>> list = new ArrayList<>(counts.entrySet());
        list.sort(Entry.comparingByValue(Comparator.reverseOrder()));

        // Map<String, Integer> result = new LinkedHashMap<>();
        // for(Entry<String, Integer> entry : list) {
        //     result.put(entry.getKey(), entry.getValue());
        // }

        int i = 0;
        for (Entry<String, Integer> e: list) {
            System.out.printf("%15s:%4d%n", e.getKey(), e.getValue()); 
            if (++i > 10) {
                break;
            }
        }
    }

    // String filePath = "../media/TheStrangeCase.txt";
    // try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
    // String line;
    // while ((line = reader.readLine()) != null) {
    // System.out.println(line);
    // }
    // } catch (IOException e) {
    // System.err.println("Error readin file: " + e.getMessage());
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