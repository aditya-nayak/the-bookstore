import java.io.*;
import java.util.*;
public class View_Edit_Profile
{
    private static int uid = Homepage.uid;
    void main() throws IOException
    {
        FileWriter fout;
        BufferedWriter b;
        PrintWriter p;
        boolean incorrect = true;
        Scanner sc = new Scanner(System.in);
        while(incorrect)
        {
            displayProfile();
            System.out.print("\n\nWhat do you want to edit?\n1. First Name\n2. Last Name\n3. Password\n4. No, I don't want to change anything. Go back to the main menu.\n\nYour username, date of birth and gender is permanant and cannot be changed.\n\nPlease enter your choice (1/2/3/4): ");
            int ch = sc.nextInt();
            switch(ch)
            {
                case 1:
                System.out.print("\f\nPlease enter your First Name: ");
                User.user[uid].fname = sc.next();
                User.user[uid].fname = (User.user[uid].fname.charAt(0)+"").toUpperCase() + User.user[uid].fname.substring(1);
                fout = new FileWriter("users");
                b = new BufferedWriter(fout);
                p = new PrintWriter(b);
                for(int i = 0;i <= User.count;i++)
                {
                    p.println(i);
                    p.println(User.user[i].username);
                    p.println(User.user[i].password);
                    p.println(User.user[i].fname);
                    p.println(User.user[i].lname);
                    p.println(User.user[i].gender);
                    p.println(User.user[i].dob);
                    p.println(User.user[i].mob);
                    p.println(User.user[i].yob);
                }
                b.flush();
                b.close();
                p.close();
                fout.close();
                System.out.print("\f\nYour first name has successfully been changed to "+User.user[uid].fname+".\n\n");
                incorrect = false;
                break;
                case 2:
                System.out.print("\f\nPlease enter your Last Name: ");
                User.user[uid].lname = sc.next();
                User.user[uid].lname = (User.user[uid].lname.charAt(0)+"").toUpperCase() + User.user[uid].lname.substring(1);
                fout = new FileWriter("users");
                b = new BufferedWriter(fout);
                p = new PrintWriter(b);
                for(int i = 0;i <= User.count;i++)
                {
                    p.println(i);
                    p.println(User.user[i].username);
                    p.println(User.user[i].password);
                    p.println(User.user[i].fname);
                    p.println(User.user[i].lname);
                    p.println(User.user[i].gender);
                    p.println(User.user[i].dob);
                    p.println(User.user[i].mob);
                    p.println(User.user[i].yob);
                }
                b.flush();
                b.close();
                p.close();
                fout.close();
                System.out.print("\f\nYour last name has successfully been changed to "+User.user[uid].lname+".\n\n");
                break;
                case 3:
                System.out.print("\f");
                while(true)
                {
                    System.out.print("\nPlease enter your Old Password: ");
                    if(User.user[uid].password.compareTo(sc.next()) == 0)
                    {
                        while(true)
                        {
                            boolean bool = false;
                            System.out.print("\f\nEnter a password of your choice (Min. 8 characters. Characters after a space will not be considered): ");
                            String password = sc.next();
                            while(!bool)
                            {
                                if(password.length() > 7)
                                {
                                    bool = true;
                                    System.out.print("\f\nEnter a password of your choice (Min. 8 characters. Characters after a space will not be considered): ");
                                    for(int i = 0;i < password.length();i++)
                                    {
                                        System.out.print("·");
                                    }
                                }
                                else
                                {
                                    System.out.print("\f\nLength of the password should be minimum 8 characters\nEnter a password of your choice (Characters after a space will not be considered): ");
                                    password = sc.next();
                                }
                            }
                            bool = false;
                            System.out.print("\n\nRe-enter the Password: ");
                            if(password.equals(sc.next()))
                            {
                                User.user[uid].password = password;
                                fout = new FileWriter("users");
                                b = new BufferedWriter(fout);
                                p = new PrintWriter(b);
                                for(int i = 0;i <= User.count;i++)
                                {
                                    p.println(i);
                                    p.println(User.user[i].username);
                                    p.println(User.user[i].password);
                                    p.println(User.user[i].fname);
                                    p.println(User.user[i].lname);
                                    p.println(User.user[i].gender);
                                    p.println(User.user[i].dob);
                                    p.println(User.user[i].mob);
                                    p.println(User.user[i].yob);
                                }
                                b.flush();
                                b.close();
                                p.close();
                                fout.close();
                                for(int i = 3;i > 0;i--)
                                {
                                    System.out.print("\fYour password has successfully been changed.\n\nYou will be redirected to your Profile page in "+i+" second(s).");
                                    try
                                    {
                                        Thread.sleep(1000);
                                    } catch(Exception e){}
                                }
                                System.out.print("\f");
                                View_Edit_Profile viewEditProfile2 = new View_Edit_Profile();
                                viewEditProfile2.main();
                                return;
                            }
                            else
                            {
                                System.out.print("\f\nThe passwords do not match. Please try again.\n");
                            }
                        }
                    }
                    else
                    {
                        System.out.print("\fThe password you entered is incorrect! Please try again.");
                    }
                }
                case 4:
                System.out.print("\f");
                Homepage homepage = new Homepage(Homepage.uid);
                homepage.main();
                return;
                default:
                System.out.print("\fInvalid Entry! Please try again.");
            }
        }
        View_Edit_Profile viewEditProfile = new View_Edit_Profile();
        viewEditProfile.main();
    }
    static void displayProfile()
    {
        System.out.print("\nFirst Name: "+User.user[uid].fname+"\tLast Name: "+User.user[uid].lname+"\n\nGender: "+User.user[uid].gender+"\t\tDate of Birth (DD/MM/YYYY): "+((User.user[uid].dob > 9)?(User.user[uid].dob):("0"+User.user[uid].dob))+"/"+((User.user[uid].mob > 9)?(User.user[uid].mob):("0"+User.user[uid].mob))+"/"+User.user[uid].yob+"\n\nUsername: "+User.user[uid].username+"\t\tPassword: ");
        for(int i = 0;i < User.user[uid].password.length();i++)
        {
            System.out.print("·");
        }
        System.out.print("\n\n================================================================================================================================================================================\n");
    }
    static void displayProfile(int tempId)
    {
        System.out.print("\nFirst Name: "+User.user[tempId].fname+"\tLast Name: "+User.user[tempId].lname+"\n\nGender: "+User.user[tempId].gender+"\t\tDate of Birth (DD/MM/YYYY): "+((User.user[tempId].dob > 9)?(User.user[tempId].dob):("0"+User.user[tempId].dob))+"/"+((User.user[tempId].mob > 9)?(User.user[tempId].mob):("0"+User.user[tempId].mob))+"/"+User.user[tempId].yob+"\n\nUsername: "+User.user[tempId].username+"\t\tPassword: ");
        for(int i = 0;i < User.user[tempId].password.length();i++)
        {
            System.out.print("·");
        }
        System.out.print("\n\n================================================================================================================================================================================\n");
    }
}
