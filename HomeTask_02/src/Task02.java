public class Task02 {
    public static void main(String[] args) {
        int n = 125;
        int hundreds = n / 100;
        int tens = (n / 10) % 10;
        int ones = n % 10;
        int sum = hundreds + tens + ones;
        System.out.println("Сума цифр числа " + n + " = " + sum);
    }
}
