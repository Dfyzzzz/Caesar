public class Runner {
    public static void main(String[] args) {
        System.out.println("""
                Добрый день!
                С помощью данной программы вы можете зашифровать текст шифровкой Цезаря.
                Вот МЕНЮ для использования программы:
                * Нажмите ENTER, чтобы зашифровать текст по умолчанию
                * Нажмите 2,чтобы ввести и зашифровать свой текст
                * Нажмите 3, чтобы расшифровать текст по ключу
                * Нажмите 4, чтобы расшифровать текст с помощью Brute Force""");

        //считывание строки пользователя
        String command = Actions.readLine();

        //реализация первого пункта меню
        if(command.isEmpty()) {
            Encryption.encryption("src/Text.txt");
            Encryption.encryptionDone = true;
        }

        //реализация второго пункта меню
        else if(command.equals("2")){
            System.out.println("Введите свой текст. По завершении введите \"end\", чтобы зашифровать текст");
            Encryption.encryption(Actions.readText());
            Encryption.encryptionDone = true;
        }

        //реализация третьего пункта меню
        else if(command.equals("3")){
            Decryption.decryption();
        }

        //реализация четвертого пункта меню
        else if(command.equals("4")){
            System.out.println("Ключ безопасности равен " + BruteForce.bruteForce());
        }

        //неизвестная команда
        else{
            int count = 3;
            while (count > 0){
                count--;
                System.out.println("""
                    Вы ввели не верную команду
                    * Нажмите ENTER, чтобы зашифровать текст по умолчанию
                    * Нажмите 2,чтобы ввести и зашифровать свой текст
                    * Нажмите 3, чтобы расшифровать текст по ключу
                    * Нажмите 4, чтобы расшифровать текст с помощью Brute Force""");
                //считывание строки пользователя
                command = Actions.readLine();

                //реализация первого пункта меню
                if(command.isEmpty()) {
                    Encryption.encryption("src/Text.txt");
                    Encryption.encryptionDone = true;
                }

                //реализация второго пункта меню
                else if(command.equals("2")){
                    System.out.println("Введите свой текст. По завершении введите \"end\", чтобы зашифровать текст");
                    Encryption.encryption(Actions.readText());
                    Encryption.encryptionDone = true;
                }

                //реализация третьего пункта меню
                else if(command.equals("3")){
                    Decryption.decryption();
                }

                //реализация четвертого пункта меню
                else if(command.equals("4")){
                    System.out.println("Ключ безопасности равен " + BruteForce.bruteForce());
                }

            }
            System.out.println("Попробуйте в другой раз");
        }
    }
}