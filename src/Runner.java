import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        System.out.println("""
                Добрый день!
                С помощью данной программы вы можете зашифровать текст с помощью шифровки Цезарь.
                Вот МЕНЮ для использования программы:
                * Нажмите ENTER, чтобы зашифровать текст по умолчанию
                * Нажмите 1,чтобы зашифровать свой текст""");
        //считывание строки пользователя
        String command = Actions.readLine();

        //реализация первого пункта меню
        if(command.isEmpty()) {
            Encoding.firstItem();
        }
        //реализация второго пункта меню
        else if(command.equals("1")){
            System.out.println("Введите свой текст");
        }

        //неизвестная команда
        else{
            int count = 3;
            while (count > 0){
                count--;
                System.out.println("""
                    Вы ввели не верную команду
                    * Нажмите ENTER, чтобы зашифровать текст по умолчанию
                    * Нажмите 1,чтобы зашифровать свой текст""");
                command = Actions.readLine();
                //реализация первого пункта меню
                if(command.isEmpty()) {
                    Encoding.firstItem();
                    return;
                }
                //реализация второго пункта меню
                else if(command.equals("1")){
                    System.out.println("Введите свой текст\n");
                    return;
                }

            }
            System.out.println("Попробуйте в другой раз");
        }






    }
}