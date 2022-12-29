import java.util.Random;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Buyer extends Person implements Runnable
{

    //Before searching for a new auction, the buyer look for every notification he have
    ArrayList<Auction> newOffer;

    public Buyer()
    {
       super();
       newOffer = new ArrayList<Auction>();
    }

    @Override
    public void run()
    {

        //Variables
        Random rand = new Random();
        Auction auction;
        Buyer aBuyer;
        DecimalFormat df = new DecimalFormat(".00");

        try
        {
            //as long as the current thread is not ended by the main
            while(!Thread.currentThread().isInterrupted())
            {
                //Look for notification
                while(newOffer.size() != 0)
                {

                    auction = newOffer.get(0);

                    synchronized(auction)
                    {
                        //See if he has the money, etc... but only 20% of making a counter offer
                        if(this.getMoney() > auction.getOffer().getPrixProp() && (1 + rand.nextInt(100)) < 21 && auction.getOffer().getBuyer() != this) //ne doit pas être celui qui a déjà l'offre
                        {
                            //We first have to refund the owner of the current offer
                            aBuyer = auction.getOffer().getBuyer();//todo : Il ne doit pas y avoir de rembouresement, celui qui fait le dernier offre qui achète réelement le produit
                            aBuyer.setMoney(aBuyer.getMoney() + auction.getOffer().getPrixProp());

                            //We replace the current offer by a random offer
                            auction.setOffer(new Offer(this, auction.getOffer().getPrixProp() + (rand.nextDouble(this.getMoney() - auction.getOffer().getPrixProp()))*0.2));

                            //We remove the amount to the buyer
                            this.setMoney(this.getMoney() - auction.getOffer().getPrixProp());

                            //Now this buyer made a counter offer for the randomly selected product
                            System.out.println("    "+this.getFname()+" counter offered "+df.format(auction.getOffer().getPrixProp())+ " for "+auction.getProduct().getName()+" !");
                        }
                    }

                    //No matter if the counter offer is made or not, we remove the notification
                    newOffer.remove(0);
                }

                //Waiting between 2 and 5 seconds
                Thread.sleep(2000 + rand.nextInt(3000));
            

                //Getting a random auction (need at least 1 auction)
                if(Main.getListeEncheres().size() > 0)
                {
                    auction = Main.getListeEncheres().get(rand.nextInt(Main.getListeEncheres().size()));
                }
                else
                {
                    continue;
                }

                //Now, 30% of making a better offer (if the offer is not already his)
                //When we check to create a new offer, we want to make sure we are the only one
                synchronized(auction)
                {
                    if(auction.getOffer() == null) //of no current offer
                    {
                        //if he has the money to beat the starting price
                        if(this.getMoney() > auction.getPriceStart() && (1 + rand.nextInt(100)) < 31)
                        {
                            //We set the offer
                            auction.setOffer(new Offer(this, auction.getPriceStart() + rand.nextDouble(this.getMoney() - auction.getPriceStart())));
                        }
                        else
                        {
                            continue;
                        }
                    }

                    else if(this.getMoney() > auction.getOffer().getPrixProp() && (1 + rand.nextInt(100)) < 31 && auction.getOffer().getBuyer() != this) //ne doit pas être celui qui a déjà l'offre
                    {
                        //We first have to refund the owner of the current offer
                        aBuyer = auction.getOffer().getBuyer();
                        aBuyer.setMoney(aBuyer.getMoney() + auction.getOffer().getPrixProp());

                        //We replace the current offer by a random offer
                        auction.setOffer(new Offer(this, auction.getOffer().getPrixProp() + (rand.nextDouble(this.getMoney() - auction.getOffer().getPrixProp()))*0.2));
                    }
                    else
                    {
                        continue;
                    }

                    //We remove the amount to the buyer
                    this.setMoney(this.getMoney() - auction.getOffer().getPrixProp());
                    //Now this buyer as an offer for the randomly selected product
                    System.out.println("    "+this.getFname()+" offered "+df.format(auction.getOffer().getPrixProp())+ " for "+auction.getProduct().getName());

                    //The buyer add himself to the intersted list (observer) of the auction if is not already in
                    if(!auction.getInterestedBuyers().contains(this))
                    {
                        auction.getInterestedBuyers().add(this);
                    }

                    //We notify every buyer interested that have already offered something for this product (execept the buyer with the current offer)
                    for(int i = 0; i < auction.getInterestedBuyers().size(); i++)
                    {
                        //Cannot signal himself if he have the current offer
                        if(auction.getInterestedBuyers().get(i) != this)
                        {
                            auction.getInterestedBuyers().get(i).getNewOffer().add(auction);
                        }
                    }

                    continue;
                }
            }
        }

        catch(InterruptedException ie)
        {
            //If all auction are ended
            return;
        }
    }

    public ArrayList<Auction> getNewOffer() {
        return newOffer;
    }

    public void setNewOffer(ArrayList<Auction> newOffer) {
        this.newOffer = newOffer;
    }
}
