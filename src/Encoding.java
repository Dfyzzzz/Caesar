import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Encoding {
    public static String allSymbolsStr = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,”:-!? ";
    public static char[] allSymbolsChar = allSymbolsStr.toCharArray();
   static int lengthAlphabet = allSymbolsChar.length;
    public static String firstItem(){
        //Ввод ключа безопасности
        System.out.println("Введите число - ключ безопасности");
        int keyInt = 0;
        int count = 3;
        while(count>0){
            try{
                keyInt = Integer.parseInt(Actions.readLine());
                break;
            }catch (NumberFormatException e){
                count--;
                if(count>0) System.out.println("Ключ безопасности должен быть только числом до 2_147_483_647\nПожалуйста, введите число");
                else System.out.println("Попробуйте в другой раз");
            }
        }
        //Редактирование ключа безопасности в пределах lengthAlphabet
        if(keyInt >= 0) keyInt %= lengthAlphabet;
        else keyInt = lengthAlphabet + keyInt%lengthAlphabet;

         //Чтение файла, преобразование в массив символов
        String encodingString;
        try {
            encodingString = Files.readString(Path.of("src/Text.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        char[] allChar = encodingString.toCharArray();

        //шифрование текста
        for (int i = 0; i < allChar.length; i++) {
            if (allSymbolsStr.contains(Character.toString(allChar[i]))) {

                int index = allSymbolsStr.indexOf(allChar[i]);

                if((index+keyInt)>=lengthAlphabet) index -= 74;
                allChar[i] = allSymbolsChar[index+keyInt];
            }
        }

        //Запись шифрованного текста в файл
        Path file = Paths.get("encryptedFile.txt");
        try {
            Files.writeString(file, new String(allChar));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "Текст зашифрован и записан в файл";
    }









}
