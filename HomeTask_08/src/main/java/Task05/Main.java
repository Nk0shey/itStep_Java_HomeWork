package Task05;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Runner runner = new Runner();

        try {
            runner.halt();
        } catch (RuntimeException e) {
            System.out.println("halt");
        } catch (IOException e) {
            throw new RuntimeException("IOException thrown", e);
        }
    }
}