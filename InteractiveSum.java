import java.util.Scanner;

public class InteractiveSum {
    
    public static void main (String[] args){

        Scanner input = new Scanner (System.in);
        System.out.println("Please enter the first number: ");
        int number1 = input.nextInt();

        //Scanner input2 = new Scanner(System.in);
        System.out.println("Please enter the second number: ");
        int number2 = input.nextInt();

        System.out.printf("The sum of %d and %d is %d", number1, number2, number1 + number2);

    }
}
