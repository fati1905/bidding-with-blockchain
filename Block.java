import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Block {
    int beta;
    ArrayList<Offer> transactions;
    LinkedList<Integer> blocs = new LinkedList<>();

    public Block() {
        Random rand = new Random();
        this.beta = rand.nextInt(9) + 1;
        transactions = new ArrayList<>();
    }

    public int getBeta() {
        return beta;
    }

    public ArrayList<Offer> getTransactions() {
        return transactions;
    }

    public void setBeta(int beta) {
        this.beta = beta;
    }

    public void setTransactions(ArrayList<Offer> transactions) {
        this.transactions = transactions;
    }

    void addOffer(Offer offer){

        if(transactions.size()<beta){
            transactions.add(offer);
        }else{
            //todo: Create new block
        }

    }
}
