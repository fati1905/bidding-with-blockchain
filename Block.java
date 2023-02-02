import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.LinkedList;
import java.util.Random;

public class Block {
    final private int beta;
    private LinkedList<Offer>transactions;
    private String currentHash;
    private String previousHash;
    final private int prefixInt = 20;

    public Block() {
        Random rand = new Random();
        this.beta = rand.nextInt(9)+1;
        this.transactions = new LinkedList<>();
    }

    public int getBeta() {
        return beta;
    }

    public LinkedList<Offer> getTransactions() {
        return transactions;
    }

    public void setTransactions(LinkedList<Offer> transactions) {
        this.transactions = transactions;
    }

    public String getCurrentHash() {
        return currentHash;
    }

    public void setCurrentHash(String currentHash) {
        this.currentHash = currentHash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public int getPrefixInt() {
        return prefixInt;
    }

    public String hashBlock(){
        //We concatenate the variables we have
        String toHash = Integer.toString(beta)+previousHash+transactions.toString();

        try{
            //MessageDigest take an arbitrary value and returns its hash (we will use SH-256 as an algorithm)
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //We will hash the concatenation of our variables using an array of bytes in UTF8
            byte[] hashByte = digest.digest(toHash.getBytes(StandardCharsets.UTF_8));

            //Convert the byte array into a hex
            StringBuffer stringbuffer = new StringBuffer();
            for (byte b : hashByte) {
                stringbuffer.append(String.format("%02x", b));
            }

            return stringbuffer.toString();

        }catch (java.security.NoSuchAlgorithmException ex){
            System.out.println("Your offer is not secured : "+ex.getMessage());
            //todo: what to do in case a problem was encountered while hashing the block
            return null;
        }
    }

    public void addOffer(Offer offer){
        if(transactions.size()<beta){
            this.transactions.add(offer);
        }else{
            //todo: faut l'ajouter à une blockchain

        }
    }


    public String numberZeros(){
        //Create a string
        char[] temp = new char[prefixInt];
        for(int i = 0; i <prefixInt; ++i){
            temp[i] = '0';
        }

        return  String.valueOf(temp);
    }

    //Miners search for a prefix that contains 20 zeros
    public String mineBlock(){

        String zeros = numberZeros();

        this.currentHash = hashBlock();
        while(!currentHash.substring(0,prefixInt).equals(zeros)){
            currentHash = hashBlock();
        }
        return currentHash;
    }



}
