package Task06;

import java.time.LocalDate;
import java.util.*;

public class Library {
    private Map<Integer, LibraryCard> libraryCards = new HashMap<>();
    private List<BookRecord> bookRecords = new ArrayList<>();

    public LibraryCard issueLibraryCard(String firstName, String lastName, String groupNumber) {
        LibraryCard card = new LibraryCard(firstName, lastName, groupNumber);
        libraryCards.put(card.getCardNumber(), card);
        return card;
    }

    public void issueBook(String bookTitle, String bookAuthor, int cardNumber, int daysToReturn) {
        if (!libraryCards.containsKey(cardNumber)) {
            throw new IllegalArgumentException("Читацький квиток №" + cardNumber + " не знайдено.");
        }
        bookRecords.add(new BookRecord(bookTitle, bookAuthor, cardNumber, LocalDate.now(), daysToReturn));
    }

    public void returnBook(String bookTitle, int cardNumber) {
        for (BookRecord record : bookRecords) {
            if (record.getCardNumber() == cardNumber && record.toString().contains(bookTitle) && record.returnDate == null) {
                record.returnBook(LocalDate.now());
                return;
            }
        }
        throw new IllegalArgumentException("Книга \"" + bookTitle + "\" для квитка №" + cardNumber + " не знайдена.");
    }

    public List<LibraryCard> getOverdueStudents(LocalDate currentDate) {
        List<LibraryCard> overdueStudents = new ArrayList<>();
        for (BookRecord record : bookRecords) {
            if (record.isOverdue(currentDate)) {
                overdueStudents.add(libraryCards.get(record.getCardNumber()));
            }
        }
        return overdueStudents;
    }
}

