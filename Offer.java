import java.util.InputMismatchException;
import java.util.Scanner;

public class Offer {
    private double prixProp; //Le prix proposé
    private Buyer buyer;

    public Offer(Buyer buyer) {
        this.buyer = buyer;

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your price offer : ");
        while (true){
           try {
               this.prixProp = sc.nextDouble();
           }catch (InputMismatchException ex){
               System.out.println("Input is invalid : "+ex.getMessage());
               continue;
           }
           break;
        }
    }

    public double getPrixProp() {
        return prixProp;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setPrixProp(double prixProp) {
        this.prixProp = prixProp;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }
}
