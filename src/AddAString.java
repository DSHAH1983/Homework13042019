import java.util.Scanner;

//WAP to enter any String and count total number of 'a' in that String
public class AddAString
{

    public static void main(String[] args)
    {
        String word;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter any word");
        word=sc.nextLine();

        int count = 0;
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) == 'a'){
                count++;
            }
        }
        System.out.println("Number of 'a' in the word " + word + " is: " +count);

    }
}

