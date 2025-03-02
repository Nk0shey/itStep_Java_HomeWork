package Task03;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final String FILE_NAME = "calculator_history.txt";

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        ArrayList<String> history = loadHistoryFromFile();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nКалькулятор:");
            System.out.println("1. Сложение");
            System.out.println("2. Вычитание");
            System.out.println("3. Умножение");
            System.out.println("4. Деление");
            System.out.println("5. Показать историю");
            System.out.println("6. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите первое число: ");
                    double a = scanner.nextDouble();
                    System.out.print("Введите второе число: ");
                    double b = scanner.nextDouble();
                    double result = calculator.add(a, b);
                    System.out.println("Результат: " + result);
                    saveOperationToFile(a + " + " + b + " = " + result);
                }
                case 2 -> {
                    System.out.print("Введите первое число: ");
                    double a = scanner.nextDouble();
                    System.out.print("Введите второе число: ");
                    double b = scanner.nextDouble();
                    double result = calculator.subtract(a, b);
                    System.out.println("Результат: " + result);
                    saveOperationToFile(a + " - " + b + " = " + result);
                }
                case 3 -> {
                    System.out.print("Введите первое число: ");
                    double a = scanner.nextDouble();
                    System.out.print("Введите второе число: ");
                    double b = scanner.nextDouble();
                    double result = calculator.multiply(a, b);
                    System.out.println("Результат: " + result);
                    saveOperationToFile(a + " * " + b + " = " + result);
                }
                case 4 -> {
                    System.out.print("Введите первое число: ");
                    double a = scanner.nextDouble();
                    System.out.print("Введите второе число: ");
                    double b = scanner.nextDouble();
                    try {
                        double result = calculator.divide(a, b);
                        System.out.println("Результат: " + result);
                        saveOperationToFile(a + " / " + b + " = " + result);
                    } catch (ArithmeticException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.println("\nИстория операций:");
                    for (String operation : history) {
                        System.out.println(operation);
                    }
                }
                case 6 -> {
                    System.out.println("Выход из программы.");
                    running = false;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    // Метод для сохранения операции в файл
    public static void saveOperationToFile(String operation) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(operation);
            writer.newLine();
            System.out.println("Операция сохранена: " + operation);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении операции: " + e.getMessage());
        }
    }

    // Метод для загрузки истории из файла
    public static ArrayList<String> loadHistoryFromFile() {
        ArrayList<String> history = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                history.add(line);
            }
            System.out.println("История успешно загружена!");
        } catch (FileNotFoundException e) {
            System.out.println("История отсутствует, будет создан новый файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке истории: " + e.getMessage());
        }
        return history;
    }
}

