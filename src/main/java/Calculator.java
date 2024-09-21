import services.CalculatorService;
import java.util.*;

public class Calculator {

    public static void main(String[] args){
        System.out.println("Welcome to Calculator SPE Project!");
        int ch;
        Scanner sc = new Scanner(System.in);

        CalculatorService calculatorService = new CalculatorService();

        while (true){
            System.out.println("--------------------------------------------------");
            System.out.println("Enter choice: ");
            System.out.println("1. Square Root of a Decimal Number");
            System.out.println("2. Factorial of an Integer");
            System.out.println("3. Natural Logarithm of a Positive Real Number");
            System.out.println("4. Power of a Number");
            System.out.println("5. Exit Menu");
            System.out.println("Enter your choice:");
            ch = sc.nextInt();
            System.out.println("--------------------------------------------------");
            if (ch == 1){
                System.out.println("Enter Positive Real Number for Square Root");
                Double d = sc.nextDouble();
                Double res = calculatorService.sqrt(d);
                System.out.println(res);
            }else if (ch == 2){
                System.out.println("Enter Positive Integer for Factorial");
                Integer n = sc.nextInt();
                Integer res = calculatorService.factorial(n);
                System.out.println(res);
            }else if (ch == 3){
                System.out.println("Enter Positive Real Number for Logarithm");
                Double d = sc.nextDouble();
                Double res = calculatorService.logarithm(d);
                System.out.println(res);
            }else if (ch == 4){
                System.out.println("Enter Base and Exponent");
                Double base = sc.nextDouble();
                Double exp = sc.nextDouble();
                Double res = calculatorService.power(base, exp);
                System.out.println(res);
            }else if (ch == 5){
                System.out.println("Exiting");
                break;
            }else{
                System.out.println("Invalid Choice");
            }
        }

        sc.close();
    }
}
