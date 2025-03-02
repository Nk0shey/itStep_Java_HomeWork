package Task04;

import java.io.*;
import java.util.*;

public class GameOfLife {
    private int[][] field;
    private int rows;
    private int cols;

    public GameOfLife(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.field = new int[rows][cols];
    }

    // Метод для отображения поля
    public void displayField() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Метод для обновления состояния поля
    public void updateField() {
        int[][] newField = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int neighbors = countNeighbors(i, j);

                if (field[i][j] == 1) {
                    if (neighbors < 2 || neighbors > 3) {
                        newField[i][j] = 0;  // Клетка умирает
                    } else {
                        newField[i][j] = 1;  // Клетка остаётся живой
                    }
                } else {
                    if (neighbors == 3) {
                        newField[i][j] = 1;  // Клетка рождается
                    }
                }
            }
        }

        field = newField;
    }

    // Метод для подсчёта соседей живых клеток
    private int countNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;

                int newRow = row + i;
                int newCol = col + j;

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    count += field[newRow][newCol];
                }
            }
        }
        return count;
    }

    // Метод для сохранения конфигурации в файл
    public void saveConfiguration(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    writer.write(field[i][j] + " ");
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving configuration: " + e.getMessage());
        }
    }

    // Метод для загрузки конфигурации из файла
    public void loadConfiguration(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                for (int col = 0; col < values.length; col++) {
                    field[row][col] = Integer.parseInt(values[col]);
                }
                row++;
            }
        } catch (IOException e) {
            System.out.println("Error loading configuration: " + e.getMessage());
        }
    }

    // Метод для импорта комбинаторных данных из файла
    public void importCombinations(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    field[x][y] = 1;
                }
            }
        } catch (IOException e) {
            System.out.println("Error importing combinations: " + e.getMessage());
        }
    }

    // Главный метод для запуска игры
    public static void main(String[] args) {
        GameOfLife game = new GameOfLife(10, 10);

        // Пример начальной конфигурации (глайдер)
        game.field[1][2] = 1;
        game.field[2][3] = 1;
        game.field[3][1] = 1;
        game.field[3][2] = 1;
        game.field[3][3] = 1;

        // Отображаем начальное поле
        System.out.println("Initial Configuration:");
        game.displayField();

        // Обновляем поле и отображаем каждый шаг
        for (int i = 0; i < 5; i++) {
            System.out.println("\nStep " + (i + 1) + ":");
            game.updateField();
            game.displayField();
        }

        // Сохранение и загрузка конфигурации
        game.saveConfiguration("game_config.txt");
        game.loadConfiguration("game_config.txt");
    }
}

