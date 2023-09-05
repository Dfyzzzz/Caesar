import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BruteForce {
    private static final double averageWordLength = 7.2;
    public static int bruteForce(){
        for (int key = 1; key < Constants.lengthAlphabet; key++) {
            String encryptedText = Actions.readText(Constants.encryptedFile);

            String decryptedText = Decryption.decryption(key, encryptedText);

            double wordCount = encryptedText.length()/averageWordLength;
            int countSpaces = decryptedText.length() - decryptedText.replace(" ", "").length();

            if(countSpaces > (wordCount-(wordCount*0.2)) && countSpaces < (wordCount+(wordCount*0.2))){
                Actions.writeText(decryptedText, Constants.decryptedFile);

                return key;
            }
        }
        System.out.println("Не удалось найти ключ");

        return 0;
    }
}
