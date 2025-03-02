/*
Напишіть і протестуйте перевантажений метод, який виводить на екран:
 одновимірний масив int;
 одновимірний масив String;
 двовимірний масив int;
 двовимірний масив float.
 */

public class Task02 {

    // Метод для виведення одновимірного масиву int
    public static void printArray(int[] array) {
        for (int element : array) {
            System.out.println(element + " ");
        }
        System.out.println();
    }

    // Метод для виведення одновимірного масиву String
    public static void printArray(String[] array) {
        for (String element : array) {
            System.out.println(element + " ");
        }
        System.out.println();
    }

    // Метод для виведення двовимірного масиву int
    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.println(element + " ");
            }
            System.out.println();
        }
    }

    // Метод для виведення двовимірного масиву float
    public static void printArray(float[][] array) {
        for (float[] row : array) {
            for (float element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Тестування кожного методу
        int[] intArray = {1, 2, 3, 4, 5};
        String[] stringArray = {"Hello", "World"};
        int[][] intMatrix = {{1, 2, 3}, {4, 5, 6}};
        float[][] floatMatrix = {{1.1f, 2.2f, 3.3f}, {4.4f, 5.5f, 6.6f}};

        System.out.println("Одномірний масив int: ");
        printArray(intArray);

        System.out.println("Одновимірний масив String: ");
        printArray(stringArray);

        System.out.println("Двовимірний масив int: ");
        printArray(intMatrix);

        System.out.println("Двовимірний масив float: ");
        printArray(floatMatrix);
    }
}
