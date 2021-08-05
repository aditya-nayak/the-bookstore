import java.io.*;
import java.util.*;
public class Sign_Up
{
    private String fname, lname, username, password, gender;
    private char tempgdr;
    private boolean bool = false, bool2 = false;
    private int dob, mob, yob;
    void main() throws IOException
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("SIGN UP\n-------\n\nFirst Name: ");
        fname = sc.next();
        fname = (fname.charAt(0)+"").toUpperCase() + fname.substring(1);
        System.out.print("\nLast Name: ");
        lname = sc.next();
        lname = (lname.charAt(0)+"").toUpperCase() + lname.substring(1);
        System.out.print("\nGender (M/F): ");
        tempgdr = sc.next().charAt(0);
        while(!bool)
        {
            if(tempgdr == 'm' || tempgdr == 'M')
            {
                gender = "Male";
                System.out.print("\fSIGN UP\n-------\n\nFirst Name: "+fname+"\n\nLast Name: "+lname+"\n\nGender: "+gender);
                bool = true;
            }
            else if(tempgdr == 'f' || tempgdr == 'F')
            {
                gender = "Female";
                System.out.print("\fSIGN UP\n-------\n\nFirst Name: "+fname+"\n\nLast Name: "+lname+"\n\nGender: "+gender);
                bool = true;
            }
            else
            {
                System.out.print("\fSIGN UP\n-------\n\nFirst Name: "+fname+"\n\nLast Name: "+lname+"\n\nIncorrect Gender Input! Please try again\nGender (M/F): ");
                tempgdr = sc.next().charAt(0);
            }
        }
        bool = false;
        System.out.print("\n\nDate of Birth:\nYear (YYYY): ");
        yob = sc.nextInt();
        while(!bool)
        {
            if(yob > 1917 && yob < 2019)
            {
                bool = true;
                System.out.print("\fSIGN UP\n-------\n\nFirst Name: "+fname+"\n\nLast Name: "+lname+"\n\nGender: "+gender+"\n\nDate of Birth:\nYear (YYYY): "+yob);
            }
            else
            {
                System.out.print("\fSIGN UP\n-------\n\nFirst Name: "+fname+"\n\nLast Name: "+lname+"\n\nGender: "+gender+"\n\nDate of Birth:\nInvalid Year Entry! Please try again.\nYear (YYYY): ");
                yob = sc.nextInt();
            }
        }
        bool = false;
        System.out.print("\nMonth (MM): ");
        mob = sc.nextInt();
        while(!bool)
        {
            if(mob > 0 && mob < 13)
            {
                bool = true;
                System.out.print("\fSIGN UP\n-------\n\nFirst Name: "+fname+"\n\nLast Name: "+lname+"\n\nGender: "+gender+"\n\nDate of Birth:\nYear (YYYY): "+yob+"\nMonth (MM): "+((mob > 9)?(mob):("0"+mob)));
            }
            else
            {
                System.out.print("\fSIGN UP\n-------\n\nFirst Name: "+fname+"\n\nLast Name: "+lname+"\n\nGender: "+gender+"\n\nDate of Birth:\nYear (YYYY): "+yob+"\nInvalid Month Entry! Please try again.\nMonth (MM): ");
                mob = sc.nextInt();
            }
        }
        bool = false;
        System.out.print("\nDay (DD): ");
        dob = sc.nextInt();
        while(!bool)
        {
            if(dob < 32)
            {
                bool = true;
                System.out.print("\fSIGN UP\n-------\n\nFirst Name: "+fname+"\n\nLast Name: "+lname+"\n\nGender: "+gender+"\n\nDate of Birth (DD/MM/YYYY): "+((dob > 9)?(dob):("0"+dob))+"/"+((mob > 9)?(mob):("0"+mob))+"/"+yob);
            }
            else
            {
                System.out.print("\fSIGN UP\n-------\n\nFirst Name: "+fname+"\n\nLast Name: "+lname+"\n\nGender: "+gender+"\n\nDate of Birth:\nYear (YYYY): "+yob+"\nMonth (MM): "+((mob > 9)?(mob):("0"+mob))+"\nInvalid Day Entry! Please try again.\nDay (DD): ");
                dob = sc.nextInt();
            }
        }
        bool = false;
        System.out.print("\n\nEnter a Username of your choice (Should not contain spaces): ");
        username = sc.next();
        while(!bool)
        {
            if(User.count == -1)
            {
                bool = true;
                System.out.print("\fSIGN UP\n-------\n\nFirst Name: "+fname+"\n\nLast Name: "+lname+"\n\nGender: "+gender+"\n\nDate of Birth (DD/MM/YYYY): "+((dob > 9)?(dob):("0"+dob))+"/"+((mob > 9)?(mob):("0"+mob))+"/"+yob+"\n\nUsername: "+username+"\n\n");
            }
            else
            {
                for(int i = 0;i <= User.count;i++)
                {
                    if(User.user[i].username.equals(username))
                    {
                        bool2 = true;
                    }
                }
                if(bool2)
                {
                    System.out.print("\fSIGN UP\n-------\n\nFirst Name: "+fname+"\n\nLast Name: "+lname+"\n\nGender: "+gender+"\n\nDate of Birth (DD/MM/YYYY): "+((dob > 9)?(dob):("0"+dob))+"/"+((mob > 9)?(mob):("0"+mob))+"/"+yob+"\n\nThis username is already taken. Please enter another username.\nUsername: ");
                    username = sc.next();
                    bool2 = false;
                }
                else
                {
                    bool = true;
                    System.out.print("\fSIGN UP\n-------\n\nFirst Name: "+fname+"\n\nLast Name: "+lname+"\n\nGender: "+gender+"\n\nDate of Birth (DD/MM/YYYY): "+((dob > 9)?(dob):("0"+dob))+"/"+((mob > 9)?(mob):("0"+mob))+"/"+yob+"\n\nUsername: "+username+"\n\n");
                }
            }
        }
        while(true)
        {
            bool = false;
            System.out.print("Enter a password of your choice (Min. 8 characters. Characters after a space will not be considered): ");
            password = sc.next();
            while(!bool)
            {
                if(password.length() > 7)
                {
                    bool = true;
                    System.out.print("\fSIGN UP\n-------\n\nFirst Name: "+fname+"\n\nLast Name: "+lname+"\n\nGender: "+gender+"\n\nDate of Birth (DD/MM/YYYY): "+((dob > 9)?(dob):("0"+dob))+"/"+((mob > 9)?(mob):("0"+mob))+"/"+yob+"\n\nUsername: "+username+"\n\nPassword: ");
                    for(int i = 0;i < password.length();i++)
                    {
                        System.out.print("·");
                    }
                }
                else
                {
                    System.out.print("\fSIGN UP\n-------\n\nFirst Name: "+fname+"\n\nLast Name: "+lname+"\n\nGender: "+gender+"\n\nDate of Birth (DD/MM/YYYY): "+((dob > 9)?(dob):("0"+dob))+"/"+((mob > 9)?(mob):("0"+mob))+"/"+yob+"\n\nUsername: "+username+"\n\nLength of the password should be minimum 8 characters\nEnter a password of your choice (Characters after a space will not be considered): ");
                    password = sc.next();
                }
            }
            bool = false;
            System.out.print("\n\nRe-enter the Password: ");
            if(password.equals(sc.next()))
            {
                User.addUser(fname, lname, username, password, gender, dob, mob, yob);
                for(int i = 5;i > 0;i--)
                {
                    System.out.print("\f");
                    View_Edit_Profile.displayProfile(User.count);
                    System.out.print("User successfully created.\n\nYou will be redirected to the main page in "+i+" second(s).");
                    try
                    {
                        Thread.sleep(1000);
                    } catch(Exception e){}
                }
                break;
            }
            else
            {
                System.out.print("\fSIGN UP\n-------\n\nFirst Name: "+fname+"\n\nLast Name: "+lname+"\n\nGender: "+gender+"\n\nDate of Birth (DD/MM/YYYY): "+((dob > 9)?(dob):("0"+dob))+"/"+((mob > 9)?(mob):("0"+mob))+"/"+yob+"\n\nUsername: "+username+"\n\nThe passwords do not match. Please try again.\n");
            }
        }
        Index index = new Index();
        index.main();
        return;
    }
}
