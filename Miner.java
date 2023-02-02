public class Miner extends Person implements Runnable
{
    Block blocs;
    public Miner(Block blocs)
    {
        super();
        this.blocs = blocs;
    }

    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        //Wait for event (new offer) --> arraywaitingqueue ? when new offer put the bid in the queue ?
        blocs.mineBlock();

    }
}