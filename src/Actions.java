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
        String way = "encryptedFile.txt";
        Path file = Paths.get(way);
        try {
            Files.writeString(file, sb.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return way;
    }

}
