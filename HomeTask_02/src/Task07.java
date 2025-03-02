import java.util.Scanner;

public class Task07 {

    public static final double PERCENT = 5.0;
    public static final int TIME = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть суму вкладу: ");
        double sum = scanner.nextDouble();

        double res = (sum * PERCENT * TIME)/100;
        System.out.println("Розрахунковий інвестиційний дохід за два роки: " + res);
        System.out.println("Розрахована сума вкладу через два роки: " + (sum + res));
    }
}
