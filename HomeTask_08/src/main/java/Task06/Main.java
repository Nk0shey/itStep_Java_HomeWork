package Task06;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemAlreadyExistsException;
import java.util.Random;

class XmlReader {
    private static final Random rnd = new Random();

    public void read() throws IOException {
        switch (rnd.nextInt(3)) {
            case 1:
                throw new NullPointerException();
            case 2:
                throw new Error(); // Генерація Error
            case 3:
                throw new FileNotFoundException();
            default:
                throw new FileSystemAlreadyExistsException();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        XmlReader[] readers = { new XmlReader(), new XmlReader(), new XmlReader() };

        try {
            processReaders(readers);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught and rethrown.");
        }
    }

    public static void processReaders(XmlReader[] readers) throws FileNotFoundException {
        for (XmlReader reader : readers) {
            try {
                reader.read();
            } catch (FileSystemAlreadyExistsException e) {
                System.out.println("Caught FileSystemAlreadyExistsException");
            } catch (FileNotFoundException e) {
                throw e; // Кидаємо FileNotFoundException наверх
            } catch (Error e) {
                System.out.println("Caught Error: " + e.getClass().getName());
            } catch (Exception e) {
                System.out.println("Caught another exception: " + e.getClass().getName());
            }
        }
    }
}
