import java.util.InputMismatchException;
import java.util.Scanner;

public class Person {

    private String fname;//first name
    private String lname; //last name
    private int age;//The age
    private double montant;

    public Person() {
        Scanner sc  = new Scanner(System.in);

        System.out.println("Enter your first name : ");
        while(true){
            try {
                this.fname = sc.nextLine();
            }catch (InputMismatchException ex){
                System.out.println("Format not valid : "+ex.getMessage());
                continue;
            }
            break;
        }

        System.out.println("Enter your last name : ");
        while(true){
            try {
                this.lname = sc.nextLine();
            }catch (InputMismatchException ex){
                System.out.println("Format not valid : "+ex.getMessage());
                continue;
            }
            break;
        }

        System.out.println("Enter your age : ");
        while(true){
            try {
                this.age = sc.nextInt();
            }catch (InputMismatchException ex){
                System.out.println("Format not valid : "+ex.getMessage());
                continue;
            }
            break;
        }

        //Montant
        System.out.println("Enter your bank resources : ");
        while(true){
            try {
                this.montant = sc.nextDouble();
            }catch (InputMismatchException ex){
                System.out.println("Format not valid : "+ex.getMessage());
                continue;
            }
            break;
        }
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public int getAge() {
        return age;
    }

    public double getMontant() {
        return montant;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
