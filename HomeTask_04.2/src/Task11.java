/*
Напишіть програму, яка виводить на екран числа від 1 до 1000.
При цьому замість чисел, кратних трьом, програма має вивести
слово fizz, а замість чисел, кратних п'яти — слово buzz. Якщо
число кратне п'ятнадцяти, то програма має виводити замість
числа слово hiss.
 */

public class Task11 {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0) {
                System.out.println("fizz");
            } else if (i % 5 == 0) {
                System.out.println("buzz");
            } else if (i % 15 == 0) {
                System.out.println("hiss");
            } else {
                System.out.println(i);
            }
        }
    }
}