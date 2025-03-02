package Task05;

public class ComplexNumberMain {
    public static void main(String[] args) {
        ComplexNumber num1 = new ComplexNumber(3, 4);
        ComplexNumber num2 = new ComplexNumber(1, 2);

        System.out.println("Перше число: " + num1);
        System.out.println("Друге число: " + num2);

        System.out.println("Додавання: " + num1.add(num2));
        System.out.println("Віднімання: " + num1.subtract(num2));
        System.out.println("Множення: " + num1.multiply(num2));
        System.out.println("Чи рівні числа? " + num1.isEqualTo(num2));
    }
}

