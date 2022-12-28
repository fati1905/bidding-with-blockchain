import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Thread;

public class Main {

    //Méthode pour "clear" l'écran
    public static void clearScreen()
    {
        for(int i = 0; i < 100; i++)
        {
            System.out.println("");
        }
    }

    //Variables associées aux enchères
    private static ArrayList<Auction> listeEncheres = new ArrayList<Auction>();

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

        //Liste des threads vendeur actifs
        ArrayList<Thread> threadVendeur = new ArrayList<Thread>();

        //Liste des threads acheteur actifs
        ArrayList<Thread> threadAcheteur = new ArrayList<Thread>();

        //Liste des threads mineur actifs
        ArrayList<Thread> threadMineur = new ArrayList<Thread>();


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

                        //Threads des vendeurs
                        for(int j = 0; j < listeVendeurs.size(); j++)
                        {
                            Thread myThread = new Thread(listeVendeurs.get(j));
                            myThread.start();

                            //We add the thread to the list
                            threadVendeur.add(myThread);
                        }

                        //Threads des mineurs
                        for(int j = 0; j < listeMineurs.size(); j++)
                        {
                            Thread myThread = new Thread(listeMineurs.get(j));
                            myThread.start();

                            //We add the thread to the list
                            threadMineur.add(myThread);
                        }

                        //Threads des acheteurs
                        for(int j = 0; j < listeAcheteurs.size(); j++)
                        {
                            Thread myThread = new Thread(listeAcheteurs.get(j));
                            myThread.start();

                            //We add the thread to the list
                            threadAcheteur.add(myThread);
                        }

                        //We wait for all seller thread to end (meaning all auctions are done)
                        for(int j = 0; j < threadVendeur.size(); j++)
                        {
                            try
                            {
                                threadVendeur.get(j).join();
                            }
                            
                            catch(InterruptedException e)
                            {
                                System.out.println("Error while waiting thread to end...");
                            }
                        }

                        //Once this is done, we stop all the miner and buyer threads
                        for(int j = 0; j < threadAcheteur.size(); j++)
                        {
                            threadAcheteur.get(j).interrupt();
                        }

                        for(int j = 0; j < threadMineur.size(); j++)
                        {
                            threadMineur.get(j).interrupt();
                        }

                        System.out.println("");
                        System.out.println("    ==== SELLERS ====");
                        System.out.println("");
                        //We display all the datas, to show the simulation worked properly
                        for(int j = 0; j < listeVendeurs.size(); j++) //Sellers
                        {
                            System.out.println("    Seller : "+listeVendeurs.get(j).getFname()+" "+listeVendeurs.get(j).getLname()+" (AGE : "+ listeVendeurs.get(j).getAge()+")");
                            System.out.println("    Money : "+listeVendeurs.get(j).getMoney());
                            System.out.println("    Products :");
                            for(int k = 0; k < listeVendeurs.get(j).getMyProducts().size(); k++)
                            {
                                System.out.println("      --> "+listeVendeurs.get(j).getMyProducts().get(k).getName());
                            }
                            System.out.println("");
                            System.out.println("    --------------");
                            System.out.println("");
                        }

                        System.out.println("");
                        System.out.println("    ==== BUYERS ====");
                        System.out.println("");
                        for(int j = 0; j < listeAcheteurs.size(); j++) //Sellers
                        {
                            System.out.println("    Buyer : "+listeAcheteurs.get(j).getFname()+" "+listeAcheteurs.get(j).getLname()+" (AGE : "+ listeAcheteurs.get(j).getAge()+")");
                            System.out.println("    Money : "+listeAcheteurs.get(j).getMoney());
                            System.out.println("    Products :");
                            for(int k = 0; k < listeAcheteurs.get(j).getMyProducts().size(); k++)
                            {
                                System.out.println("      --> "+listeAcheteurs.get(j).getMyProducts().get(k).getName());
                            }
                            System.out.println("");
                            System.out.println("    --------------");
                            System.out.println("");
                        }

                        System.out.println("");
                        System.out.println("    ==== MINERS ====");
                        System.out.println("");
                        for(int j = 0; j < listeMineurs.size(); j++) //Sellers
                        {
                            System.out.println("    Miner : "+listeMineurs.get(j).getFname()+" "+listeMineurs.get(j).getLname()+" (AGE : "+ listeMineurs.get(j).getAge()+")");
                            System.out.println("    Money : "+listeMineurs.get(j).getMoney());
                            System.out.println("    Products :");
                            for(int k = 0; k < listeMineurs.get(j).getMyProducts().size(); k++)
                            {
                                System.out.println("       --> "+listeMineurs.get(j).getMyProducts().get(k).getName());
                            }
                            System.out.println("");
                            System.out.println("    --------------");
                            System.out.println("");
                        }

                        //Then, we erase all data and restart the program
                        threadVendeur = new ArrayList<Thread>();
                        listeVendeurs = new ArrayList<Seller>();
                        listeAcheteurs = new ArrayList<Buyer>();
                        listeMineurs = new ArrayList<Miner>();
                        System.out.println("");
                        continue;

                    case 3:
                        //End of the program
                        System.exit(1);
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


    public static ArrayList<Auction> getListeEncheres()
    {
        return listeEncheres;
    }
}