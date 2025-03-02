/*
Напишіть і протестуйте методи роботи з квадратними матрицями (матриці подати у
вигляді двовимірних масивів).
Мають бути методи:
 створення одиничної (діагональної) матриці;
 створення нульової матриці;
 додавання матриць;
 множення матриць;
 множення матриці на скаляр;
 визначення детермінанта матриці;
 виведення матриці в консоль.
 */


public class Task01 {

    // Створення одиничної матриці
    public static int[][] createIdentityMatrix(int size) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
        return matrix;
    }

    // Створення нульової матриці
    public static int[][] createZeroMatrix(int size) {
        return new int[size][size];
    }

    // Додавання двох матриць
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int size = matrix1.length;
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    // Множення двох матриць
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int size = matrix1.length;
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = 0;
                for (int k = 0; k < size; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    // Множення матриці на скаляр
    public static int[][] multiplyMatrixByScalar(int[][] matrix, int scalar) {
        int size = matrix.length;
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = matrix[i][j] * scalar;
            }
        }
        return result;
    }

    // Обчислення детермінанту матриці (тільки для 2x2 або 3x3 матриць)
    public static int determinant(int[][] matrix) {
        int size = matrix.length;
        if (size == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else if (size == 3) {
            return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                    - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                    + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        } else {
            throw new UnsupportedOperationException("Детермінант підтримується лише для матриць розміру 2x2 або 3x3");
        }
    }

    // Виведення матриці в консоль
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main (String[] args) {
        int size = 3;

        int[][] identityMatrix = createIdentityMatrix(size);
        System.out.println("Одинична матриця:");
        printMatrix(identityMatrix);

        int[][] zeroMatrix = createZeroMatrix(size);
        System.out.println("\nНульова матриця:");
        printMatrix(zeroMatrix);

        int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};

        System.out.println("\nДодавання матриць:");
        printMatrix(addMatrices(matrix1, matrix2));

        System.out.println("\nМноження матриць:");
        printMatrix(multiplyMatrices(matrix1, matrix2));

        System.out.println("\nМноження матриці на скаляр:");
        printMatrix(multiplyMatrixByScalar(matrix1, 2));

        System.out.println("\nДетермінант матриці:");
        System.out.println(determinant(matrix1));
    }
}
