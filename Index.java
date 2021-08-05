import java.io.*;
import java.util.*;
public class Index
{
    private int ch = 0;
    void main() throws IOException
    {
        if(!Book.init)
        {
            Book.initializeBook();
            Book.init = true;
        }
        System.out.print("\f");
        Scanner sc = new Scanner(System.in);
        Sign_In signIn = new Sign_In();
        while(ch != 1 && ch != 2)
        {
            System.out.print("Are you:\n1. A New Customer\n2. An Existing Customer\n\nEnter 3 to exit this application\n\nPlease enter your choice (1/2/3): ");
            ch = sc.nextInt();
            switch (ch)
            {
                case 1:
                System.out.print("\f");
                Sign_Up signUp = new Sign_Up();
                signUp.main();
                return;
                case 2:
                System.out.print("\f");
                signIn.main();
                return;
                case 3:
                Exit.main();
                return;
                default:
                System.out.println("\fInvalid Entry. Please try again.");
            }
        }
    }
}
