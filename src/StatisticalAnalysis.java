import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class StatisticalAnalysis {
    public static void StatisticalAnalysis(){
        //Чтение файла 1
        String encryptedString;
        try {
            encryptedString = Files.readString(Path.of("OneNineEightFour_part 1.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HashMap<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < encryptedString.length(); i++) {
            char c = encryptedString.charAt(i);

            if(Character.isLetter(c)) charCount.put(c, charCount.get(c)+1);
            else charCount.put(c,1);
        }
        //Чтение файла 2
        String encryptedString2;
        try {
            encryptedString = Files.readString(Path.of("OneNineEightFour_part 2.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
