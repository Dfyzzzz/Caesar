import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Actions {
    public static String readLine() {
        Scanner sc = new Scanner(System.in);

        return sc.nextLine();
    }

    public static String userTextEntry() {
        StringBuilder sb = new StringBuilder();
        String line;

        while (!(line = Actions.readLine()).equals(Constants.wordToEndTextInput)) {
            sb.append(line).append("\n");
        }

        //Если введенный текст не null обрезается лишний последний абзац
        if (!sb.isEmpty()) {
            sb.delete(sb.length() - 1, sb.length());
        }

        writeText(sb.toString(), Constants.unencryptedFile);

        return Constants.unencryptedFile;
    }

    public static int securityKeyEntry() {
        System.out.println("Введите число - ключ безопасности");
        int keyInt = Integer.parseInt(Actions.readLine());

        //Редактирование ключа безопасности в пределах lengthAlphabet
        if (keyInt >= 0) {
            keyInt %= Constants.lengthAlphabet;
        } else {
            keyInt = Constants.lengthAlphabet + keyInt % Constants.lengthAlphabet;
        }

        return keyInt;
    }

    public static String readText(String filePath) {
        String text;

        try {
            text = Files.readString(Path.of(filePath));
        } catch (IOException e) {
            e.printStackTrace();

            return "failure: IOException";
        }

        return text;
    }

    public static void writeText(String text, String filePath) {
        Path file = Paths.get(filePath);

        try {
            Files.writeString(file, text);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Файл \"" + filePath + "\" записан в папку \"Caesar\"");
    }
}
