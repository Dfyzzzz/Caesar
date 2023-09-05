public class Constants {
    public static final String allSymbolsStr = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя.,”:-!? ";
    public static final char[] allSymbolsChar = allSymbolsStr.toCharArray();
    public static final int lengthAlphabet = allSymbolsChar.length;
    public static final String MENU = """
            Добрый день!
            С помощью данной программы вы можете зашифровать текст шифровкой Цезаря.
            Вот МЕНЮ для использования программы:
            * Нажмите 1, чтобы зашифровать текст по умолчанию
            * Нажмите 2,чтобы ввести и зашифровать свой текст
            * Нажмите 3,чтобы зашифровать текст "OneNineEightFour.txt"
            ------------------------------------------------------------------------
            * Нажмите 4, чтобы расшифровать текст по ключу
            * Нажмите 5, чтобы расшифровать текст с помощью Brute Force
            * Нажмите 6, чтобы расшифровать текст с помощью статистического анализа
              (рекомендуется перед этим зашифровать файл "OneNineEightFour.txt" для этого нажмите 3)""";
    public static final String unencryptedFile = "unencryptedFile.txt";
    public static final String encryptedFile = "encryptedFile.txt";
    public static final String decryptedFile = "decryptedFile.txt";
    public static final String defaultText = "src/Text.txt";
    public static final String longText = "src/OneNineEightFour.txt";
    public static String wordToEndTextInput = "end";


}
