public class Decryption {
    public static void decryption(int keyInt) {
        String encryptedString = Actions.readText(Constants.encryptedFile);

        String decryptedText = decryption(keyInt, encryptedString);

        Actions.writeText(decryptedText, Constants.decryptedFile);
    }

    public static String decryption(int keyInt, String encryptedString) {
        char[] allTextCharArr = encryptedString.toCharArray();

        for (int i = 0; i < allTextCharArr.length; i++) {
            if (Constants.allSymbolsStr.contains(Character.toString(allTextCharArr[i]))) {
                int index = Constants.allSymbolsStr.indexOf(allTextCharArr[i]);

                if ((index - keyInt) < 0) {
                    index += Constants.lengthAlphabet;
                }

                allTextCharArr[i] = Constants.allSymbolsChar[index - keyInt];
            }
        }

        return new String(allTextCharArr);
    }
}
