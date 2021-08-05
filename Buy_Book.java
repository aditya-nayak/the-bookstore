import java.util.*;
import java.io.*;
public class Buy_Book
{
    private int bookId = -1, uid = Homepage.uid;
    private String cc, cvv;
    void selectBook() throws IOException
    {
       Scanner sc = new Scanner(System.in);
       System.out.print("\n\nEnter the serial number of the book you want: ");
       int serial = sc.nextInt();
       for(int i = 0;i < Book.count;i++)
       {
           if(Book.book[i].srno == serial)
           {
               bookId = i;
           }
           Book.book[i].srno = -1;
       }
       if(bookId == -1)
       {
           System.out.print("Invalid entry! You will be redirected to the homepage.");
           try
           {
               Thread.sleep(1000);
           }catch(Exception e){}
           System.out.print("\f");
           Homepage homepage = new Homepage(Homepage.uid);
           homepage.main();
           return;
       }
       else
       {
           FileWriter fout = new FileWriter("book_quant");
           BufferedWriter b = new BufferedWriter(fout);
           PrintWriter p = new PrintWriter(b);
           Book.book[bookId].quantity--;
           for(int i = 0;i < Book.count;i++)
           {
               p.println(Book.book[i].quantity);
           }
           b.flush();
           b.close();
           p.close();
           fout.close();
           fout = new FileWriter(uid + "_cart", true);
           b = new BufferedWriter(fout);
           p = new PrintWriter(b);
           p.println(bookId);
           b.flush();
           b.close();
           p.close();
           fout.close();
           User.user[uid].quantity++;
           User.user[uid].cart[User.user[uid].quantity - 1] = bookId;
       }
    }
    void main() throws IOException
    {
        selectBook();
        if(Book.book[bookId].quantity > 0)
        {
            checkout();
        }
        else
        {
            for(int i = 3;i > 0;i--)
            {
                System.out.print("\f");
                System.out.print("This book is Out of Stock!\n\nYou will be redirected to the main page in "+i+" second(s).");
                try
                {
                    Thread.sleep(1000);
                } catch(Exception e){}
            }
            System.out.print("\f");
            Homepage homepage = new Homepage(Homepage.uid);
            homepage.main();
            return;
        }
    }
    void checkout() throws IOException
    {
        int price = 0;
        Scanner sc = new Scanner(System.in);
        Scanner scLine = new Scanner(System.in);
        int tid = (int) Math.ceil(Math.random() * Math.pow(10, 10));
        System.out.print("\fYou have "+User.user[uid].quantity+" book(s) in your cart.\nWhat do you want to do?\n1. Add another book to your cart\n2. Checkout\n3. Go to Homepage\n\nEnter your choice (1/2): ");
        int ch = sc.nextInt();
        switch(ch)
        {
            case 1:
                System.out.print("\f================================================================================================================================================================================\n       |                                              |                       |                    |               |               |         |        |               |        \nSR. NO.|              TITLE OF THE BOOK               |        AUTHOR         |     PUBLISHER      |   LANGUAGE    |     ISBN      |  M.R.P. |QUANTITY|     DATE      |NEW/USED\n       |                                              |                       |                    |               |               |(IN Rs.) |        |               |        \n================================================================================================================================================================================");
                for(int i = 1;i <= Book.count;i++)
                {
                    Book_Search.viewBook(i, i);
                }
                Buy_Book buyBook = new Buy_Book();
                buyBook.main();
                return;
            case 2:
                System.out.print("\f================================================================================================================================================================================\n   \t\t\t\t\t\t\t\t\t\tCHECKOUT PAGE\n================================================================================================================================================================================\n");
                for(int i = 0; i < User.user[uid].quantity;i++)
                {
                    System.out.print("          \t\t\t\t\t\t\t\t\t\tBOOK "+(i+1)+"\n================================================================================================================================================================================\nTITLE:                                                                                 ||  "+Book.book[User.user[uid].cart[i]].title+"\n================================================================================================================================================================================\nAUTHOR:                                                                                ||  "+Book.book[User.user[uid].cart[i]].author+"\n================================================================================================================================================================================\nPUBLISHER:                                                                             ||  "+Book.book[User.user[uid].cart[i]].publisher+"\n================================================================================================================================================================================\nLANGUAGE:                                                                              ||  "+Book.book[User.user[uid].cart[i]].language+"\n================================================================================================================================================================================\nM.R.P. (IN RS.):                                                                       ||  RS."+Book.book[User.user[uid].cart[i]].mrp+"\n================================================================================================================================================================================\n");
                    price += Book.book[User.user[uid].cart[i]].mrp;
                }
                if(User.user[Homepage.uid].address == null)
                {
                    System.out.print("\nPlease enter your Address: ");
                    User.user[Homepage.uid].address = scLine.nextLine();
                }
                System.out.print("\nHow do you want to pay?\n1. Credit Card\n2. Cash on Delivery (COD)\n\nEnter 3 to return to user homepage.\n\nPlease enter your choice (1/2/3): ");
                ch = sc.nextInt();
                switch(ch)
                {
                    case 1:
                    while(true)
                    {
                        System.out.print("\nPlease enter your 16 digit Credit Card Number: ");
                        cc = sc.next();
                        if(cc.length() != 16)
                        {
                            System.out.print("\f================================================================================================================================================================================\n   \t\t\t\t\t\t\t\t\t\tCHECKOUT PAGE\n================================================================================================================================================================================\n");
                            for(int i = 0; i < User.user[uid].quantity;i++)
                            {
                                System.out.print("          \t\t\t\t\t\t\t\t\t\tBOOK "+(i+1)+"\n================================================================================================================================================================================\nTITLE:                                                                                 ||  "+Book.book[User.user[uid].cart[i]].title+"\n================================================================================================================================================================================\nAUTHOR:                                                                                ||  "+Book.book[User.user[uid].cart[i]].author+"\n================================================================================================================================================================================\nPUBLISHER:                                                                             ||  "+Book.book[User.user[uid].cart[i]].publisher+"\n================================================================================================================================================================================\nLANGUAGE:                                                                              ||  "+Book.book[User.user[uid].cart[i]].language+"\n================================================================================================================================================================================\nM.R.P. (IN RS.):                                                                       ||  RS."+Book.book[User.user[uid].cart[i]].mrp+"\n================================================================================================================================================================================\n");
                            }
                            System.out.print("\n\nHow do you want to pay?\n1. Credit Card\n2. Cash on Delivery (COD)\n\nEnter 3 to return to user homepage.\n\nPlease enter your choice (1/2/3): "+ch+"\n\nInvalid Credit Card Number!");
                        }
                        else
                        {
                            System.out.print("\f================================================================================================================================================================================\n   \t\t\t\t\t\t\t\t\t\tCHECKOUT PAGE\n================================================================================================================================================================================\n");
                            for(int i = 0; i < User.user[uid].quantity;i++)
                            {
                                System.out.print("          \t\t\t\t\t\t\t\t\t\tBOOK "+(i+1)+"\n================================================================================================================================================================================\nTITLE:                                                                                 ||  "+Book.book[User.user[uid].cart[i]].title+"\n================================================================================================================================================================================\nAUTHOR:                                                                                ||  "+Book.book[User.user[uid].cart[i]].author+"\n================================================================================================================================================================================\nPUBLISHER:                                                                             ||  "+Book.book[User.user[uid].cart[i]].publisher+"\n================================================================================================================================================================================\nLANGUAGE:                                                                              ||  "+Book.book[User.user[uid].cart[i]].language+"\n================================================================================================================================================================================\nM.R.P. (IN RS.):                                                                       ||  RS."+Book.book[User.user[uid].cart[i]].mrp+"\n================================================================================================================================================================================\n");
                            }
                            System.out.print("\n\nHow do you want to pay?\n1. Credit Card\n2. Cash on Delivery (COD)\n\nEnter 3 to return to user homepage.\n\nPlease enter your choice (1/2/3): "+ch+"\n\nPlease enter your 16 digit Credit Card Number: "+cc+"\n");
                            break;
                        }
                    }
                    while(true)
                    {
                        System.out.print("\nPlease enter your 3 digit CVV Number: ");
                        cvv = sc.next();
                        if(cvv.length() != 3)
                        {
                            for(int i = 0; i < User.user[uid].quantity;i++)
                            {
                                System.out.print("          \t\t\t\t\t\t\t\t\t\tBOOK "+(i+1)+"\n================================================================================================================================================================================\nTITLE:                                                                                 ||  "+Book.book[User.user[uid].cart[i]].title+"\n================================================================================================================================================================================\nAUTHOR:                                                                                ||  "+Book.book[User.user[uid].cart[i]].author+"\n================================================================================================================================================================================\nPUBLISHER:                                                                             ||  "+Book.book[User.user[uid].cart[i]].publisher+"\n================================================================================================================================================================================\nLANGUAGE:                                                                              ||  "+Book.book[User.user[uid].cart[i]].language+"\n================================================================================================================================================================================\nM.R.P. (IN RS.):                                                                       ||  RS."+Book.book[User.user[uid].cart[i]].mrp+"\n================================================================================================================================================================================\n");
                            }
                            System.out.print("\n\nHow do you want to pay?\n1. Credit Card\n2. Cash on Delivery (COD)\n\nEnter 3 to return to user homepage.\n\nPlease enter your choice (1/2/3): "+ch+"\n\nPlease enter your 16 digit Credit Card Number: "+cc+"\n\nInvalid CVV number! Please try again.");
                        }
                        else
                        {
                             System.out.print("\f================================================================================================================================================================================\n   \t\t\t\t\t\t\t\t\t\tCHECKOUT PAGE\n================================================================================================================================================================================\n");
                            for(int i = 0; i < User.user[uid].quantity;i++)
                            {
                                System.out.print("          \t\t\t\t\t\t\t\t\t\tBOOK "+(i+1)+"\n================================================================================================================================================================================\nTITLE:                                                                                 ||  "+Book.book[User.user[uid].cart[i]].title+"\n================================================================================================================================================================================\nAUTHOR:                                                                                ||  "+Book.book[User.user[uid].cart[i]].author+"\n================================================================================================================================================================================\nPUBLISHER:                                                                             ||  "+Book.book[User.user[uid].cart[i]].publisher+"\n================================================================================================================================================================================\nLANGUAGE:                                                                              ||  "+Book.book[User.user[uid].cart[i]].language+"\n================================================================================================================================================================================\nM.R.P. (IN RS.):                                                                       ||  RS."+Book.book[User.user[uid].cart[i]].mrp+"\n================================================================================================================================================================================\n");
                            }
                            User.user[uid].quantity = 0;
                            System.out.print("\n\n\t\t\t\t\t\t\t\t\t    TRANSACTION SUCCESSFUL!\n\n================================================================================================================================================================================\nCredit Card Number: "+cc.substring(0,4)+" XXXX XXXX "+cc.substring(12)+"\n================================================================================================================================================================================\nCVV Number: ···\n================================================================================================================================================================================\nAMOUNT PAID: RS."+price+"\n================================================================================================================================================================================\nTRANSACTION ID: "+tid+"\n================================================================================================================================================================================\n\nWILL BE DELIVERED TO ADDRESS:\n"+User.user[Homepage.uid].address);
                            break;
                        }
                    }
                    for(int i = 0;i < User.user[uid].quantity;i++)
                    {
                        User.user[uid].cart[i] = -1;
                    }
                    User.user[uid].quantity = 0;
                    FileWriter fout1 = new FileWriter(uid + "_cart");
                    fout1.close();
                    break;
                    case 2:
                    System.out.print("\f");
                    for(int i = 0; i < User.user[uid].quantity;i++)
                    {
                        System.out.print("          \t\t\t\t\t\t\t\t\t\tBOOK "+(i+1)+"\n================================================================================================================================================================================\nTITLE:                                                                                 ||  "+Book.book[User.user[uid].cart[i]].title+"\n================================================================================================================================================================================\nAUTHOR:                                                                                ||  "+Book.book[User.user[uid].cart[i]].author+"\n================================================================================================================================================================================\nPUBLISHER:                                                                             ||  "+Book.book[User.user[uid].cart[i]].publisher+"\n================================================================================================================================================================================\nLANGUAGE:                                                                              ||  "+Book.book[User.user[uid].cart[i]].language+"\n================================================================================================================================================================================\nM.R.P. (IN RS.):                                                                       ||  RS."+Book.book[User.user[uid].cart[i]].mrp+"\n================================================================================================================================================================================\n");
                    }
                    System.out.print("\n\n\t\t\t\t\t\t\t\t\t    ORDER SUCCESSFUL!\n\n================================================================================================================================================================================\nMODE OF PAYMENT: CASH ON DELIVERY\n================================================================================================================================================================================\nAMOUNT TO BE PAID ON DELIVERY: RS."+price+"\n================================================================================================================================================================================\nORDER ID: "+tid+"\n================================================================================================================================================================================\n\nWILL BE DELIVERED TO ADDRESS:\n"+User.user[Homepage.uid].address);
                    for(int i = 0;i < User.user[uid].quantity;i++)
                    {
                        User.user[uid].cart[i] = -1;
                    }
                    User.user[uid].quantity = 0;
                    FileWriter fout2 = new FileWriter(uid + "_cart");
                    fout2.close();
                    break;
                    case 3:
                    System.out.print("\f");
                    Homepage homepage = new Homepage(Homepage.uid);
                    homepage.main();
                    return;
                    default:
                    System.out.print("\fInvalid Entry!");
                }
                System.out.print("\n\nWhat do you want to do?\n1. Return to user homepage\n2. Exit this application\n\nEnter your choice (1/2): ");
                ch = sc.nextInt();
                switch(ch)
                {
                    default:
                    System.out.print("Invalid entry! You will be redirected to the homepage.");
                    try
                    {
                        Thread.sleep(1000);
                    }catch(Exception e){}
                    case 1:
                    System.out.print("\f");
                    Homepage homepage = new Homepage(Homepage.uid);
                    homepage.main();
                    return;
                    case 2:
                    Exit.main();
                    return;
                }
                case 3:
                try
                {
                    Thread.sleep(1000);
                }catch(Exception e){}
                System.out.print("\f");
                Homepage homepage = new Homepage(Homepage.uid);
                homepage.main();
                return;
            default:
                System.out.print("Invalid entry! You will be redirected to the homepage.");
                try
                {
                    Thread.sleep(1000);
                }catch(Exception e){}
                System.out.print("\f");
                Homepage homepage2 = new Homepage(Homepage.uid);
                homepage2.main();
                return;
            }
    }
}
