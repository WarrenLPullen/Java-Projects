/**
 * @Warren Pullen
 * @version v1
 * Child class of Parcel,represents a tracked parcel, stores the tacking number, value and contents
 * 
 */
import java.util.HashSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class TrackedParcel extends Parcel
{
    private String trackingNumber;
    private int value;
    private HashSet <String> contents;// Hashset of type string
    public static final double TRACKING_FEE = 2.0;//in pound sterling
    
    /**
     * Public constructor 
     */
    public TrackedParcel(String address,double weight,int width,int length,int height,int value)
    {
    super(address,weight,width,length,height);// Calls address weight,width,length and height from parcel class
    contents = new HashSet<>();// sets contents to a new hashset of Strings
    trackingNumber ="";// sets trackingNumber to an empty string
    this.value = value;
    
    }
    
    /**
     * Public method which takes an argument of string and sets this to trackingNumber and updates DateSent to the 
     * current date
     * 
     */
    public void setDateAndTracking(String trackingNumber)
    {
    // sets trackingNumber to argument passed
    trackingNumber = this.trackingNumber;
    // Gets the current date 
    LocalDate currentDate = LocalDate.now();
    // creates format for the date
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
    // formats current date using the formatter
    String formattedDate = currentDate.format(formatter);
    // sets Datesent to the formatted date, uses the getter method from Freight
    setDateSent(formattedDate);
    
    
    
    }
    /**
     * Overides the toString method from Parent class Parcel to return a string representation of the Tracked Parcel object,
     * sorts list contents into alphabetically order, does not add anything for contents, dateSent or tracking number if they 
     * are empty
     */
    public String toString()
    {
        String returnString = super.toString(); // Call Parcel (Adult Class) toString method 
        
         if (!contents.isEmpty()) {//checks if contents is empty 
            ArrayList<String> sortedContents = new ArrayList<>(contents);
            Collections.sort(sortedContents); // Sort contents alphabetically
            returnString += "\nContents: " + String.join(" ", sortedContents);
        }
            
            if (value != 0) {
            double valueInPounds = value / 100.0; // Convert value from pence to pounds
            returnString += "\nValue: £" + String.format("%.2f", valueInPounds);
        }
        
        if (!getDateSent().isEmpty()) {// checks if Datesent is empty 
            returnString += "\nDate Sent: " + getDateSent();
        }
        
        if (!trackingNumber.isEmpty()) {// checks if trackingNumber is empty
            returnString += "\nTracking Number: " + trackingNumber;
        }
        
        return returnString;
       
        
    }
    
    /**
     * overides Parcel class, checks for equality between instances of trackedParcel based upon the tracking number
     * returns false if instances are not the same class or if tracking numbers do not match
     * Please note I have really struggled with this method and hashcode methods in particluar, any feedback would 
     * be appreicated
     */
    public boolean equals (Object o) {
        if (o != null && o instanceof TrackedParcel){// checks if object is not null and is an instance of tracked parcel
            TrackedParcel tp = (TrackedParcel) o;// sets object to trackedParcel
            // checks if parcel equals method returns true for the object and if tracking numbers are equal
            return super.equals(o) && trackingNumber.equals(tp.getTrackingNumber());
        }
        return false;
        
    }
    
    /**
     * returns hascode value for trackedParcel object based on address,dateSent and trackingNumber
     */
    public int hashcode()
    {
    return Objects.hash(getAddress(), getDateSent(), trackingNumber);
    }
    
    /**
     * Calculates the quotation for transporting the TrackedParcel based on the provided cost per kilogram
     * including tracking fee
     */
    public double createQuote(int costPerKilo)
    {
    double parcelPrice = super.createQuote(costPerKilo);
    double totalPrice = parcelPrice + TRACKING_FEE;
    
    return Math.round(totalPrice*100.0) / 100.0;
    
    }
    /************************code given**********************/
    // /**
     // * @return the tracking number of the parcel
     // * 
     // */
    public String getTrackingNumber()
    {
         return trackingNumber;
    }
    
     // /**
     // * 
     // * @param anItem Adds anItem to the contents set for the parcel
     // */
     public void addItem(String anItem)
    {
         contents.add(anItem);
    }
}
