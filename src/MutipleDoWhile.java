import java.util.Scanner;


//Print single multiplication table using do while loop for given number.
public class MutipleDoWhile
{
    public static void main(String args[])
    {   int num;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Any Number");
        num=scanner.nextInt();

        // loop variable initialization
        int i = 1;

        //do while loop
        do {
            int value = num * i;
            System.out.println(num + " * " + i + " = " + value);
            i++;
        } while ( i <= 10 ); // condition check for exit
    }
}
