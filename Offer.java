public class Offer
{
    private double prixProp; //Le prix proposé
    private Buyer buyer; //L'acheteur

    public Offer(Buyer buyer, double price)
    {
        this.buyer = buyer;
        this.prixProp = price;
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
