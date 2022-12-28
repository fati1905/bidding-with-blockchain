public class Buyer extends Person
{
    public Buyer()
    {
       super();
    }

    //Permet à un acheteur de faire une offre sur une enchère
    public void makeOffer(Bid bid, int newOffer)
    {
        //On vérifie si l'utilisateur a l'argent
        if(this.getMoney() < newOffer)
        {
            clearScreen();
            System.out.println("Not enough balance.");
            System.out.println("");
            return;
        }

        //Si vaut null, on prend la première offre (si supérieur à la mise de départ !)
        if(bid.getOffer() == null)
        {
            if(bid.getPriceStart() < newOffer)
            {
                bid.setOffer(new Offer(this, newOffer));
                return;
            }

            clearScreen();
            System.out.println("Offer placed !");
            System.out.println("");
            return;
        }

        //Si différent de null, on vérifie si l'offre bat l'offre courante
        if(newOffer > bid.getOffer().getPrixProp())
        {
            bid.setOffer(new Offer(this, newOffer));
            clearScreen();
            System.out.println("Offer placed !");
            System.out.println("");
            return;
        }


        clearScreen();
        System.out.println("Offer don't beat current offer.");
        System.out.println("");
        return;
    }
}
