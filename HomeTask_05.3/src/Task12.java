/*
Програма має виводити слова Yes для симетричного масиву, та
No — для несиметричного. Симетричним вважається масив, в
якому значення елементів зкінця дорівнює значенню елементів
на початку. Масив задається та ініціалізується на початку
програми.
Приклади значень для симетричного масиву:
1, 2, 3, 2, 1
2, 2, 3, 2, 2
1, 3, 2, 3, 1
5, 4, 3, 4, 5
 */


public class Task12 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 1};

        boolean isSymmetric = true;

        for (int i = 0; i < array.length / 2; i++) {
            if (array[i] != array[array.length - 1 - i]) {
                isSymmetric = false;
                break;
            }
        }

        if (isSymmetric) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
