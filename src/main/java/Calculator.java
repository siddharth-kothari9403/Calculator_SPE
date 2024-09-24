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
            String s = sc.nextLine();
            ch = Integer.parseInt(s);
            System.out.println("--------------------------------------------------");
            if (ch == 1){
                System.out.println("Enter Positive Real Number for Square Root");
                s = sc.nextLine();
                Double d = Double.parseDouble(s);
                Double res = calculatorService.sqrt(d);
                System.out.println(res);
            }else if (ch == 2){
                System.out.println("Enter Positive Integer for Factorial");
                s = sc.nextLine();
                Integer n = Integer.parseInt(s);
                Integer res = calculatorService.factorial(n);
                System.out.println(res);
            }else if (ch == 3){
                System.out.println("Enter Positive Real Number for Logarithm");
                s = sc.nextLine();
                Double d = Double.parseDouble(s);
                Double res = calculatorService.logarithm(d);
                System.out.println(res);
            }else if (ch == 4){
                System.out.println("Enter Base: ");
                s = sc.nextLine();
                Double base = Double.parseDouble(s);
                System.out.println("Enter Exponent: ");
                s = sc.nextLine();
                Double exp = Double.parseDouble(s);
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
