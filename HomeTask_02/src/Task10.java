import java.util.Scanner;

public class Task10 {
    public static final double DEFAULT_HEIGHT = 175.0;
    public static final double DEFAULT_WEIGHT = 70.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть зріст (натисніть Enter для значення за замовчуванням - " + DEFAULT_HEIGHT + " см): ");
        String inputHeight = scanner.nextLine();
        double height = inputHeight.isEmpty() ? DEFAULT_HEIGHT : Double.parseDouble(inputHeight);

        System.out.print("Введіть вагу (натисніть Enter для значення за замовчуванням - " + DEFAULT_WEIGHT + " кг): ");
        String inputWeight = scanner.nextLine();
        double weight = inputWeight.isEmpty() ? DEFAULT_WEIGHT : Double.parseDouble(inputWeight);

        double idealWeight = height - 110;

        double weightDiff = weight - idealWeight;

        if (weightDiff > 0.0) {
            System.out.println("Вам потрібно скинути: " + Math.abs(weightDiff) + " кг.");
        } else if (weightDiff < 0.0) {
            System.out.println("Вам потрібно набрати: " + Math.abs(weightDiff) + " кг.");
        } else {
            System.out.println("Ваша вага ідеальна!");
        }
    }
}
