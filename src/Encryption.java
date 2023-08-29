import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Encryption {
    public static String allSymbolsStr = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,”:-!? ";
    public static char[] allSymbolsChar = allSymbolsStr.toCharArray();
    static int lengthAlphabet = allSymbolsChar.length;

    public static void encryption(String way, int keyInt) {

        //Чтение файла, преобразование в массив символов
        String encryptedString;
        try {
            encryptedString = Files.readString(Path.of(way));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        char[] allChar = encryptedString.toCharArray();

        //шифрование текста
        for (int i = 0; i < allChar.length; i++) {
            if (allSymbolsStr.contains(Character.toString(allChar[i]))) {

                int index = allSymbolsStr.indexOf(allChar[i]);

                if ((index + keyInt) >= lengthAlphabet) index -= lengthAlphabet;

                allChar[i] = allSymbolsChar[index + keyInt];
            }
        }

        //Запись шифрованного текста в файл
        Path file = Paths.get("encryptedFile.txt");
        try {
            Files.writeString(file, new String(allChar));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Файл \"encryptedFile.txt\" записан в папку \"CaesarEncryptionAndDecryption\"");
    }
}
