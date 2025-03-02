package Task06;

import java.util.concurrent.atomic.AtomicInteger;

public class LibraryCard {
    private static final AtomicInteger idGenerator = new AtomicInteger(1); // Генерація унікальних номерів
    private final int cardNumber;
    private String firstName;
    private String lastName;
    private String groupNumber;

    public LibraryCard(String firstName, String lastName, String groupNumber) {
        this.cardNumber = idGenerator.getAndIncrement();
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupNumber = groupNumber;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getFullName() {
        return lastName + " " + firstName;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    @Override
    public String toString() {
        return "Квиток №" + cardNumber + ", Студент: " + getFullName() + ", Група: " + groupNumber;
    }
}

