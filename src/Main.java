import java.util.Scanner; // для читання з клавіатури

/**
 * Клас, який представляє число Фібоначчі з індексом і значенням.
 */
class FibonacciNumber {
    private int index;
    private int value;

    /**
     * Конструктор, що створює об'єкт FibonacciNumber.
     *
     * @param index індекс числа Фібоначчі
     * @param value значення числа Фібоначчі
     */
    public FibonacciNumber(int index, int value) {
        this.index = index;
        this.value = value;
    }

    /**
     * Повертає індекс числа Фібоначчі.
     *
     * @return індекс числа Фібоначчі
     */
    public int getIndex() {
        return index;
    }

    /**
     * Повертає значення числа Фібоначчі.
     *
     * @return значення числа Фібоначчі
     */
    public int getValue() {
        return value;
    }

    /**
     * Виводить інформацію про число Фібоначчі (індекс і значення) на екран.
     */
    public void displayInformation() {
        System.out.println("Index: " + index + ", Value: " + value);
    }

    /**
     * Цей метод виріщує чи є число фібоначчі відповідним умові задачі.
     */
    public boolean isNumberLessThanCubeMinusOne() {
        int valueMinusOne = value - 1;
        double cubeRoot = Math.cbrt(valueMinusOne); // знаходить кубічний корінь
        return cubeRoot == Math.floor(cubeRoot); // перевіряє, чи є cubeRoot цілим числом
    }
}

public class Main {


    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = 0, b = 1, result = 0;
        for (int i = 2; i <= n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    /**
     * Головний метод програми, виконується під час запуску.
     *
     * @param args аргументи командного рядка (нема)
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // для введення з клавіатури
        System.out.println("Enter number of Fibonacci numbers: ");
        int n = scan.nextInt();

        FibonacciNumber[] fibonacci = new FibonacciNumber[n]; // створення масиву об'єктів класу

        for (int i = 0; i < n; i++) {
            int value = fibonacci(i);
            fibonacci[i] = new FibonacciNumber(i, value);
        }

        System.out.println("\nGenerated Fibonacci numbers:");
        for (FibonacciNumber fib : fibonacci) {
            fib.displayInformation(); // виводить інформацію про кожне число
        }

        System.out.println("\nNumbers that are less than cube minus 1:");
        for (FibonacciNumber fib : fibonacci) {
            if (fib.isNumberLessThanCubeMinusOne()) {
                System.out.println("Fibonacci number at position " + fib.getIndex() + " (" + fib.getValue() + ") is suitable for the formula.");
            }
        }

        scan.close(); // закриття сканера
    }
}
