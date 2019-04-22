import java.util.Scanner;

//WAP to input any number and check if it is Armstrong number or not
public class ArmstrongNumber
{
    public static void main(String[] args)
    {
        int num, number, temp, total = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ënter Any Number");
        num = scanner.nextInt();
        scanner.close();

        number = num;

        for(;number!=0;number /= 10)
        {
            temp = number % 10;
            total = total + temp*temp*temp;
        }

        if(total == num)
            System.out.println(num + " is an Armstrong number");
        else
            System.out.println(num + " is not an Armstrong number");
    }
}
