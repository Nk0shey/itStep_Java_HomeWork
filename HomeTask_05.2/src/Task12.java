/*
Напишіть програму, яка підрахує кількість смайликів у
заданому тексті.
Смайликом вважатиметься послідовність символів із
наступними заданими умовами:
■ першим символом є або ";" (крапка з комою) або
":" (двокрапка) один раз;
■ далі може йти символ "-" (мінус) будь-яку кількість разів (у
тому числі символ "-" може йти 0 разів);
■ в кінці обов'язково йде певна кількість(не менше однієї)
однакових дужок з наступного набору: (, ), [, ];
■ всередині смайлика не може бути ніяких іншихсимволів.
Наприклад, нижченаведені послідовності є смайликами:
:)
;---------[[[[[[[[
в той час, як нижченаведені послідовності не є смайликами
(хоча деякі з них містять смайлики):
:-)]
;--
-)
::-(
:-()
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть текст: ");
        String input = scanner.nextLine();

        String smileyPattern = "[:;]-*\\[{1,}|[:;]-*\\]{1,}|[:;]-*\\({1,}|[:;]-*\\){1,}";

        Pattern pattern = Pattern.compile(smileyPattern);
        Matcher matcher = pattern.matcher(input);

        int smileyCount = 0;

        while (matcher.find()) {
            smileyCount++;
        }

        System.out.println("Кількість смайликів в тексті: " + smileyCount);

        scanner.close();
    }
}
