public class Task06 {
    public static final int SIDE_WIDTH = 5;
    public static final int SIDE_HEIGHT = 12;

    public static void main(String[] args) {
        int P = 2 * (SIDE_WIDTH + SIDE_HEIGHT);
        System.out.println("Периметр прямокутника: " + P);

        int S = SIDE_WIDTH * SIDE_HEIGHT;
        System.out.println("Площа прямокутника: " + S);
    }
}
