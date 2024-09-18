import java.util.Scanner;

public class Calculatorapp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt the user for two numbers
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();

            // Prompt the user for an operator
            System.out.print("Enter an operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            // Variable to store the result
            double result = 0;

            // Perform the operation based on the operator
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        throw new ArithmeticException("Cannot divide by zero.");
                    }
                    break;
                default:
                    System.out.println("Invalid operator.");
                    return;
            }

            // Display the result
            System.out.println("The result is: " + result);

        } catch (ArithmeticException e) {
            // Handle division by zero error
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            // Handle other exceptions (invalid input, etc.)
            System.out.println("Error: Invalid input.");
        } finally {
            scanner.close();
        }
    }
}
