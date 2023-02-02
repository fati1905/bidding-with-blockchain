import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Auction implements Runnable
{
    //The seller of the auction
    Seller seller;

    //The object
    Product product;

    //Current offer
    Offer offer;

    //Starting price of the product
    Double priceStart;

    //When the auction start and how much time stay up
    Calendar startWhen = Calendar.getInstance();
    int duration;//todo : How does it stop

    //List of observer
    ArrayList<Buyer> interestedBuyers = new ArrayList<Buyer>();


    //Méthode pour "clear" l'écran
    public static void clearScreen()
    {
        for(int i = 0; i < 100; i++)
        {
            System.out.println("");
        }
    }



    //Take as parameter only the seller and the product which is selling, we decide here
    //When we want to sell it
    public Auction(Seller seller, Product product)
    {
        Random rand = new Random();

        this.seller = seller;
        this.product = product;
        this.offer = null; //No offer when we start
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); //Le format de la date

        //Now we randomize starting price, duration and how much time we wait before we start the auction
        /*startWhen = 3 + rand.nextInt(7); //Wait between 3 and 10 seconds before it goes online
        duration = 15 + rand.nextInt(15); //Wait between 15 and 30 seconds before it ends
        priceStart = 10 + rand.nextDouble(90); //Start between 10 and 100 unit of money
        */

        Scanner sc = new Scanner(System.in);

        //Starting value
        while(true)
        {
            try
            {
                System.out.print("Start value : ");
                this.priceStart = sc.nextDouble();
                break;
            }

            catch (InputMismatchException ex)
            {
                clearScreen();
                System.out.println("Format not valid : "+ex.getMessage());
            }
        }

        //Starting date
        while(true)
        {
            try
            {
                System.out.print("Enter the date and time of start (DD/MM/YYYY HH:MM:SS): ");
                String date = sc.nextLine();
                startWhen.setTime(format.parse(date));
            }
            catch (InputMismatchException ex)
            {
                clearScreen();
                System.out.println("Invalid format : "+ex.getMessage());
                continue;
            }catch (ParseException pe){
                clearScreen();
                System.out.println("invalid format : "+pe.getMessage());
                continue;
            }
            break;
        }

        //Ending date
        while(true)
        {
            try
            {
                System.out.print("How much time does it stay online ? : ");
                duration = sc.nextInt();
                break;
            }

            catch (InputMismatchException ex)
            {
                clearScreen();
                System.out.println("Format not valid : "+ex);
            }
        }
    }

    public Seller getSeller() {
        return seller;
    }

    public Offer getOffer() {
        return offer;
    }

    public Double getPriceStart() {
        return priceStart;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public void setPriceStart(Double priceStart) {
        this.priceStart = priceStart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Calendar getStartWhen() {
        return startWhen;
    }

    public void setStartWhen(Calendar startWhen) {
        this.startWhen = startWhen;
    }

    public int getDuration() {
        return duration;
    }



    public void setDuration(int duration) {
        this.duration = duration;
    }



    @Override
    public void run()
    {
        //We first wait to start the auction
        try
        {
            Calendar instantTime = Calendar.getInstance();
            long now = instantTime.getTimeInMillis();
            long debut = this.startWhen.getTimeInMillis();
            Thread.sleep((long)debut-now);
        }

        catch (Exception e)
        {
            System.out.println("An error occured while waiting...");
        }
        
        //Once the waiting time is over, we had ourselves to the auction list
        Main.getListeEncheres().add(this);

        //Now, we wait for the duration
        try
        {
            Thread.sleep((long)duration*1000);
        }

        catch (Exception e)
        {
            System.out.println("An error occurred while waiting...");
        }

        //The auction has ended, we add the product to the buyer, remove it form the seller inventory and transfer the money from the buyer to the seller
        synchronized(this)
        {
            if(this.getOffer() != null)
            {
                //Give money to seller
                this.getSeller().setMoney(this.getSeller().getMoney() + this.getOffer().getPrixProp());

                //Adding the product to buyer inventory
                this.getOffer().getBuyer().getMyProducts().add(this.getProduct());
            }
            else
            {
                //we give back the item to the seller
                this.getSeller().getMyProducts().add(this.getProduct());
            }
        }
    }



    public ArrayList<Buyer> getInterestedBuyers()
    {
        return interestedBuyers;
    }



    public void setInterestedBuyers(ArrayList<Buyer> interestedBuyers)
    {
        this.interestedBuyers = interestedBuyers;
    }
}
