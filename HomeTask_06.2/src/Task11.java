/*
Дана шахова дошка розміром 8х8 і шаховий кінь. Програма
має запросити у користувача координати клітинки поля і
поставити туди коня. Завдання програми: методом перебору
знайти шлях для ходу конем, при якому кінь відвідає всі клітини
дошки, потрапляючи в кожну клітку тільки один раз.
 */

public class Task11 {
    public static final int N = 8;

    public static boolean knightTour(int position, int visited, int moveCount) {
        if (moveCount == N * N) return true;

        int x = position / N;
        int y = position % N;

        int[][] moves = {
                {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
                {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
        };

        for (int[] move : moves) {
            int nextX = x + move[0];
            int nextY = y + move[1];

            if (isValid(nextX, nextY, visited)) {
                int nextPosition = nextX * N + nextY;
                visited |= (1 << nextPosition); // Отмечаем клетку как посещенную
                if (knightTour(nextPosition, visited, moveCount + 1)) return true;
                visited &= ~(1 << nextPosition); // Отменяем посещение
            }
        }

        return false;
    }

    public static boolean isValid(int x, int y, int visited) {
        if (x < 0 || x >= N || y < 0 || y >= N) return false; // Проверяем границы доски
        int position = x * N + y;
        return (visited & (1 << position)) == 0; // Проверяем, не посещена ли клетка
    }

    public static void main(String[] args) {
        int startX = 0, startY = 0;
        int start = startX * N + startY;
        int visited = (1 << start); // Отмечаем начальную клетку как посещенную

        if (knightTour(start, visited, 1)) {
            System.out.println("Решение найдено!");
        } else {
            System.out.println("Решение не найдено.");
        }
    }
}
