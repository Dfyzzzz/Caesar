import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class StatisticalAnalysis {
    public static int analysis() {
        //Чтение незашифрованного файла
        String oneNineEightFourStr;
        try {
            oneNineEightFourStr = Files.readString(Path.of("src/OneNineEightFour.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //подсчет количества каждого char в незашифрованном тексте
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < oneNineEightFourStr.length(); i++) {
            char c = oneNineEightFourStr.charAt(i);
            if (Encryption.allSymbolsStr.contains(String.valueOf(c))) {
                if (charCountMap.containsKey(c)) charCountMap.put(c, charCountMap.get(c) + 1);
                else charCountMap.put(c, 1);
            }
        }

        //Чтение зашифрованного файла
        String encryptedFile;
        try {
            encryptedFile = Files.readString(Path.of("encryptedFile.txt"));
        } catch (IOException e) {
            System.out.println("Файл для расшифровки не найден, возможно нужно сначала зашифровать текст");
            return 0;
        }
        //подсчет количества каждого char в зашифрованном тексте
        HashMap<Character, Integer> encryptedCharCountMap = new HashMap<>();

        for (int i = 0; i < encryptedFile.length(); i++) {
            char c = encryptedFile.charAt(i);

            if (Encryption.allSymbolsStr.contains(String.valueOf(c))) {
                if (encryptedCharCountMap.containsKey(c))
                    encryptedCharCountMap.put(c, encryptedCharCountMap.get(c) + 1);
                else encryptedCharCountMap.put(c, 1);
            }
        }

        //статистический анализ, поиск ключа
        Character maxChar = null, maxChar2 = null;
        Integer maxValue = null, maxValue2 = null;
        int[] keyArr = new int[3];
        int keyInt = 0;

        for (int i = 0; i < 3; i++) {

            for (var entry : charCountMap.entrySet()) {
                maxValue = (Collections.max(charCountMap.values()));
                if (entry.getValue().equals(maxValue)) {
                    maxChar = entry.getKey();
                    charCountMap.remove(maxChar);
                    break;
                }
            }

            for (var entry2 : encryptedCharCountMap.entrySet()) {
                maxValue2 = (Collections.max(encryptedCharCountMap.values()));
                if (entry2.getValue().equals(maxValue2)) {
                    maxChar2 = entry2.getKey();
                    encryptedCharCountMap.remove(maxChar2);
                    break;
                }
            }

            if (Objects.equals(maxValue, maxValue2) && maxChar != null && maxChar2 != null) {
                keyArr[i] = Encryption.allSymbolsStr.indexOf(maxChar) - Encryption.allSymbolsStr.indexOf(maxChar2);
            }
        }

        if (keyArr[0] == keyArr[1] && keyArr[1] == keyArr[2]) {
            keyInt = keyArr[0];
            System.out.println("Ключ безопасности равен " + keyInt);
        }

        return keyInt;
    }
}
