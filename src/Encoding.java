import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Encoding {
    public static Files firstItem(){
        String encodingString;
        System.out.println("fi");
        try {
            encodingString = Files.readString(Path.of("src/EncodingText.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




        return null;
    }









}
