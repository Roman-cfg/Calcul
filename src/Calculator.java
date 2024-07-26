import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение (например, 2 + 3):");
        String input = scanner.nextLine();

        try {
            int result = calculate(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        scanner.close();
    }

    public static int calculate(String expression) throws Exception {
        String[] parts = expression.trim().split(" "); // делимитр
        if (parts.length != 3) {
            throw new Exception("Неверный формат ввода. Ожидается два числа и один оператор.");
        }

        int a ,b;
        try {
            a = Integer.parseInt(parts[0]);
            b = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Операнды должны быть целыми числами.");
        }

        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new Exception("Числа должны быть от 1 до 10 включительно.");
        }

        String operator = parts[1];

        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new Exception("Деление на ноль.");
                }
                return a / b;
            default:
                throw new Exception("Неподдерживаемая операция: " + operator);
        }
    }
}