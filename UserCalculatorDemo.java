import java.util.Scanner;
interface Calculator
{
    double add(double a, double b);
    double subtract(double a, double b);
    double multiply(double a, double b);
    double divide(double a, double b);
}

class BasicCalculator implements Calculator
{
 
    public double add(double a, double b) {
        return a + b;
    }

   
    public double subtract(double a, double b) {
        return a - b;
    }

   
    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed!");
            return 0;
        }
        return a / b;
    }
}


public class UserCalculatorDemo
 {
       public static void main(String[] args)
       {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new BasicCalculator();
        System.out.println("==================================");

       
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

       
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

       
        System.out.println("\nSelect an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.print("Enter your choice (1-4): ");
       
        int choice = scanner.nextInt();
        double result = 0;
        boolean validOperation = true;

       
        switch (choice)
       {
            case 1:
                result = calc.add(num1, num2);
                System.out.println("Result: " + num1 + " + " + num2 + " = " + result);
                break;
            case 2:
                result = calc.subtract(num1, num2);
                System.out.println("Result: " + num1 + " - " + num2 + " = " + result);
                break;
            case 3:
                result = calc.multiply(num1, num2);
                System.out.println("Result: " + num1 + " * " + num2 + " = " + result);
                break;
            case 4:
                if (num2 != 0) {
                    result = calc.divide(num1, num2);
                    System.out.println("Result: " + num1 + " / " + num2 + " = " + result);
                }
                break;
            default:
                System.out.println("Invalid choice! Please select between 1 and 4.");
                validOperation = false;
                break;
        }

        if (validOperation && choice >= 1 && choice <= 4 && !(choice == 4 && num2 == 0)) {
            System.out.println("==================================");
        }

        scanner.close();
    }
}