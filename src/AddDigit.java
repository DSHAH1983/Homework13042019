import java.util.Scanner;

//input any five digit number and then find sum of each digit
public class AddDigit
{
    public static void main(String[] args)
    {
        int num, Remainder, sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any 5 digit");
        num=scanner.nextInt();

        //Using while loop method
        while (num > 0) {
            Remainder = num % 10;
            sum = sum+Remainder;
            num = num / 10;
        }
        System.out.println("Sum of the given digits is = " + sum);

    }
}
