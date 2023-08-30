import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BruteForce {
    public static int bruteForce(){
        //Чтение файла, преобразование в массив символов
        String encryptedString;
        try {
            encryptedString = Files.readString(Path.of("encryptedFile.txt"));
        } catch (IOException e) {
            System.out.println("Файл для расшифровки не найден, возможно нужно сначала зашифровать текст");
            return 0;
        }

        //Подбор ключа
        int key = 1;
        for (; key < Encryption.lengthAlphabet-1; key++) {
            int countSpaces = 0;
            char [] allChar = encryptedString.toCharArray();

            for (int i = 0; i <allChar.length; i++) {
                if (Encryption.allSymbolsStr.contains(Character.toString(allChar[i]))){
                    int index = Encryption.allSymbolsStr.indexOf(allChar[i]);
                    if ((index - key) < 0) index += Encryption.lengthAlphabet;
                    allChar[i] = Encryption.allSymbolsChar[index - key];

                    if(allChar[i] == ' ') countSpaces++;
                }
            }

            //подбор ключа подсчетом количества пробелов
            int length = allChar.length;
            double averageWordLength = 7.2;
            double wordCount = length/averageWordLength;

            if(countSpaces > (wordCount-(wordCount*0.2)) && countSpaces < (wordCount+(wordCount*0.2))){

                //Запись шифрованного текста в файл
                Path file = Paths.get("decryptedFile.txt");
                try {
                    Files.writeString(file, new String(allChar));
                    System.out.println("Файл \"decryptedFile.txt\" записан в папку \"CaesarEncryptionAndDecryption\"");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return key;
            }
        }
        System.out.println("Не удалось найти ключ");
        return 0;
    }
}
