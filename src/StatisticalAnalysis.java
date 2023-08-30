import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class StatisticalAnalysis {
    public static void StatisticalAnalysis(){
        //Чтение файла 1
        String encryptedPart1;
        try {
            encryptedPart1 = Files.readString(Path.of("src/OneNineEightFourPart1.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //подсчет количества каждого char в первом тексте
        HashMap<Character, Integer> charCountMapPart1 = new HashMap<>();
        int allCharCountPart1 = 0;
        for (int i = 0; i < encryptedPart1.length(); i++) {
            char c = encryptedPart1.charAt(i);

            if(Encryption.allSymbolsStr.contains(String.valueOf(c))) {
                if(charCountMapPart1.containsKey(c)) charCountMapPart1.put(c, charCountMapPart1.get(c)+1);
                else charCountMapPart1.put(c, 1);
                allCharCountPart1++;
            }
        }

        //подсчет % от общего каждого char в первом тексте
        HashMap<Character, Double> charPercentMapPart1 = new HashMap<>();
        for (int i = 0; i < Encryption.allSymbolsStr.length(); i++) {
            char c = Encryption.allSymbolsStr.charAt(i);
            if(charCountMapPart1.containsKey(c)){
                int quantity = charCountMapPart1.get(c);
                double percent = quantity*100.0/allCharCountPart1;
                charPercentMapPart1.put(c, percent);
            }
        }

        //Чтение файла 2
        String encryptedPart2;
        try {
            encryptedPart2 = Files.readString(Path.of("encryptedFile.txt"));
        } catch (IOException e ) {
            System.out.println("Файл для расшифровки не найден, возможно нужно сначала зашифровать текст");
            return;
        }

        //подсчет количества каждого char во втором тексте
        HashMap<Character, Integer> charCountMapPart2 = new HashMap<>();
        int allCharCountPart2 = 0;

        for (int i = 0; i < encryptedPart2.length(); i++) {
            char c = encryptedPart2.charAt(i);

            if(Encryption.allSymbolsStr.contains(String.valueOf(c))) {
                if(charCountMapPart2.containsKey(c)) charCountMapPart2.put(c, charCountMapPart2.get(c)+1);
                else charCountMapPart2.put(c, 1);
                allCharCountPart2++;
            }
        }

        //подсчет % от общего каждого char во втором тексте
        HashMap<Character, Double> charPercentMapPart2 = new HashMap<>();
        for (int i = 0; i < Encryption.allSymbolsStr.length(); i++) {
            char c = Encryption.allSymbolsStr.charAt(i);
            if(charCountMapPart2.containsKey(c)){
                int quantity = charCountMapPart2.get(c);
                double percent = quantity*100.0/allCharCountPart2;
                charPercentMapPart2.put(c, percent);
            }
        }

        //расшифровка текста
        char[] allCharPart2 = encryptedPart2.toCharArray();



        for (int i = 0; i < allCharPart2.length; i++) {
            if (Encryption.allSymbolsStr.contains(Character.toString(allCharPart2[i]))) {

                charPercentMapPart2.get(allCharPart2[i]);




//                int index = Encryption.allSymbolsStr.indexOf(allCharPart2[i]);
//
//                if ((index - keyInt) < 0) index += Encryption.lengthAlphabet;
//                allCharPart2[i] = Encryption.allSymbolsChar[index - keyInt];
            }
        }
    }
}
