package Task01;

import java.util.ArrayList;

public class Contact {
    private String firstName;
    private String lastName;
    private String nickName;
    private ArrayList<String> phoneNumbers;
    private ArrayList<String> emails;
    private int birthYear;

    public Contact(String firstName, String lastName, String nickName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.phoneNumbers = new ArrayList<>();
        this.emails = new ArrayList<>();
        this.birthYear = birthYear;
    }

    public void addPhoneNumber(String phoneNumber) {
        if(!phoneNumbers.contains(phoneNumber)) {
            phoneNumbers.add(phoneNumber);
        } else {
            System.out.println("Этот номер телефона уже добавлен.");
        }
    }

    public void addEmail(String email) {
        if(isValidEmail(email)) {
            if(!emails.contains(email)) {
            emails.add(email);
            } else {
                System.out.println("Этот адрес электронной почты уже добавлен.");
            }
        } else {
            System.out.println("Некорректный адрес электронной почты: " + email);
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public ArrayList<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public ArrayList<String> getEmails() {
        return emails;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public String toString() {
        return "Main.Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickname='" + nickName + '\'' +
                ", phoneNumbers=" + phoneNumbers +
                ", emails=" + emails +
                ", birthYear=" + birthYear +
                '}';
    }
}
