package Task06;

import java.time.LocalDate;

public class BookRecord {
    private String bookTitle;
    private String bookAuthor;
    private int cardNumber;
    private LocalDate issueDate;
    private int daysToReturn;
    public LocalDate returnDate; // Поле, доступ к которому осуществляется через геттер

    public BookRecord(String bookTitle, String bookAuthor, int cardNumber, LocalDate issueDate, int daysToReturn) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.cardNumber = cardNumber;
        this.issueDate = issueDate;
        this.daysToReturn = daysToReturn;
        this.returnDate = null; // Книга еще не возвращена
    }

    public void returnBook(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isOverdue(LocalDate currentDate) {
        if (returnDate != null) {
            return false; // Книга уже возвращена
        }
        return issueDate.plusDays(daysToReturn).isBefore(currentDate);
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public LocalDate getReturnDate() { // Геттер для поля returnDate
        return returnDate;
    }

    @Override
    public String toString() {
        return "Книга: " + bookTitle + " (" + bookAuthor + "), Видано на квиток №" + cardNumber +
                ", Дата видачі: " + issueDate + ", Повернути до: " + issueDate.plusDays(daysToReturn) +
                (returnDate != null ? ", Повернена: " + returnDate : ", Не повернена");
    }
}


