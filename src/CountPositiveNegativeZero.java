import java.util.Scanner;


//Enter the numbers till the user wants and at the end it should display the count of positive, negative and zeros entered.
public class CountPositiveNegativeZero
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int number,
                countPositive = 0,
                countNegative = 0,
                countZero = 0;

        char choice;

        //do while loop
        do
        {
            System.out.println("Enter the number ");
            number = scanner.nextInt();

            if(number > 0)
            {
                countPositive++;
            }
            else if(number < 0)
            {
                countNegative++;
            }
            else
            {
                countZero++;
            }

            System.out.println("Do you want to continue y/n? ");
            choice = scanner.next().charAt(0);

        }
        while(choice=='y' || choice == 'Y');

        System.out.println("Positive numbers: " + countPositive);
        System.out.println("Negative numbers: " + countNegative);
        System.out.println("Zero numbers: " + countZero);
    }

}
