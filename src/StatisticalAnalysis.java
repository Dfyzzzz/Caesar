import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class StatisticalAnalysis {
    public static int analysis() {
        String unencryptedText = Actions.readText(Constants.unencryptedFile);
        String encryptedText = Actions.readText(Constants.encryptedFile);

        HashMap<Character, Integer> unencryptedCharCountMap = charCounterMap(unencryptedText);
        HashMap<Character, Integer> encryptedCharCountMap = charCounterMap(encryptedText);

        int[] keyArr = new int[3];
        int keyInt = 0;

        System.out.println("Наиболее часто встречающиеся символы в незашифрованном и зашифрованном тексте:");
        for (int i = 0; i < keyArr.length; i++) {
            ArrayList<Object> mostPopularUnencryptedSymbolAndHisValue = searchSymbolAndHisValue(unencryptedCharCountMap);
            ArrayList<Object> mostPopularEncryptedSymbolAndHisValue = searchSymbolAndHisValue(encryptedCharCountMap);

            keyArr[i] = searchKeyByIndexDifference (mostPopularUnencryptedSymbolAndHisValue, mostPopularEncryptedSymbolAndHisValue);
        }

        if (keyArr[0] == keyArr[1] && keyArr[1] == keyArr[2]) {
            keyInt = keyArr[0];
            System.out.println("Ключ безопасности равен " + keyInt);
        }

        return keyInt;
    }

    private static int searchKeyByIndexDifference(ArrayList<Object> unencryptedSymbolAndHisValue, ArrayList<Object> encryptedSymbolAndHisValue){
        int firstIndex = 0;
        int secondIndex = 0;

        if (Objects.equals(unencryptedSymbolAndHisValue.get(1), encryptedSymbolAndHisValue.get(1))) {
            firstIndex = Constants.allSymbolsStr.indexOf((char)unencryptedSymbolAndHisValue.get(0));
            secondIndex = Constants.allSymbolsStr.indexOf((char)encryptedSymbolAndHisValue.get(0));

            if (firstIndex > secondIndex) {
                firstIndex -= Constants.lengthAlphabet;
            }
        }

        return Math.abs(firstIndex - secondIndex);
    }

    private static ArrayList<Object> searchSymbolAndHisValue(HashMap <Character, Integer> charCountMap){
        ArrayList<Object> symbolAndHisValue = new ArrayList<>();

        for (var entry : charCountMap.entrySet()) {
            Integer maxValue = (Collections.max(charCountMap.values()));

            if (entry.getValue().equals(maxValue)) {
                Character mostPopularSymbol = entry.getKey();
                charCountMap.remove(mostPopularSymbol);

                System.out.printf("\"%c\" в количестве %d\n", mostPopularSymbol, maxValue);

                symbolAndHisValue.add(mostPopularSymbol);
                symbolAndHisValue.add(maxValue);
                break;
            }
        }

        return symbolAndHisValue;
    }

    private static HashMap<Character, Integer> charCounterMap(String text){
        HashMap<Character, Integer> charCounterMap = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Constants.allSymbolsStr.contains(String.valueOf(c))){
                if(charCounterMap.containsKey(c)) {
                    charCounterMap.put(c, charCounterMap.get(c) + 1);
                }
                else charCounterMap.put(c, 1);
            }
        }

        return charCounterMap;
    }
}
