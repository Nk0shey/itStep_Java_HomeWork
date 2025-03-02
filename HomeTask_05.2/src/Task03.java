/*
Підрахуйте середню довжину слова у введеному реченні з
клавіатури
 */

import java.util.Scanner;

public class Task03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть речення: ");
        String sentence = scanner.nextLine();

        String[] words = sentence.split("\\s+");

        int totalLength = 0;
        for (String word : words) {
            totalLength += word.length();
        }

        double averageLength = (double) totalLength / words.length;
        System.out.println("Середнє довжина слова у реченні: " + String.format("%.2f", averageLength));

        scanner.close();
    }
}
