public class Runner {
    public static void main(String[] args) {
        System.out.println("""
            Добрый день!
            С помощью данной программы вы можете зашифровать текст шифровкой Цезаря.
            Вот МЕНЮ для использования программы:
            * Нажмите ENTER, чтобы зашифровать текст по умолчанию
            * Нажмите 2,чтобы ввести и зашифровать свой текст
            * Нажмите 3,чтобы зашифровать текст "OneNineEightFourPart2.txt"
            ------------------------------------------------------------------------
            * Нажмите 4, чтобы расшифровать текст по ключу
            * Нажмите 5, чтобы расшифровать текст с помощью Brute Force
            * Нажмите 6, чтобы расшифровать текст с помощью статистического анализа
              (рекомендуется перед этим зашифровать файл "OneNineEightFourPart2.txt" для этого нажмите 3)""");
        int attempt = 3;
        do {
            //считывание команды
            String command = Actions.readLine();

            //реализация первого пункта меню(шифрование текста по умолчанию)
            if (command.isEmpty()) {
                Encryption.encryption("src/Text.txt", Actions.securityKeyEntry());
                break;
            }

            //реализация второго пункта меню(ввод и шифрование своего текста)
            else if (command.equals("2")) {
                System.out.println("Введите свой текст. По завершении введите \"end\", чтобы зашифровать текст");
                Encryption.encryption(Actions.readText(), Actions.securityKeyEntry());
                break;
            }

            //реализация третьего пункта меню(шифрование "OneNineEightFourPart2.txt")
            else if (command.equals("3")) {
                Encryption.encryption("src/OneNineEightFourPart2.txt", Actions.securityKeyEntry());
                break;
            }

            //реализация четвертого пункта меню(расшифровка по ключу)
            else if (command.equals("4")) {
                Decryption.decryption(Actions.securityKeyEntry());
                break;
            }

            //реализация пятого пункта меню(расшифровка BruteForce)
            else if (command.equals("5")) {
                System.out.println("Ключ безопасности равен " + BruteForce.bruteForce());
                break;
            }

            //реализация шестого пункта меню(расшифровка статистическим анализом)
            else if (command.equals("6")) {

                StatisticalAnalysis.StatisticalAnalysis();
                break;
            }

            //не верная команда
            else {
                System.out.println("""
                    Добрый день!
                    С помощью данной программы вы можете зашифровать текст шифровкой Цезаря.
                    Вот МЕНЮ для использования программы:
                    * Нажмите ENTER, чтобы зашифровать текст по умолчанию
                    * Нажмите 2,чтобы ввести и зашифровать свой текст
                    * Нажмите 3,чтобы зашифровать текст "OneNineEightFourPart2.txt"
                    ------------------------------------------------------------------------
                    * Нажмите 4, чтобы расшифровать текст по ключу
                    * Нажмите 5, чтобы расшифровать текст с помощью Brute Force
                    * Нажмите 6, чтобы расшифровать текст с помощью статистического анализа
                      (рекомендуется перед этим зашифровать файл "OneNineEightFourPart2.txt" для этого нажмите 3)""");
            }
            attempt--;
        }while (attempt>0);

        if(attempt == 0) System.out.println("\nПопробуйте в другой раз");
    }
}