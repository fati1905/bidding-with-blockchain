import java.util.ArrayList;

public class Seller extends Person{
    ArrayList<Product> myProducts;

    public Seller() {
        super();
        this.myProducts = new ArrayList<>();
    }

    public ArrayList<Product> getMyProducts() {
        return myProducts;
    }

    public void setMyProducts(ArrayList<Product> myProducts) {
        this.myProducts = myProducts;
    }

    void addProduct(){
        Product pro = new Product();
        myProducts.add(pro);
    }
}
