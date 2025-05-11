import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Child class of Freight, represents a parcel and stores its weight,width,length and weight
 * methods get side sizes of the parcel object, calucate the size of the parcel and also 
 * compare it againsts provided constraints
 * 
 * 
 * @author Warren Pullen
 * @01/05/2024
 */
public class Parcel extends Freight
{    
    private double weight;  //The parcels weight in kilos  
    private int width; // the parcel's  width in cms    
    private int length; //the parcel's length in cms
    private int height; //The parcel's height in cms 
    /** the maximum permissible length of the parcel in cms */
    public static final int LENGTH_LIMIT = 120;
    /** the maximum permissible size of the parcel in cms */
    public static final int SIZE_LIMIT = 245;
    /** the maximum permissible size of the parcel in kilos */
    public static final int WEIGHT_LIMIT = 5;
    
    /**
     * public constructor
     */
    public Parcel(String address,double weight, int width, int length, int height)
    {
        //Call address from Freight (Parent Class)
        super(address);
        //Calls SetDateSent method from Freight( (Parent Class) and populates as an empty String
        setDateSent ("");
        this.weight = weight;
        this.width = width;
        this.length = length;
        this.height = height;
    }
    
    /**
     * public method which takes int arguments for the width, length and height of the parcel 
     * creates a new list called sides, adds arguments to the list and then orders 
     * from smallest to largest and returns the list
     */
    public ArrayList<Integer>getOrderSides (int width,int length,int height)
    {
        //creates new integer list called sides 
        ArrayList<Integer> sides = new ArrayList<>(); 
        //populates list with width,length and height
        sides.add(width);
        sides.add(length);
        sides.add(height);
        //orders from smallest to largest 
        Collections.sort(sides);
        //returns contents of list sides
        System.out.println (sides);
        return sides;
    }
    
    /**
     * public instance method which compares length,width and height and returns the highest 
     * value
     */
    public double getLongestSide()
    {
        //variable which stores length 
        double longest = length;
        // checks if width is greater then length if so sets longests variable as width if not keeps length as longest
        if (width > length){
            longest = width;
        }
        // checks if height is greater then width if so sets longests variable as height if not keeps length as longest 
        if (height > width){
            longest = height;
        }
        // returns longest variable
        return longest;
       
        
    }
    
    /**
     * calucates and returns the size of the parcel based upon the formula on adding 
     * the shortest and next shortest side multiplying by 2 and adding the longest side
     */
    public double getParcelSize()
    {
        double shortest =Math.min(length, Math.min(width,height)); //calucate shortest side from length height and width
        double longest = getLongestSide(); // uses getLongestSide method to store longest side
        double nextShortest = (length + width + height) - (shortest + longest);// calucate nextshortest side 
        double parcel_size = 0; // set parcel size to zero
        
        parcel_size = (shortest + nextShortest) * 2 + longest; // calucates parcel size based upon formula provided 
        
        return parcel_size; // returns parcel size
        
        
    }
    
    /**
     * Public method which compares the longest side, parcel size and parcel weight againist 
     * constraints, if all are below the constraints the method returns true if not the method 
     * returns false
     */
    public boolean isWithinLimits()
    {
        double longest = getLongestSide();
        double parcel_size = getParcelSize();
        double parcel_weight = weight;
        
        if (longest <= LENGTH_LIMIT && parcel_size <= SIZE_LIMIT && parcel_weight 
        <= WEIGHT_LIMIT){
        return true;
    }
    return false;
    }
    
    /**
    * @Getter method which returns objects weight
    */
    public double returnweight()
    {
        return weight;
    }
    
    /** Equals method for this object.
     * @return true if objects compared are same class or subclass and
     * have the same address and dateSent
     */
     public boolean equals(Object o)
     {
     if(o != null && o instanceof Parcel)
     {
     Parcel p = (Parcel) o;
     return getAddress().equals(p.getAddress()) && getDateSent().equals(p.getDateSent());
     }
     return false;
     }
     /*
      * return a string representation of the parcel
      */
     public String toString()
     {
     String returnString = "A parcel for " + getAddress()  + "\nWeight " + weight + 
     "Kg, Width " + width + "cms,  Height " + height + "cms,  Length "  + length + "cms.";
     
     

     return returnString;
     } 
     
     /**
      * public method which takes an interger argument representing cost per kilo 
      * 
      */
     public double createQuote (int costPerKilo)
     {
     double weightInKilos = weight /1000.0;
     double totalPrice = weightInKilos * costPerKilo /100.0;
     return Math.round(totalPrice * 100.0) / 100.0;
     }

}
