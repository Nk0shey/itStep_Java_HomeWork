/*
До завдання 1 додайте можливість перевірки, чи
перетинаються різні діапазони значень
 */

package Task01and02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OverlapTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Range> ranges = new ArrayList<>();

        System.out.println("Введите количество диапазонов:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Введите начало и конец диапазона:");
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            try {
                ranges.add(new Range(start, end));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Проверка пересечений:");
        for (int i = 0; i < ranges.size(); i++) {
            for (int j = i + 1; j < ranges.size(); j++) {
                if (overlaps(ranges.get(i), ranges.get(j))) {
                    System.out.println("Диапазоны пересекаются: "
                            + "Range " + i + " (" + ranges.get(i).getLength() + ") и "
                            + "Range " + j + " (" + ranges.get(j).getLength() + ")");
                }
            }
        }
    }

    // Метод для проверки пересечения диапазонов
    public static boolean overlaps(Range range1, Range range2) {
        return Math.max(range1.getStart(), range2.getStart()) <= Math.min(range1.getEnd(), range2.getEnd());
    }
}
