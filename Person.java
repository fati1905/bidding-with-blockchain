import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Person {

    private String fname;//first name
    private String lname; //last name
    private int age;//The age
    private double money; //Money
    ArrayList<Product> myProducts; //List of owned products

    //Méthode pour "clear" l'écran
    public static void clearScreen()
    {
        for(int i = 0; i < 100; i++)
        {
            System.out.println("");
        }
    }

    //Constructeur
    public Person()
    {
        //Pour scanner les saisies de l'utilisateur
        Scanner sc  = new Scanner(System.in);

        //Prénom
        while(true)
        {
            try
            {
                System.out.print("Enter your first name : ");
                this.fname = sc.nextLine();
                break;
            }
            
            catch (InputMismatchException ex)
            {
                clearScreen();
                System.out.println("Format not valid : "+ex);
                sc.nextLine();
            }
        }

        //Nom
        while(true)
        {
            try
            {
                System.out.print("Enter your last name : ");
                this.lname = sc.nextLine();
                break;
            }
            
            catch (InputMismatchException ex)
            {
                clearScreen();
                System.out.println("Format not valid : "+ex);
                sc.nextLine();
            }
        }

        //Age
        while(true)
        {
            try
            {
                System.out.print("Enter your age : ");
                this.age = sc.nextInt();
                break;
            }
            
            catch(InputMismatchException ex)
            {
                clearScreen();
                System.out.println("Format not valid : "+ex);
                sc.nextLine();
            }
        }

        //Money
        while(true)
        {
            try
            {
                System.out.print("Enter your bank resources : ");
                this.money = sc.nextDouble();
                break;

            }
            
            catch(InputMismatchException ex)
            {
                clearScreen();
                System.out.println("Format not valid : "+ex);
                sc.nextLine();
            }
        }

        //Object list
        myProducts = new ArrayList<Product>();
    }

    //Getters
    public String getFname()
    {
        return fname;
    }

    public String getLname()
    {
        return lname;
    }

    public int getAge()
    {
        return age;
    }

    public double getMoney()
    {
        return money;
    }

    //Setters
    public void setFname(String fname)
    {
        this.fname = fname;
    }

    public void setLname(String lname)
    {
        this.lname = lname;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setMoney(double money)
    {
        this.money = money;
    }

    public ArrayList<Product> getMyProducts() {
        return myProducts;
    }

    public void setMyProducts(ArrayList<Product> myProducts) {
        this.myProducts = myProducts;
    }
}
