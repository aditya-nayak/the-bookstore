import java.io.*;
import java.util.*;
public class Sign_In
{
    private String pwd, username;
    private int uid = -1, ch = -1;
    void main() throws IOException
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            while(uid == -1)
            {
                ch = -1;
                System.out.print("SIGN IN\n-------\n\nUsername: ");
                username = sc.next();
                for(int i = 0;i <= User.count;i++)
                {
                    if(username.equals(User.user[i].username))
                    {
                        uid = i;
                        pwd = User.user[i].password;
                        break;
                    }
                }
                if(uid == -1)
                {
                    System.out.print("\fIncorrect username entered! Please try again.\n");
                    while(ch != 1 && ch != 2)
                    {
                        System.out.print("Do you want to go back to the main menu?\n1. Yes\n2. No\n\nEnter your choice (1/2): ");
                        ch = sc.nextInt();
                        switch(ch)
                        {
                            case 1:
                            Index index = new Index();
                            index.main();
                            return;
                            case 2:
                            System.out.print("\fInvalid Username/Password\n\n");
                            break;
                            default:
                            System.out.print("\fInvalid entry. Please try again!\n");
                        }
                   }
                }
            }
            System.out.print("\n\nPassword: ");
            if(sc.next().compareTo(pwd) == 0)
            {
                System.out.print("\f");
                Homepage homepage = new Homepage(uid);
                homepage.main();
                break;
            }
            else
            {
                System.out.println("\fInvalid Username/Password\n\n");
                uid = -1;
                ch = -1;
                while(ch != 1 && ch != 2)
                {
                    System.out.print("Do you want to go back to the main menu?\n1. Yes\n2. No\n\nEnter your choice (1/2): ");
                    ch = sc.nextInt();
                    switch(ch)
                    {
                        case 1:
                        Index index = new Index();
                        index.main();
                        return;
                        case 2:
                        System.out.print("\fInvalid Username/Password\n\n");
                        break;
                        default:
                        System.out.print("\fInvalid entry. Please try again!\n");
                    }
                }
            }
        }
    }
}
