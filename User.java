import java.io.*;
public class User
{
    String fname, lname, username, password, gender, address;
    int dob, mob, yob, quantity = 0;
    int cart[] = new int[10000];
    static User user[] = new User[1000];
    static int count = -1;
    static FileReader ufr;
    static BufferedReader ubr;
    static FileWriter ufout;
    static BufferedWriter ub;
    static PrintWriter up;
    User(String f, String l, String un, String pwd, String gdr, int d, int m, int y)
    {
        fname = f;
        lname = l;
        username = un;
        password = pwd;
        gender = gdr;
        dob = d;
        mob = m;
        yob = y;
    }
    static void addUser(String f, String l, String un, String pwd, String gdr, int d, int m, int y) throws IOException
    {
        count++;
        
        //Add new user
        up.println(count);
        up.println(un);
        up.println(pwd);
        up.println(f);
        up.println(l);
        up.println(gdr);
        up.println(d);
        up.println(m);
        up.println(y);
        up.flush();
        User.user[User.count] = new User(f, l, un, pwd, gdr, d, m, y);
        
        FileWriter fout = new FileWriter(count + "_cart");
        fout.close();
    }
    static void initialize() throws IOException
    {
        ufout = new FileWriter("users", true);
        ub = new BufferedWriter(ufout);
        up = new PrintWriter(ub);
        
        FileReader u = new FileReader("users");
        BufferedReader br = new BufferedReader(u);
        String fname, lname, username, password, gender, address;
        int dob, mob, yob;
        String s = br.readLine();
        while(s != null)
        {
            count = Integer.parseInt(s);
            username = br.readLine();
            password = br.readLine();
            fname = br.readLine();
            lname = br.readLine();
            gender = br.readLine();
            dob = Integer.parseInt(br.readLine());
            mob = Integer.parseInt(br.readLine());
            yob = Integer.parseInt(br.readLine());
            user[count] = new User(fname, lname, username, password, gender, dob, mob, yob);
            FileReader cart_fr = new FileReader(count + "_cart");
            BufferedReader cart_br = new BufferedReader(cart_fr);
            String temp_cart = cart_br.readLine();
            while(temp_cart != null)
            {
                User.user[count].quantity++;
                User.user[count].cart[User.user[count].quantity - 1] = Integer.parseInt(temp_cart);
                temp_cart = cart_br.readLine();
            }
            s = br.readLine();
        }
    }
}
