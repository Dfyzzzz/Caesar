public class Runner {
    public static void main(String[] args) {
        System.out.println(Constants.MENU);

        switch (Actions.readLine()) {
            case "1" -> Encryption.encryption(Constants.defaultText, Actions.securityKeyEntry());
            case "2" -> {
                System.out.println("Введите свой текст. По завершении введите " + Constants.wordToEndTextInput + " , чтобы зашифровать текст");
                Encryption.encryption(Actions.userTextEntry(), Actions.securityKeyEntry());
            }
            case "3" -> Encryption.encryption(Constants.longText, Actions.securityKeyEntry());
            case "4" -> Decryption.decryption(Actions.securityKeyEntry());
            case "5" -> System.out.println("Ключ безопасности равен " + BruteForce.bruteForce());
            case "6" -> Decryption.decryption(StatisticalAnalysis.analysis());
        }
    }
}
