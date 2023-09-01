import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class StatisticalAnalysis {
    public static int analysis() {
        //Чтение незашифрованного файла
        String unencryptedStr;
        try {
            unencryptedStr = Files.readString(Path.of("unencryptedFile.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(unencryptedStr.length() <= Encryption.lengthAlphabet) {
            System.out.println("Текст слишком короткий для статистического анализа");
            return 0;
        }
        //подсчет количества каждого char в незашифрованном тексте
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < unencryptedStr.length(); i++) {
            char c = unencryptedStr.charAt(i);
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

        System.out.println("Наиболее часто встречающиеся символы:");
        for (int i = 0; i < keyArr.length; i++) {

            for (var entry : charCountMap.entrySet()) {
                maxValue = (Collections.max(charCountMap.values()));
                if (entry.getValue().equals(maxValue)) {
                    maxChar = entry.getKey();
                    charCountMap.remove(maxChar);
                    break;
                }
            }
            System.out.printf(" в незашифрованном тексте \"%c\" в количестве %d ---", maxChar, maxValue);


            for (var entry2 : encryptedCharCountMap.entrySet()) {
                maxValue2 = (Collections.max(encryptedCharCountMap.values()));
                if (entry2.getValue().equals(maxValue2)) {
                    maxChar2 = entry2.getKey();
                    encryptedCharCountMap.remove(maxChar2);
                    break;
                }
            }
            System.out.printf("в зашифрованном тексте \"%c\" в количестве %d\n", maxChar2, maxValue2);

            if (Objects.equals(maxValue, maxValue2)) {
                int index1 = Encryption.allSymbolsStr.indexOf(maxChar);
                int index2 = Encryption.allSymbolsStr.indexOf(maxChar2);

                if(index1 > index2) index1 -= Encryption.lengthAlphabet;

                keyArr[i] = Math.abs(index1 - index2);
            }
        }

        if (keyArr[0] == keyArr[1] && keyArr[1] == keyArr[2]) {
            keyInt = keyArr[0];
            System.out.println("Ключ безопасности равен " + keyInt);
        }

        return keyInt;
    }
}
