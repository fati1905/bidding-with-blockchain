import java.util.Scanner;
import java.util.InputMismatchException;

public class Product
{
    String name;
    String description;

    //Méthode pour "clear" l'écran
    public static void clearScreen()
    {
        for(int i = 0; i < 100; i++)
        {
            System.out.println("");
        }
    }

    public Product()
    {
        //Scanner
        Scanner sc = new Scanner(System.in);

        //Name
        while(true)
        {
            try
            {
                System.out.print("Product name : ");
                name = sc.nextLine();
                break;
            }
            
            catch (InputMismatchException ex)
            {
                clearScreen();
                System.out.println("Format not valid : "+ex);
                sc.nextLine();
            }
        }

        //Description
        while(true)
        {
            try
            {
                System.out.print("Product description : ");
                description = sc.nextLine();
                break;
            }
            
            catch (InputMismatchException ex)
            {
                clearScreen();
                System.out.println("Format not valid : "+ex);
                sc.nextLine();
            }
        }
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
