import java.util.Scanner;
import java.util.InputMismatchException;

public class Bid
{
    //The seller of the bid
    Seller seller;

    //The object
    Product product;

    //Current offer
    Offer offer;

    //Starting price of the product
    Double priceStart;

    //When the bid start and how much time stay up
    int startWhen;
    int duration;


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
    public Bid(Seller seller, Product product)
    {
        this.seller = seller;
        this.product = product;

        //Scanner
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
                System.out.println("Format not valid : "+ex);
                sc.nextLine();
            }
        }

        //Starting date
        while(true)
        {
            try
            {
                System.out.print("Waiting time before it start : ");
                startWhen = sc.nextInt();
                break;
            }
            
            catch (InputMismatchException ex)
            {
                clearScreen();
                System.out.println("Format not valid : "+ex);
                sc.nextLine();
            }
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
                sc.nextLine();
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



    public int getStartWhen() {
        return startWhen;
    }



    public void setStartWhen(int startWhen) {
        this.startWhen = startWhen;
    }



    public int getDuration() {
        return duration;
    }



    public void setDuration(int duration) {
        this.duration = duration;
    }
}
