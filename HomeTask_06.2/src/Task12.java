/*
На квадратній дошці розміром NхN, розміщені випадкові, цілі,
додатні числа. Черепашка, що знаходиться в лівому верхньому
кутку, мріє потрапити у правий нижній. При цьому, вона може
переповзати тільки в клітинку справа або в клітинку знизу (не по
діагоналі), і хоче, щоб сума всіх чисел, які трапилися їй на шляху, була
максимально можливою.
Виведіть на екрані консолі цю суму. Покажіть траєкторію
просування черепашки. Покажіть початковий масив у вигляді
таблиці.
 */

public class Task12 {
    public static int getCellValue(int x, int y) {
        // Пример данных, которые черепашка встречает на пути
        // (реализуем как функцию, вместо использования массива)
        int[][] board = {
                {3, 2, 1},
                {1, 9, 1},
                {0, 3, 5}
        };
        return board[x][y];
    }

    public static int findMaxSum(int x, int y, int size) {
        if (x == size - 1 && y == size - 1) return getCellValue(x, y); // Базовый случай
        if (x >= size || y >= size) return 0; // Вышли за границы

        int right = findMaxSum(x, y + 1, size); // Движение вправо
        int down = findMaxSum(x + 1, y, size); // Движение вниз

        return getCellValue(x, y) + Math.max(right, down); // Максимальная сумма пути
    }

    public static void main(String[] args) {
        int size = 3; // Размер доски
        System.out.println("Максимальная сумма пути: " + findMaxSum(0, 0, size)); // Пример: 20
    }
}
