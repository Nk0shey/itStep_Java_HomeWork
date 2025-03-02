import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть кількість квартир на поверсі: ");
        int M = scanner.nextInt();

        System.out.println("Введіть номер квартири: ");
        int N = scanner.nextInt();

        int apartmentsPerEntrance = M * 9;

        int entrance = (N + apartmentsPerEntrance - 1) / apartmentsPerEntrance;

        System.out.println("Номер під'їзду: " + entrance);
    }
}
