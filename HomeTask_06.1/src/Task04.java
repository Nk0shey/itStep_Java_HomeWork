/*
На рисунку показаний приклад трикутника з чисел.
Напишіть метод:
 який виводить значення трикутника в консоль у такому вигляді, як зображено
на рисунку;
 який обчислює найбільшу суму чисел, через які проходить шлях, що
починається на вершині трикутника і закінчується на його основі.
1. Кожен крок може йти по діагоналі вниз і праворуч, або по діагоналі вниз і
ліворуч.
2. Кількість рядків у трикутнику >1, але <100.
3. Трикутник складається з цілих чисел від 0 до 99 включно (генеруються
випадковим чином).
У прикладі, описаному вище, це шлях 7, 3, 8, 7, 5, з максимальною сумою 30.
Програма має виводити на екран трикутник і шлях, що дасть максимальний результат.
Для поточного прикладу він буде такий — ліворуч, ліворуч, праворуч, ліворуч.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task04 {

    private static final int MAX_VALUE = 99;
    private static int[][] triangle;

    public static void main(String[] args) {
        int rows = 5; // Кількість рядків у трикутнику (> 1 та < 100)
        generateTriangle(rows);
        displayTriangle();
        PathResult result = findMaxPathSum();
        System.out.println("\nМаксимальна сума шляху: " + result.maxSum);
        System.out.println("Шлях: " + result.pathValues);
        System.out.println("Напрямки: " + result.directions);
    }

    // Метод для генерації трикутника з випадковими значеннями
    public static void generateTriangle(int rows) {
        triangle = new int[rows][];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = random.nextInt(MAX_VALUE + 1);
            }
        }
    }

    // Метод для виведення трикутника у вигляді, як на зображенні
    public static void displayTriangle() {
        for (int i = 0; i < triangle.length; i++) {
            // Вивести пробіли для форматування трикутника
            for (int k = 0; k < triangle.length - i - 1; k++) {
                System.out.print(" ");
            }
            // Вивести числа в рядку
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Метод для обчислення максимальної суми шляху та збереження шляху
    public static PathResult findMaxPathSum() {
        int rows = triangle.length;
        int[][] maxSums = new int[rows][];
        String[][] directions = new String[rows][];

        // Ініціалізуємо maxSums і directions для кожного рядка
        for (int i = 0; i < rows; i++) {
            maxSums[i] = new int[i + 1];
            directions[i] = new String[i + 1];
        }

        // Заповнюємо останній рядок maxSums
        for (int i = 0; i < rows; i++) {
            maxSums[rows - 1][i] = triangle[rows - 1][i];
        }

        // Обчислюємо максимальну суму шляху, рухаючись вгору від передостаннього рядка
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (maxSums[i + 1][j] > maxSums[i + 1][j + 1]) {
                    maxSums[i][j] = triangle[i][j] + maxSums[i + 1][j];
                    directions[i][j] = "ліворуч";
                } else {
                    maxSums[i][j] = triangle[i][j] + maxSums[i + 1][j + 1];
                    directions[i][j] = "праворуч";
                }
            }
        }

        // Збираємо шлях і напрямки
        List<Integer> pathValues = new ArrayList<>();
        List<String> pathDirections = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < rows; i++) {
            pathValues.add(triangle[i][j]);
            if (i < rows - 1) {
                pathDirections.add(directions[i][j]);
                if (directions[i][j].equals("праворуч")) {
                    j++;
                }
            }
        }

        return new PathResult(maxSums[0][0], pathValues, pathDirections);
    }
}

// Клас для зберігання результатів обчислень
class PathResult {
    int maxSum;
    List<Integer> pathValues;
    List<String> directions;

    public PathResult(int maxSum, List<Integer> pathValues, List<String> directions) {
        this.maxSum = maxSum;
        this.pathValues = pathValues;
        this.directions = directions;
    }
}
