/*
Створіть клас, об'єкти якого будуть незмінними. Клас
інкапсулює в собі інформацію про трикутник наплощині (кожної
довжини його ребер). Довжини сторін задаються у
конструкторі. Якщо за заданими сторонами побудувати
трикутник не можна, в конструктор має поміститисявиняток.
Протестуйте клас з допомогою JUnit-тестів.
 */

package Task03;

// Власний виняток для неможливого трикутника
class InvalidTriangleException extends Exception {
    public InvalidTriangleException(String message) {
        super(message);
    }
}

// Незмінний клас для трикутника
public final class Triangle {

    private final double sideA;
    private final double sideB;
    private final double sideC;

    // Конструктор
    public Triangle(double sideA, double sideB, double sideC) throws InvalidTriangleException {
        if (!isValidTriangle(sideA, sideB, sideC)) {
            throw new InvalidTriangleException("Неможливо створити трикутник із заданими сторонами: " + sideA + ", " + sideB + ", " + sideC);
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    // Перевірка можливості створення трикутника
    public static boolean isValidTriangle(double a, double b, double c) {
        return a > 0 && b > 0 && c > 0 && (a + b > c) && (a + c > b) && (b + c > a);
    }

    // Методи доступу до сторін
    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    // Обчислення периметра
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    // Обчислення площі трикутника за формулою Герона
    public double getArea() {
        double semiPerimeter = getPerimeter() / 2;
        return Math.sqrt(semiPerimeter *
                (semiPerimeter - sideA) *
                (semiPerimeter - sideB) *
                (semiPerimeter - sideC));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }
}

