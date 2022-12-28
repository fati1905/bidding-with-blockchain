import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    //Starting date and duration of the bid
    Calendar startDate = Calendar.getInstance();//Starts right away, as default
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
        //Format of date and time
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
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
                System.out.print("Enter the date and time of start (DD/MM/YYYY HH:MM:SS): ");
                String date = sc.nextLine();
                startDate.setTime(format.parse(date));
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

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public int getDuration() {
        return duration;
    }


    public void setDuration(int duration) {
        this.duration = duration;
    }
}
