import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Decryption {
    public static void decryption(int keyInt) {

        //Чтение файла, преобразование в массив символов
        String encryptedString=null;
        try {
            encryptedString = Files.readString(Path.of("encryptedFile.txt"));
        } catch (IOException e ) {
            System.out.println("Файл для расшифровки не найден, возможно нужно сначала зашифровать текст");
        }
        char[] allChar = encryptedString != null ? encryptedString.toCharArray() : new char[0];

        //расшифровка текста
        for (int i = 0; i < allChar.length; i++) {
            if (Encryption.allSymbolsStr.contains(Character.toString(allChar[i]))) {

                int index = Encryption.allSymbolsStr.indexOf(allChar[i]);

                if ((index - keyInt) < 0) index += Encryption.lengthAlphabet;
                allChar[i] = Encryption.allSymbolsChar[index - keyInt];
            }
        }

        //Запись расшифрованного текста в файл
        Path file = Paths.get("decryptedFile.txt");
        try {
            Files.writeString(file, new String(allChar));
            System.out.println("Файл \"decryptedFile.txt\" записан в папку \"CaesarEncryptionAndDecryption\"");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
