import java.io.*;
import java.util.*;
public class Book
{
   String title, author, publisher, language, pub_date, isbn;
   int quantity, srno;
   double mrp;
   boolean used;
   static Book book[] = new Book[10000];
   static int count = 1304;
   static boolean init = false;
   Book(String ttitle, String tauthor, String tpublisher, String tlanguage, String tisbn, double tmrp, int tquantity, String tpub_date, boolean tused)
   {
       title = ttitle;
       author = tauthor;
       publisher = tpublisher;
       language = tlanguage;
       isbn = tisbn;
       mrp = tmrp;
       quantity = tquantity;
       pub_date = tpub_date;
       used = tused;
   }
   Book()
   {
       title = "";
       author = "";
       publisher = "";
       language = "";
       isbn = "";
       mrp = 0;
       quantity = 0; 
       pub_date = "";
       used = false;
   }
   static void initializeBook() throws IOException
   {
       FileReader nfr = new FileReader("book_name");
       BufferedReader nbr = new BufferedReader(nfr);
       FileReader afr = new FileReader("book_author");
       BufferedReader abr = new BufferedReader(afr);
       FileReader pfr = new FileReader("book_pub");
       BufferedReader pbr = new BufferedReader(pfr);
       FileReader lfr = new FileReader("book_lang");
       BufferedReader lbr = new BufferedReader(lfr);
       FileReader ifr = new FileReader("book_isbn");
       BufferedReader ibr = new BufferedReader(ifr);
       FileReader mfr = new FileReader("book_mrp");
       BufferedReader mbr = new BufferedReader(mfr);
       FileReader qfr = new FileReader("book_quant");
       BufferedReader qbr = new BufferedReader(qfr);
       FileReader pdfr = new FileReader("book_pubdate");
       BufferedReader pdbr = new BufferedReader(pdfr);
       FileReader ufr = new FileReader("book_used");
       BufferedReader ubr = new BufferedReader(ufr);
       for(int i = 0;i < count;i++)
       {
           book[i] = new Book(nbr.readLine(), abr.readLine(), pbr.readLine(), lbr.readLine(), ibr.readLine(), Integer.parseInt(mbr.readLine()), Integer.parseInt(qbr.readLine()), pdbr.readLine(), Boolean.parseBoolean(ubr.readLine()));
       }
   }
   void viewBookList() throws IOException
   {
       Scanner sc = new Scanner(System.in);
       System.out.print("\nPlease enable unlimited buffering in the output window.\n\nThere are "+count+" books in the library.\n\nHow many book entries should be shown per page?\n\nEnter your choice (1 - 1304): ");
       int booksPP = sc.nextInt();
       boolean error = false;
       booksPP = (booksPP > 0)?booksPP : 20;
       booksPP = (booksPP <= Book.count)?booksPP : Book.count;
       System.out.print("\fShowing "+booksPP+" books per page\n\n");
       int lb = 1, ub = booksPP, pages = 1304/booksPP + 1, pgNo = 1;
       String ttitle = "                                             ", tauthor = "                      ", tpublisher = "                   ", tlanguage = "              ", tmrp = "      ", tquantity = "       ";
       while(true)
       {
           System.out.print("\t\t\t\t\t\t\t\t\tShowing "+lb+" to "+ub+" out of "+Book.count+" books.\n\t\t\t\t\t\t\t\t\t       Page Number "+pgNo+" out of "+pages+"\n================================================================================================================================================================================\n       |                                              |                       |                    |               |               |         |        |               |        \nSR. NO.|              TITLE OF THE BOOK               |        AUTHOR         |     PUBLISHER      |   LANGUAGE    |     ISBN      |  M.R.P. |QUANTITY|     DATE      |NEW/USED\n       |                                              |                       |                    |               |               |(IN Rs.) |        |               |        \n================================================================================================================================================================================");
           for(int i = lb;i <= ub;i++)
           {
               if(i > count)
               break;
               book[i-1].srno = i;
               System.out.print("\n  "+i+"."+((i > 9)?"":" ")+((i > 99)?"":" ")+((i > 999)?"":" ")+"|"+((book[i-1].title.length() > 45)?(book[i-1].title.substring(0, 46)):(book[i-1].title+ttitle.substring(0, ttitle.length() - book[i-1].title.length())+" "))+"|"+((book[i-1].author.length() > 22)?(book[i-1].author.substring(0, 23)):(book[i-1].author+tauthor.substring(0, tauthor.length() - book[i-1].author.length())+" "))+"|"+((book[i-1].publisher.length() > 19)?(book[i-1].publisher.substring(0, 20)):(book[i-1].publisher+tpublisher.substring(0, tpublisher.length() - book[i-1].publisher.length())+" "))+"|"+((book[i-1].language.length() > 14)?(book[i-1].language.substring(0, 15)):(book[i-1].language+tlanguage.substring(0, tlanguage.length() - book[i-1].language.length())+" "))+"| "+book[i-1].isbn+" |Rs."+((String.valueOf(book[i-1].mrp).length() > 9)?(String.valueOf(book[i-1].mrp).substring(0, 10)):(String.valueOf(book[i-1].mrp)+tmrp.substring(0, tmrp.length() - String.valueOf(book[i-1].mrp).length())))+"| "+((String.valueOf(book[i-1].quantity).length() > 8)?(String.valueOf(book[i-1].quantity).substring(0, 9)):(String.valueOf(book[i-1].quantity)+tquantity.substring(0, tquantity.length() - String.valueOf(book[i-1].quantity).length())))+"|   "+book[i-1].pub_date+"  | "+((book[i-1].used)?"USED":"NEW")+"\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
           }
           if(error)
           {
               System.out.print("\nInvalid Entry. Please try again.");
               error = false;
           }
           if(pgNo == 1)
           {
               System.out.print("\n1. Go to the next page\n2. Go to a specific page number\n3. Search for a specific book by any of its details\n4. Exit to User Homepage\n5. Exit this application\n\nEnter your choice (1/2/3/4/5): ");
               int ch = sc.nextInt();
               switch(ch)
               {
                   case 1:
                   System.out.print("\f");
                   lb = ub + 1;
                   ub = ub + booksPP;
                   pgNo++;
                   break;
                   case 2:
                   System.out.print("\fEnter a page number from 1 to "+pages+": ");
                   pgNo = sc.nextInt();
                   pgNo = (pgNo > pages)?pages : pgNo;
                   pgNo = (pgNo < 1)?1 : pgNo;
                   lb = ((pgNo-1) * booksPP) + 1;
                   ub = pgNo * booksPP;
                   System.out.print("\f");
                   break;
                   case 3:
                   Book_Search bookSearch = new Book_Search();
                   bookSearch.main();
                   return;
                   case 4:
                   System.out.print("\f");
                   Homepage homepage = new Homepage(Homepage.uid);
                   homepage.main();
                   return;
                   case 5:
                   Exit.main();
                   return;
                   default:
                   error = true;
               }
           }
           else if(pgNo == pages)
           {
               System.out.print("\n1. Go to the previous page\n2. Go to a specific page number\n3. Search for a specific book by any of its details\n4. Exit to User Homepage\n5. Exit this application\n\nEnter your choice (1/2/3/4/5): ");
               int ch = sc.nextInt();
               switch(ch)
               {
                   case 1:
                   System.out.print("\f");
                   ub = lb - 1;
                   lb = lb - booksPP;
                   pgNo--;
                   break;
                   case 2:
                   System.out.print("\fEnter a page number between 1 to "+pages+": ");
                   pgNo = sc.nextInt();
                   pgNo = (pgNo > pages)?pages : pgNo;
                   pgNo = (pgNo < 1)?1 : pgNo;
                   lb = ((pgNo-1) * booksPP) + 1;
                   ub = pgNo * booksPP;
                   System.out.print("\f");
                   break;
                   case 3:
                   Book_Search bookSearch = new Book_Search();
                   bookSearch.main();
                   return;
                   case 4:
                   System.out.print("\f");
                   Homepage homepage = new Homepage(Homepage.uid);
                   homepage.main();
                   return;
                   case 5:
                   Exit.main();
                   return;
                   default:
                   error = true;
               }
           }
           else
           {
               System.out.print("\n1. Go to the next page\n2. Go to the previous page\n3. Go to a specific page number\n4. Search for a specific book by any of its details\n5. Exit to User Homepage\n6. Exit this application\n\nEnter your choice (1/2/3/4/5/6): ");
               int ch = sc.nextInt();
               switch(ch)
               {
                   case 1:
                   System.out.print("\f");
                   lb = ub + 1;
                   ub = ub + booksPP;
                   pgNo++;
                   break;
                   case 2:
                   System.out.print("\f");
                   ub = lb - 1;
                   lb = lb - booksPP;
                   pgNo--;
                   break;
                   case 3:
                   System.out.print("\fEnter a page number between 1 to "+pages+": ");
                   pgNo = sc.nextInt();
                   pgNo = (pgNo > pages)?pages : pgNo;
                   pgNo = (pgNo < 1)?1 : pgNo;
                   lb = ((pgNo-1) * booksPP) + 1;
                   ub = pgNo * booksPP;
                   System.out.print("\f");
                   break;
                   case 4:
                   Book_Search bookSearch = new Book_Search();
                   bookSearch.main();
                   return;
                   case 5:
                   System.out.print("\f");
                   Homepage homepage = new Homepage(Homepage.uid);
                   homepage.main();
                   return;
                   case 6:
                   Exit.main();
                   return;
                   default:
                   error = true;
               }
           }
       }
   }
}
