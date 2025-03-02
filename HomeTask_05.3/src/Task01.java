/*
Заповніть масив з 15 елементів числами Фібоначчі.
Виведіть в консоль тільки парні елементи масиву
 */


public class Task01 {
    public static void main(String[] args) {
        int[] fibonacciArray = new int[15];

        fibonacciArray[0] = 0;
        fibonacciArray[1] = 1;

        for (int i = 2; i < fibonacciArray.length; i++) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }

        System.out.println("Парні елементи масиву Фібоначчі:");
        for (int num : fibonacciArray) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
    }
}
