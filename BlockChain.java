import java.util.Iterator;
import java.util.LinkedList;

public class BlockChain {
    LinkedList<Integer> blockchain = new LinkedList<>();


    void hashBlock(Block block){
        //The first block
        if (blockchain.size() == 1){

        }else {
                String prefixe = "test"; //Les mineurs doivent le trouver
                //blockchain.add(prefixe+""+block.transactions.hashCode());

        }
    }
}
