import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Encryption {
    public static String allSymbolsStr = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,”:-!? ";
    public static char[] allSymbolsChar = allSymbolsStr.toCharArray();
    static int lengthAlphabet = allSymbolsChar.length;
    static boolean encryptionDone = false;

    public static void encryption(String way) {
        //Ввод ключа безопасности
        System.out.println("Введите число - ключ безопасности");
        int keyInt = 0;
        int count = 3;
        while (count > 0) {
            try {
                keyInt = Integer.parseInt(Actions.readLine());
                break;
            } catch (NumberFormatException e) {
                count--;
                if (count > 0)
                    System.out.println("Ключ безопасности должен быть только числом от -2_147_483_648 до 2_147_483_647\n" +
                            "Пожалуйста, введите число");
                else System.out.println("Попробуйте в другой раз");
            }
        }
        //Редактирование ключа безопасности в пределах lengthAlphabet
        if (keyInt >= 0) keyInt %= lengthAlphabet;
        else keyInt = lengthAlphabet + keyInt % lengthAlphabet;

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
        System.out.println("Файл записан в папку \"CaesarEncryptionAndDecryption\"");
    }
}
