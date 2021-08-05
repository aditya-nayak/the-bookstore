import java.io.*;
import java.util.*;
public class Homepage
{
    static int uid;
    private int ch;
    Homepage(int id)
    {
        uid = id;
    }
    void main() throws IOException
    {
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.print("Hi "+((User.user[uid].gender.equals("Male"))?"Mr. ":"Ms. ")+User.user[uid].fname+" "+User.user[uid].lname+"!\nWelcome to the Bookstore!\n\nWhat do you want to do?\n1. Buy a Book\n2. Search for a book in our library\n3. View a list with details of all the books in the library\n4. View your Cart and Checkout\n5. View or Edit your Profile Details\n6. Sign Out\n7. Exit\n\nPlease enter your choice (1/2/3/4/5/6/7): ");
            ch = sc.nextInt();
            switch (ch)
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
                System.out.print("\f");
                Book_Search bookSearch = new Book_Search();
                bookSearch.main();
                return;
                case 3:
                System.out.print("\f");
                Book book = new Book();
                book.viewBookList();
                return;
                case 4:
                if(User.user[uid].quantity > 0)
                {
                    Buy_Book buyBook2 = new Buy_Book();
                    buyBook2.checkout();
                }
                else
                {
                    System.out.println("\f\nThere are no books in your cart. Please add at least one book to your cart before proceeding to the checkout page.\n\n");
                    Homepage homepage = new Homepage(Homepage.uid);
                    homepage.main();
                }
                return;
                case 5:
                System.out.print("\f");
                View_Edit_Profile viewEditProfile = new View_Edit_Profile();
                viewEditProfile.main();
                return;
                case 6:
                Index index = new Index();
                index.main();
                return;
                case 7:
                Exit.main();
                return;
                default:
                System.out.println("\fInvalid Entry. Please try again.\n");
            }
        }
    }
}
