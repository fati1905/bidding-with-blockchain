import java.util.Scanner;

public class Product {
    String name;
    String description;

    public Product() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the products name : ");
        this.name = sc.nextLine();

        System.out.println("Enter the description of the product : ");
        this.description = sc.nextLine();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
