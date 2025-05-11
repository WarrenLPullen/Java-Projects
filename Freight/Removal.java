/**
 *  
 *
 * @author Warren Pullen
 * @v1
 */
public class Removal extends Freight
{
   private int volume; //the volume of freight required to be transported

    /**
     * Constructor for objects of class Removals
     * @param anAddress the address the removal is to
     * @param aVolume the volume of the goods to be removed
     */
    public Removal(String anAddress, int aVolume)
    {
       super(anAddress);
       volume = aVolume;
    }
    /**
     * Calucates qoute for freight transportation based on cost per unit price
     */
    public double createQuote (int costUnitPrice)
    {
        double totalPrice = volume * costUnitPrice / 100.0;
        return Math.round(totalPrice * 100.0)/ 100.0;
    }
    
}