public class Task05 {
    public static final double RADIUS = 5.0;
    public static void main(String[] args) {
        double area = Math.PI * Math.pow(RADIUS, 2);
        System.out.println("Площа кола: " + area);
        double circumference = 2 * Math.PI * RADIUS;
        System.out.println("Довжина кола: " + circumference);
    }
}
