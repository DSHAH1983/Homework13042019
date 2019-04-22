import java.util.Scanner;


//Print single multiplication table using for loop for given number
public class MultipleForLoop
{

    public static void main(String args[])
    {
        int num;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Any Number");
        num=scanner.nextInt();

        //for loop
        // following loop executes 10 times
        for ( int i = 1; i <= 10; i++ )
        {
            int value = num * i;
            System.out.println(num + " * " + i + " = " + value);
        }
    }
}

