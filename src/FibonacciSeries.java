import java.util.Scanner;


//Print Fibonacci series of 'n' terms where 'n' is input by user
public class FibonacciSeries
{
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        System.out.println("Enter any number : ");

        int n = console.nextInt();

        System.out.println("The Fibonacci numbers less than " + n + " are: ");

        for(int i=1; i<=n; i++)
        {
            System.out.print(fibonacci(i) +" ");

        }
    }
    public static int fibonacci(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        int f1=1;
        int f2=1;
        int fibonacci=1;


        for(int i= 3; i<= n; i++){



            do {   fibonacci = f1 + f2;
                f1 = f2;
                f2 = fibonacci;

            }

            while (fibonacci <= n);



        }
        return fibonacci;
    }
}


