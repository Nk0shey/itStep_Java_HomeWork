package Task02;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String fileName = "tasks.txt"; // Файл для хранения задач

        // Загружаем задачи из файла
        ArrayList<Task> tasks = loadTasksFromTextFile(fileName);

        // Добавляем новые задачи (пример)
        Task task1 = new Task("Создать отчет", "Отчет по проекту для клиента", 1, LocalDate.now(),
                LocalDate.now().plusDays(7), "Иван Иванов");
        tasks.add(task1);

        Task task2 = new Task("Подготовка презентации", "Создать слайды для встречи", 2, LocalDate.now(),
                LocalDate.now().plusDays(3), "Анна Петрова");
        tasks.add(task2);

        // Сохраняем задачи в текстовый файл
        saveTasksToTextFile(tasks, fileName);

        // Загружаем и выводим задачи для проверки
        ArrayList<Task> loadedTasks = loadTasksFromTextFile(fileName);
        for (Task task : loadedTasks) {
            System.out.println(task);
        }
    }

    // Метод для сохранения задач в текстовый файл
    public static void saveTasksToTextFile(ArrayList<Task> tasks, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Task task : tasks) {
                writer.write(task.getTitle() + "|" + task.getDescription() + "|" + task.getPriority() + "|" +
                        task.getCreatedDate() + "|" + task.getDueDate() + "|" + task.getAssignee() + "|" +
                        task.isCompleted());
                writer.newLine();
            }
            System.out.println("Задачи успешно сохранены в текстовый файл!");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении задач: " + e.getMessage());
        }
    }

    // Метод для загрузки задач из текстового файла
    public static ArrayList<Task> loadTasksFromTextFile(String fileName) {
        ArrayList<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 7) {
                    String title = parts[0];
                    String description = parts[1];
                    int priority = Integer.parseInt(parts[2]);
                    LocalDate createdDate = LocalDate.parse(parts[3]);
                    LocalDate dueDate = LocalDate.parse(parts[4]);
                    String assignee = parts[5];
                    boolean isCompleted = Boolean.parseBoolean(parts[6]);
                    Task task = new Task(title, description, priority, createdDate, dueDate, assignee);
                    if (isCompleted) {
                        task.markAsCompleted();
                    }
                    tasks.add(task);
                }
            }
            System.out.println("Задачи успешно загружены из текстового файла!");
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден, будет создан новый список задач.");
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке задач: " + e.getMessage());
        }
        return tasks;
    }
}
