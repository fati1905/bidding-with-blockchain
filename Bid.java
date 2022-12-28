import java.util.Calendar;
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

    //todo: See how to schedule the bid later
    Calendar calendar;
    double timer;


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
                System.out.print("Start value : ");
                //this.priceStart = sc.nextDouble(); check to read calendar
                break;
            }
            
            catch (InputMismatchException ex)
            {
                clearScreen();
                System.out.println("Format not valid : "+ex);
                sc.nextLine();
            }
        }

        this.calendar = calendar;
        this.timer = timer;
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

    public Calendar getCalendar() {
        return calendar;
    }

    public double getTimer() {
        return timer;
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

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setTimer(double timer) {
        this.timer = timer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
