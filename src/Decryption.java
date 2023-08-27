import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Decryption {
    public static void decryption() {
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
                    System.out.println("Ключ безопасности должен быть только числом от -2_147_483_648 до 2_147_483_647\n"+
                            "Пожалуйста, введите число");
                else System.out.println("Попробуйте в другой раз");
            }
        }

        //Редактирование ключа безопасности в пределах Encryption.lengthAlphabet
        if (keyInt >= 0) keyInt %= Encryption.lengthAlphabet;
        else keyInt = Encryption.lengthAlphabet + keyInt % Encryption.lengthAlphabet;

        //Чтение файла, преобразование в массив символов
        String encryptedString;
        try {
            encryptedString = Files.readString(Path.of("encryptedFile.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        char[] allChar = encryptedString.toCharArray();

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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Файл записан в папку \"CaesarEncryptionAndDecryption\"");
    }
}
