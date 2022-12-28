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

        //Variables associées aux vendeurs
        ArrayList<Seller> listeVendeurs = new ArrayList<Seller>();

        //Variables associées aux acheteurs
        ArrayList<Buyer> listeAcheteurs = new ArrayList<Buyer>();

        //Variables associées aux mineurs
        ArrayList<Miner> listeMineurs = new ArrayList<Miner>();

        //Variables associées aux objets (uniquement les produits qui n'appartiennent à personne)
        ArrayList<Product> listeProduits = new ArrayList<Product>();

        //Variables associées aux enchères


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
            System.out.println("[1] Ajouter une personne");
            System.out.println("[2] Créer une enchère");
            System.out.println("[4] Fin");
            System.out.println("");
            System.out.print("MON CHOIX : ");

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
                        System.out.println("création d'une enchère");
                        break;

                    case 3:
                        System.out.println("création d'un objet");
                        break;

                    case 4:
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