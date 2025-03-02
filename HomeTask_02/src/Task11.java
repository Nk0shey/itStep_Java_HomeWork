import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть кількість секунд: ");
        int seconds = scanner.nextInt();

        int minutes = seconds / 60;
        int hours = minutes / 60;
        int days = hours / 24;
        int months = days / 30;

        days = days % 30;
        hours = hours % 24;
        minutes = minutes % 60;
        seconds = seconds % 60;

        StringBuilder result = new StringBuilder("До Нового Року залишилося: ");

        if (months >= 1) {
            result.append(months).append(" ").append(getCorrectForm(months, "місяць", "місяці", "місяців")).append(" ");
        }

        if (days >= 1) {
            result.append(days).append(" ").append(getCorrectForm(days, "день", "дні", "днів")).append(" ");
        }

        if (hours >= 1) {
            result.append(hours).append(" ").append(getCorrectForm(hours, "година", "години", "годин")).append(" ");
        }

        if (minutes >= 1) {
            result.append(minutes).append(" ").append(getCorrectForm(minutes, "хвилина", "хвилини", "хвилин")).append(" ");
        }

        if (seconds >= 1) {
            result.append(seconds).append(" ").append(getCorrectForm(seconds, "секунда", "секунди", "секунд")).append(" ");
        }

        System.out.println(result.toString());

        scanner.close();
    }

    public static String getCorrectForm(int number, String form1, String form2, String form3) {
        number = number % 100;
        if (number >= 11 && number <= 19) {
            return form3;
        }
        number = number % 10;
        switch (number) {
            case 1:
                return form1;
            case 2:
            case 3:
            case 4:
                return form2;
            default:
                return form3;
        }
    }
}
