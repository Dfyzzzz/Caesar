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
    public static String readText(){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String line;
        while (!(line = sc.nextLine()).equals("end")) {
            sb.append(line);
            sb.append("\n");
        }
        //Если введенный текст не null обрезается лишний последний абзац
        if(!sb.isEmpty()){
            sb.delete(sb.length()-1, sb.length());
        }

        String way = "encryptedFile.txt";
        Path file = Paths.get(way);
        try {
            Files.writeString(file, sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return way;
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
        if (keyInt >= 0) keyInt %= Encryption.lengthAlphabet;
        else keyInt = Encryption.lengthAlphabet + keyInt % Encryption.lengthAlphabet;

        return keyInt;
    }
}
