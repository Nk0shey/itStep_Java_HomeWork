/*
Досконале число — натуральне число, що дорівнює сумі всіхсвоїх
власних дільників (тобто всіх додатнихдільників, відмінних від
самого числа).
Виведіть на екран всі досконалі числа в діапазоні від 0 до
1 000 000.
Приклади:
1-е досконале число: 6 має наступні власнідільники: 1, 2, 3; їх
сума дорівнює 6.
2-е досконале число: 28 має наступні власнідільники: 1, 2, 4, 7, 14;
їх сума дорівнює 28.
 */

public class Task04 {
    public static void main(String[] args) {
        int lowerLimit = 0;
        int upperLimit = 1000000;
        for (int number = lowerLimit; number < upperLimit; number++) {
            if (isPerfectNumber(number)) {
                System.out.println(number);
            }
        }
    }

    public static boolean isPerfectNumber(int number) {
        int sum = 0;
        for(int j = 1; j <= number/2; j++) {
            if (number % j == 0) {
                sum += j;
            }
        }
        return (sum == number);
    }
}
