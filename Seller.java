import java.util.Scanner;

public class Seller extends Person
{
    public Seller()
    {
        super();

        //Scanner
        Scanner sc = new Scanner(System.in);
        String choix;

        boolean flag = true;
        //Since this is a seller, we can add some product
        while(flag)
        {

            System.out.print("[Y/N] Ajouter un objet ? : ");

            try
            {
                //Read user input
                choix = sc.nextLine();

                switch(choix)
                {
                    case "Y":
                        clearScreen();
                        myProducts.add(new Product());
                        break;

                    case "N":
                        clearScreen();
                        flag = false;
                        break;

                    default:
                        clearScreen();
                        System.out.println("This is not a valid choice !");
                        System.out.println("");
                        break;
                }
            }

            catch(java.util.InputMismatchException e)
            {
                clearScreen();
                System.out.println("Format not valid : "+e);
                System.out.println("");
                sc.nextLine(); //Get rid of user wrong input
            }
        }
    }
}