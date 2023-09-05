import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Actions {
    public static String readLine(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static String userTextEntry(){
        StringBuilder sb = new StringBuilder();
        String line;
        while (!(line = Actions.readLine()).equals(Constants.wordToEndTextInput)) {
            sb.append(line).append("\n");
        }
        //Если введенный текст не null обрезается лишний последний абзац
        if(!sb.isEmpty()){
            sb.delete(sb.length()-1, sb.length());
        }

        Path file = Paths.get(Constants.encryptedFile);
        try {
            Files.writeString(file, sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Constants.encryptedFile;
    }

    public static int securityKeyEntry(){
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
        if (keyInt >= 0) keyInt %= Constants.lengthAlphabet;
        else keyInt = Constants.lengthAlphabet + keyInt % Constants.lengthAlphabet;

        return keyInt;
    }

    public static String readText(String filePath){
        String unencryptedString;
        Path unencryptedFile = Paths.get(Constants.unencryptedFile);
        try {
            unencryptedString = Files.readString(Path.of(filePath));
            Files.writeString(unencryptedFile, unencryptedString);
        } catch (IOException e) {
            //System.out.println("Файл для расшифровки не найден, возможно нужно сначала зашифровать текст");
            throw new RuntimeException(e);
        }
        return unencryptedString;
    }

    public static void writeText(String text, String filePath){
        Path file = Paths.get(filePath);
        try {
            Files.writeString(file, text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Файл \""+filePath+"\" записан в папку \"Caesar\"");
    }




}
