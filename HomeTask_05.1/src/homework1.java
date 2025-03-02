import java.util.stream.IntStream;

public class homework1 {
            public static void main(String[] args) {
                int[] numbers = {10, 20, 30, 40, 50};

                // Вычисление суммы с использованием Stream API
                int sum = IntStream.of(numbers).sum();

                // Вычисление среднего арифметического с использованием Stream API
                double average = IntStream.of(numbers).average().orElse(0);

                // Вывод результата
                System.out.println("Sum: " + sum);
                System.out.println("Average: " + average);
            }
}

