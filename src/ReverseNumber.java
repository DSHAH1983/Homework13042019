import java.util.Scanner;


//Input number & reverse it & print it using while loop.
public class ReverseNumber
{
    public static void main(String args[])
    {
        int num;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter any number more then 2 digit");
        num=scanner.nextInt();
        int reversenum =0;

        //while loop
        while( num != 0 )
        {
            reversenum = reversenum * 10;
            reversenum = reversenum + num%10;
            num = num/10;
        }

        System.out.println("Reverse of specified number is: "+reversenum);
    }
}

