import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    //Méthode pour "clear" l'écran
    public static void clearScreen()
    {
        for(int i = 0; i < 100; i++)
        {
            System.out.println("");
        }
    }


    public static void main(String[] args)
    {
        //Compteur(s)
        int i;

        //Variables associées aux vendeurs
        ArrayList<Seller> listeVendeurs = new ArrayList<Seller>();

        //Variables associées aux acheteurs
        ArrayList<Buyer> listeAcheteurs = new ArrayList<Buyer>();

        //Variables associées aux mineurs
        ArrayList<Miner> listeMineurs = new ArrayList<Miner>();

        //Variables associées aux enchères
        ArrayList<Bid> listeEncheres = new ArrayList<Bid>();

        //Scanner
        Scanner sc = new Scanner(System.in);
        int choix;

        //Mettre fin a certaines boucles
        boolean flag = true;
        boolean flag2 = true;



        //On commence par nettoyer le terminal
        clearScreen();

        while(flag)
        {
            System.out.println("[1] Add an actor to the simulation");
            System.out.println("[2] Start simulation");
            System.out.println("[3] Quit");
            System.out.println("");
            System.out.print("CHOICE [1,2,3] : ");

            try
            {
                choix = sc.nextInt();
                clearScreen();
    
                switch(choix)
                {

                    case 1:

                        flag2 = true;

                        while(flag2)
                        {
                            System.out.println("[1] Acheteur");
                            System.out.println("[2] Vendeur");
                            System.out.println("[3] Mineur");
                            System.out.println("[4] Annuler");
                            System.out.println("");
                            System.out.print("MON CHOIX : ");

                            try
                            {
                                choix = sc.nextInt();
                                clearScreen();

                                switch(choix)
                                {
                                    case 1:
                                        listeAcheteurs.add(new Buyer());
                                        clearScreen();
                                        flag2 = false;
                                        break;

                                    case 2:
                                        listeVendeurs.add(new Seller());
                                        clearScreen();
                                        flag2 = false;
                                        break;

                                    case 3:
                                        listeMineurs.add(new Miner());
                                        clearScreen();
                                        flag2 = false;
                                        break;

                                    case 4:
                                        clearScreen();
                                        flag2 = false;
                                        break;

                                    default:
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

                        break;





                    case 2:

                        //Création de TOUT les threads, ouverture d'un autre terminal
                        //Qui affiche les transactions

                        do
                        {
                            //On commence par créer l'enchère, puis on y associe des acheteurs
                            System.out.println("Veuillez indiquer le vendeur : ");
                            System.out.println("");
                            for(i = 0; i < listeVendeurs.size(); i++)
                            {
                                System.out.println("["+i+"] "+listeVendeurs.get(i).getFname()+" "+listeVendeurs.get(i).getLname());
                            }
                            System.out.println("");
                            System.out.print("MON CHOIX : ");

                            try
                            {
                                //Reading user input then cleaning screen
                                choix = sc.nextInt();
                                clearScreen();

                                //We read if user input is valid
                                if(choix >= listeVendeurs.size())
                                {
                                    System.out.println("No corresponding seller, abort bid creation");
                                    System.out.println("");
                                    continue;
                                }

                                else
                                {
                                    //The selected seller (which is valid)
                                    Seller selectedSeller = listeVendeurs.get(choix);

                                    while(true)
                                    {
                                        //Now, we must choose the objet to create a bid on
                                        System.out.println("Veuillez indiquer le vendeur : ");
                                        System.out.println("");
                                        for(i = 0; i < selectedSeller.getMyProducts().size(); i++)
                                        {
                                            System.out.println("["+i+"] "+selectedSeller.getMyProducts().get(i).getName()+" : "+selectedSeller.getMyProducts().get(i).getDescription());
                                        }
                                        System.out.println("");
                                        System.out.print("MON CHOIX : ");

                                        try
                                        {
                                            //Reading user input then cleaning screen
                                            choix = sc.nextInt();
                                            clearScreen();

                                            //We read if user input is valid
                                            if(choix >= selectedSeller.getMyProducts().size())
                                            {
                                                System.out.println("No corresponding product, abort bid creation");
                                                System.out.println("");
                                                break;
                                            }

                                            else
                                            {
                                                //We can create the bid
                                                listeEncheres.add(new Bid(selectedSeller, selectedSeller.getMyProducts().get(choix)));
                                                break;
                                            }
                                        }

                                        catch(java.util.InputMismatchException e)
                                        {
                                            clearScreen();
                                            System.out.println("Format not valid : "+e);
                                            System.out.println("");
                                            sc.nextLine(); //Get rid of user wrong input
                                            break;
                                        }

                                        catch(IndexOutOfBoundsException ioobe)
                                        {
                                            clearScreen();
                                            System.out.println("Index : "+ioobe);
                                            System.out.println("");
                                            sc.nextLine(); //Get rid of user wrong input
                                            break;
                                        }
                                    }
                                }
                            }

                            catch(java.util.InputMismatchException e)
                            {
                                clearScreen();
                                System.out.println("Format not valid : "+e);
                                System.out.println("");
                                sc.nextLine(); //Get rid of user wrong input
                                continue;
                            }

                            catch(IndexOutOfBoundsException ioobe)
                            {
                                clearScreen();
                                System.out.println("Index : "+ioobe);
                                System.out.println("");
                                sc.nextLine(); //Get rid of user wrong input
                                continue;
                            }

                            clearScreen();
                        } while(true); //Boucle "run" (on ne sort jamais)

                    case 3:
                        flag = false;
                        break;

                    default:
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

        //Fermeture du scanner
        sc.close();
    }
}