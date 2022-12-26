import java.util.Scanner;

public class Buyer extends Person {
    double sum;

    public Buyer() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the sum you will use for the bid : ");
        while (true){
            try {
                this.sum = sc.nextDouble();
            }catch(NumberFormatException nfe){
                System.out.println("Your input is not valid : "+nfe.getMessage());
                continue;
            }
            break;
        }
    }
}
