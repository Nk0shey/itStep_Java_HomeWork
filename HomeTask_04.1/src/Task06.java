import java.util.Scanner;

public class Task06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть рік, щоб визначити кількість днів та чи вискосний це рік");
        int year = scanner.nextInt();

        int daysInYear;
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            daysInYear = 366;
        } else {
            daysInYear = 365;
        }

        System.out.println("Кількість днів у році " + year + ": " + daysInYear);
    }
}
