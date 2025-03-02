package Task01;/*
Напишіть програму «Телефонна книга».
В програмі мають бути можливості: створювати і зберігати нові
контакти; переглядати раніше збережені імена; шукати контакт
за номером телефону або за ім'ям.
Контакт може містити в собі:
 Ім'я;
 прізвище;
 прізвисько;
 номери телефонів (необмежену кількість, може бути
декілька з однаковим типом). Номери телефонів не мають
повторюватися для різних контактів.
 домашній;
 робочий;
 мобільний;
 факс.
 електронні адреси (перевірка на коректність);
 рік народження.
 */

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Contact contact1 = new Contact("John", "Doe", "Johnny", 1990);
        contact1.addPhoneNumber("123-456-7890");
        contact1.addEmail("john.doe@example.com");

        Contact contact2 = new Contact("Jane", "Smith", "Janie", 1995);
        contact2.addPhoneNumber("987-654-3210");
        contact2.addEmail("jane.smith@example.org");

        // Список контактов
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(contact1);
        contacts.add(contact2);

        // Файл для хранения контактов
        String fileName = "contacts.txt";

        // Сохраняем контакты в файл
        saveContactsToFile(contacts, fileName);

        // Загружаем контакты из файла
        ArrayList<Contact> loadedContacts = loadContactsFromFile(fileName);

        // Вывод загруженных контактов
        for (Contact contact : loadedContacts) {
            System.out.println(contact);
        }
    }

    // Метод для сохранения контактов в файл
    public static void saveContactsToFile(ArrayList<Contact> contacts, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Contact contact : contacts) {
                writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getNickName() + "," + contact.getBirthYear());
                writer.newLine();
                for (String phone : contact.getPhoneNumbers()) {
                    writer.write("PHONE:" + phone);
                    writer.newLine();
                }
                for (String email : contact.getEmails()) {
                    writer.write("EMAIL:" + email);
                    writer.newLine();
                }
                writer.write("END"); // Маркер конца записи контакта
                writer.newLine();
            }
            System.out.println("Контакты успешно сохранены в файл!");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении контактов: " + e.getMessage());
        }
    }

    // Метод для загрузки контактов из файла
    public static ArrayList<Contact> loadContactsFromFile(String fileName) {
        ArrayList<Contact> contacts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            Contact contact = null;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("END")) {
                    if (contact != null) {
                        contacts.add(contact);
                    }
                    contact = null;
                } else if (line.startsWith("PHONE:")) {
                    if (contact != null) {
                        contact.addPhoneNumber(line.substring(6));
                    }
                } else if (line.startsWith("EMAIL:")) {
                    if (contact != null) {
                        contact.addEmail(line.substring(6));
                    }
                } else {
                    String[] parts = line.split(",");
                    if (parts.length == 4) {
                        contact = new Contact(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
                    }
                }
            }
            System.out.println("Контакты успешно загружены из файла!");
        } catch (IOException e) {
            System.out.println("Ошибка при загрузке контактов: " + e.getMessage());
        }
        return contacts;
    }
}

