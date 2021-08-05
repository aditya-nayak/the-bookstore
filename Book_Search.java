import java.io.*;
import java.util.*;
public class Book_Search
{
    void main() throws IOException
    {
        String search;
        Scanner scInt = new Scanner(System.in);
        Scanner scStr = new Scanner(System.in);
        System.out.print("\f");
        boolean done = false;
        int ch, j = 0, yr;
        while(!done)
        {
            System.out.print("Choose the criteria by which you want to search for the book:\n1. Title of the Book\n2. Name of the author\n3. ISBN Number\n\nEnter your Choice (1/2/3): ");
            ch = scInt.nextInt();
            j = 0;
            yr = 0;
            switch(ch)
            {
                case 1:
                System.out.print("\f\nEnter the title of the book: ");
                search = scStr.nextLine();
                System.out.print("\f\nTitle being searched: "+search+"\n================================================================================================================================================================================\n       |                                              |                       |                    |               |               |         |        |               |        \nSR. NO.|              TITLE OF THE BOOK               |        AUTHOR         |     PUBLISHER      |   LANGUAGE    |     ISBN      |  M.R.P. |QUANTITY|     DATE      |NEW/USED\n       |                                              |                       |                    |               |               |(IN Rs.) |        |               |        \n================================================================================================================================================================================");
                for(int i = 0;i < Book.count;i++)
                {
                    if(Book.book[i].title.toUpperCase().indexOf(search.toUpperCase()) != -1)
                    {
                        j++;
                        viewBook(i+1, j);
                    }
                }
                if(j == 0)
                {
                    for(int i = 3;i > 0;i--)
                    {
                        System.out.print("\f\n\nThis Book was not found in our library. You will be redirected to the homepage in "+i+" second(s).");
                        try
                        {
                            Thread.sleep(1000);
                        } catch(Exception e){}
                    }
                    System.out.print("\f");
                    Homepage homepage = new Homepage(Homepage.uid);
                    homepage.main();
                }
                done = true;
                break;
                case 2:
                System.out.print("\f\nEnter the author name: ");
                search = scStr.nextLine();
                System.out.print("\f\nEnter the author name: "+search+"\n================================================================================================================================================================================\n       |                                              |                       |                    |               |               |         |        |               |        \nSR. NO.|              TITLE OF THE BOOK               |        AUTHOR         |     PUBLISHER      |   LANGUAGE    |     ISBN      |  M.R.P. |QUANTITY|     DATE      |NEW/USED\n       |                                              |                       |                    |               |               |(IN Rs.) |        |               |        \n================================================================================================================================================================================");
                for(int i = 0;i < Book.count;i++)
                {
                    if(Book.book[i].author.toUpperCase().indexOf(search.toUpperCase()) != -1)
                    {
                        j++;
                        viewBook(i+1, j);
                    }
                }
                if(j == 0)
                {
                    for(int i = 3;i > 0;i--)
                    {
                        System.out.print("\f\n\nThis Book was not found in our library. You will be redirected to the homepage in "+i+" second(s).");
                        try
                        {
                            Thread.sleep(1000);
                        } catch(Exception e){}
                    }
                    System.out.print("\f");
                    Homepage homepage = new Homepage(Homepage.uid);
                    homepage.main();
                }
                done = true;
                break;
                case 3:
                System.out.print("\f\nEnter the ISBN Number of the book: ");
                search = scStr.nextLine();
                System.out.print("\f\nISBN being searched: "+search+"\n================================================================================================================================================================================\n       |                                              |                       |                    |               |               |         |        |               |        \nSR. NO.|              TITLE OF THE BOOK               |        AUTHOR         |     PUBLISHER      |   LANGUAGE    |     ISBN      |  M.R.P. |QUANTITY|     DATE      |NEW/USED\n       |                                              |                       |                    |               |               |(IN Rs.) |        |               |        \n================================================================================================================================================================================");
                for(int i = 0;i < Book.count;i++)
                {
                    if(Book.book[i].isbn.indexOf(search) != -1)
                    {
                        j++;
                        viewBook(i+1, j);
                    }
                }
                if(j == 0)
                {
                    for(int i = 3;i > 0;i--)
                    {
                        System.out.print("\f\n\nThis Book was not found in our library. You will be redirected to the homepage in "+i+" second(s).");
                        try
                        {
                            Thread.sleep(1000);
                        } catch(Exception e){}
                    }
                    System.out.print("\f");
                    Homepage homepage = new Homepage(Homepage.uid);
                    homepage.main();
                }
                done = true;
                break;
                default:
                System.out.print("\fInvalid entry. Please try again!\n");
            }
        }
        if(j != 0)
        {
            System.out.print("\n\n1. Buy a book\n2. Return to home page\n\nEnter your choice (1/2): ");
            ch = scInt.nextInt();
            switch(ch)
            {
                case 1:
                Buy_Book buyBook = new Buy_Book();
                buyBook.main();
                return;
                case 2:
                System.out.print("\f");
                Homepage homepage = new Homepage(Homepage.uid);
                homepage.main();
                return;
                default:
                for(int i = 3;i > 0;i--)
                {
                    System.out.print("\fInvalid Entry!\n\nYou will be redirected to the main page in "+i+" second(s).");
                    try
                    {
                        Thread.sleep(1000);
                    } catch(Exception e){}
                }
                System.out.print("\f");
                Homepage homepage2 = new Homepage(Homepage.uid);
                homepage2.main();
                return;
            }
        }
    }
    static void viewBook(int i, int j)
    {
        Book.book[i-1].srno = j;
        String ttitle = "                                             ", tauthor = "                      ", tpublisher = "                   ", tlanguage = "              ", tmrp = "      ", tquantity = "       ";
        System.out.print("\n  "+j+"."+((j > 9)?"":" ")+((j > 99)?"":" ")+((j > 999)?"":" ")+"|"+((Book.book[i-1].title.length() > 45)?(Book.book[i-1].title.substring(0, 46)):(Book.book[i-1].title+ttitle.substring(0, ttitle.length() - Book.book[i-1].title.length())+" "))+"|"+((Book.book[i-1].author.length() > 22)?(Book.book[i-1].author.substring(0, 23)):(Book.book[i-1].author+tauthor.substring(0, tauthor.length() - Book.book[i-1].author.length())+" "))+"|"+((Book.book[i-1].publisher.length() > 19)?(Book.book[i-1].publisher.substring(0, 20)):(Book.book[i-1].publisher+tpublisher.substring(0, tpublisher.length() - Book.book[i-1].publisher.length())+" "))+"|"+((Book.book[i-1].language.length() > 14)?(Book.book[i-1].language.substring(0, 15)):(Book.book[i-1].language+tlanguage.substring(0, tlanguage.length() - Book.book[i-1].language.length())+" "))+"| "+Book.book[i-1].isbn+" |Rs."+((String.valueOf(Book.book[i-1].mrp).length() > 9)?(String.valueOf(Book.book[i-1].mrp).substring(0, 10)):(String.valueOf(Book.book[i-1].mrp)+tmrp.substring(0, tmrp.length() - String.valueOf(Book.book[i-1].mrp).length())))+"| "+((String.valueOf(Book.book[i-1].quantity).length() > 8)?(String.valueOf(Book.book[i-1].quantity).substring(0, 9)):(String.valueOf(Book.book[i-1].quantity)+tquantity.substring(0, tquantity.length() - String.valueOf(Book.book[i-1].quantity).length())))+"|   "+Book.book[i-1].pub_date+"  | "+((Book.book[i-1].used)?"USED":"NEW")+"\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
