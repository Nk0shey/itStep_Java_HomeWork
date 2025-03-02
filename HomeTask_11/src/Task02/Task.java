package Task02;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {
    private String title;
    private String description;
    private int priority; // 1 - высокий, 2 - средний, 3 - низкий
    private LocalDate createdDate;
    private LocalDate dueDate;
    private String assignee; // Исполнитель
    private boolean isCompleted;

    // Конструктор
    public Task(String title, String description, int priority, LocalDate createdDate, LocalDate dueDate, String assignee) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.createdDate = createdDate;
        this.dueDate = dueDate;
        this.assignee = assignee;
        this.isCompleted = false;
    }

    // Методы для получения и изменения полей
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getAssignee() {
        return assignee;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", createdDate=" + createdDate +
                ", dueDate=" + dueDate +
                ", assignee='" + assignee + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
