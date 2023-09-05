public class Encryption {
    public static void encryption(String filePath, int keyInt) {
        String unencryptedText = Actions.readText(filePath);

        Actions.writeText(unencryptedText, Constants.unencryptedFile);

        String encryptedText = encryption(keyInt, unencryptedText);

        Actions.writeText(encryptedText, Constants.encryptedFile);
    }

    private static String encryption(int keyInt, String unencryptedText) {
        char[] allTextCharArr = unencryptedText.toCharArray();

        for (int i = 0; i < allTextCharArr.length; i++) {
            if (Constants.allSymbolsStr.contains(Character.toString(allTextCharArr[i]))) {
                int index = Constants.allSymbolsStr.indexOf(allTextCharArr[i]);

                if ((index + keyInt) >= Constants.lengthAlphabet){
                    index -= Constants.lengthAlphabet;
                }

                allTextCharArr[i] = Constants.allSymbolsChar[index + keyInt];
            }
        }

        return new String(allTextCharArr);
    }
}
