import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть день, місяць і рік народження:");
        System.out.println("День: ");
        int day = scanner.nextInt();
        System.out.println("Місяць: ");
        int month = scanner.nextInt();
        System.out.println("Рік: ");
        int year = scanner.nextInt();

        String zodiacSign = determineZodiacSign (day, month);
        System.out.println("Знак зодіаку: " + zodiacSign);
        String chineseYear = determineChineseYear (year);
        System.out.println("Рік за китайським календарем: " + chineseYear);

        scanner.close();
    }

    public static String determineZodiacSign (int day, int month) {
        switch (month) {
            case 1:
                return (day < 20) ? "Козеріг" : "Водолій";
            case 2:
                return (day < 20) ? "Водолій" : "Риби";
            case 3:
                return (day < 21) ? "Риби" : "Овен";
            case 4:
                return (day < 21) ? "Овен" : "Телець";
            case 5:
                return (day < 21) ? "Телець" : "Близнюки";
            case 6:
                return (day < 21) ? "Близнюки" : "Рак";
            case 7:
                return (day < 23) ? "Рак" : "Лев";
            case 8:
                return (day < 23) ? "Лев" : "Діва";
            case 9:
                return (day < 23) ? "Діва" : "Терези";
            case 10:
                return (day < 23) ? "Терези" : "Скорпіон";
            case 11:
                return (day < 23) ? "Скорпіон" : "Стрілець";
            case 12:
                return (day < 22) ? "Стрілець" : "Козеріг";
            default:
                return "Невірна дата";
        }
    }

    public static String determineChineseYear (int year) {
        String[] chineseZodiac = {"Щур", "Бик", "Тигр", "Кролик", "Дракон", "Змія", "Кінь", "Коза", "Мавпа", "Півень", "Собака", "Свиня"};
        int index = (year - 1900) % 12;
        return chineseZodiac [index];
    }
}
