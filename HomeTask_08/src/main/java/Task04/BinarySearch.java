/*
Напишіть метод бінарного пошуку в одновимірному массиві.
Якщо масив не відсортований, метод має відкидати
перевірений виняток.
 */

package Task04;

class ArrayNotSortedException extends Exception {
    public ArrayNotSortedException(String message) {
        super(message);
    }
}

public class BinarySearch {

    // Метод бінарного пошуку
    public static int binarySearch(int[] array, int target) throws ArrayNotSortedException {
        if (!isSorted(array)) {
            throw new ArrayNotSortedException("Масив не відсортований. Бінарний пошук неможливий.");
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Знайшли елемент, повертаємо його індекс
            }
            if (array[mid] < target) {
                left = mid + 1; // Продовжуємо пошук у правій половині
            } else {
                right = mid - 1; // Продовжуємо пошук у лівій половині
            }
        }

        return -1; // Елемент не знайдено
    }

    // Метод для перевірки, чи масив відсортований
    private static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Тестовий приклад
    public static void main(String[] args) {
        try {
            int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            int[] unsortedArray = {3, 1, 4, 2};

            // Пошук у відсортованому масиві
            System.out.println("Індекс 5 у відсортованому масиві: " + binarySearch(sortedArray, 5));

            // Спроба пошуку в не відсортованому масиві
            System.out.println("Індекс 4 у не відсортованому масиві: " + binarySearch(unsortedArray, 4));
        } catch (ArrayNotSortedException e) {
            System.err.println(e.getMessage());
        }
    }
}
