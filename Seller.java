import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;
import java.util.ArrayList;

public class Seller extends Person implements Runnable
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

    @Override
    public void run()
    {
        //Variables
        int index;
        Product toSell;
        Random rand = new Random();
        Thread th;
        Auction newAuction;
        ArrayList<Thread> threadList = new ArrayList<Thread>();

        //As long as there is at least one not sold product
        while(this.getMyProducts().size() != 0)
        {
            //As long as the seller as not put every object he has in sale, it never end
            //Random waiting time between 2 and 5 seconds
            try
            {
                Thread.sleep(2000 + rand.nextInt(3000));
            }
            
            catch (Exception e)
            {
                System.out.println("Error while waiting...");
            }

            //Now, we pick a random object within the product list to create a sell
            index = rand.nextInt(this.getMyProducts().size()); //Getting product's index
            toSell = this.getMyProducts().get(index);
            this.getMyProducts().remove(index); //We remove the element from the list

            //Now, we must create the auction
            //We create a thread for auction
            newAuction = new Auction(this, toSell);
            th = new Thread(newAuction);
            th.start();

            //We add this thread to wait for all auction to be ended to end this thread
            threadList.add(th);

            System.out.println("    New auction : "+toSell.getName());
        }

        for(int i = 0; i < threadList.size(); i++)
        {
            try
            {
                threadList.get(i).join();
            }
            
            catch (InterruptedException e)
            {
                System.out.println("An error occured, cannot wait thread to end...");
            }
        }
    }
}