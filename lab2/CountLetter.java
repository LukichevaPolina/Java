import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CountLetter {
    Map<Character, Integer> toCount (FileReader file) throws IOException {
        Map<Character, Integer> letters = new HashMap<>();
        String alph = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < alph.length(); ++i) {
            letters.put(alph.charAt(i), 0);
        }
        int c;
        while ((c = file.read() )!= -1) {
            if ((char) c >= 'A' && (char) c <= 'Z' || (char) c >= 'a' && (char) c <= 'z')
                if (letters.get(Character.toLowerCase((char) c)) == 0) {
                    letters.put(Character.toLowerCase((char) c), 1);
                }
                else {
                    letters.put(Character.toLowerCase((char) c), letters.get(Character.toLowerCase((char) c)) + 1);
                }
        }
        return letters;
    }
}
