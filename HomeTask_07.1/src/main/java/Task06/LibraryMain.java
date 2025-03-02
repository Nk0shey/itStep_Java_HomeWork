package Task06;

import java.time.LocalDate;

public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();

        // Видаємо читацькі квитки
        LibraryCard card1 = library.issueLibraryCard("Іван", "Петренко", "IT-01");
        LibraryCard card2 = library.issueLibraryCard("Марія", "Коваленко", "IT-02");

        System.out.println(card1);
        System.out.println(card2);

        // Видаємо книги
        library.issueBook("Програмування на Java", "Гордієнко", card1.getCardNumber(), 14);
        library.issueBook("Алгоритми", "Кнут", card2.getCardNumber(), 7);

        // Повернення книги
        library.returnBook("Програмування на Java", card1.getCardNumber());

        // Пошук боржників
        System.out.println("Боржники:");
        library.getOverdueStudents(LocalDate.now().plusDays(8)).forEach(System.out::println);
    }
}

