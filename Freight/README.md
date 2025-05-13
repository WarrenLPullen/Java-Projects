### Description
This is a Java program that calculates the cost of shipping various items, including parcels, tracked parcels, and removals.  It uses inheritance and polymorphism.

### How it Works
1.  The program defines an abstract class `Freight` which represents a shippable item and implements the `PriceQuoter` interface.
2.  The `Parcel` class extends `Freight` and represents a standard parcel with weight and dimensions.  It includes a method to check if the parcel dimensions and weight are within acceptable limits.
3.  The `TrackedParcel` class extends `Parcel` and adds tracking information and a value.  It also adds a tracking fee to the shipping cost.
4.  The `Removal` class extends `Freight` and represents a larger shipment with a volume.
5.  The `PriceQuoter` interface defines a `createQuote` method for calculating the shipping cost.

### Files
* `Freight.java`: Abstract base class for all shippable items.
* `Parcel.java`: Represents a standard parcel.
* `PriceQuoter.java`: Interface for calculating shipping costs.
* `Removal.java`: Represents a large shipment for removal services.
* `TrackedParcel.java`: Represents a parcel with tracking.

### How to Use
1.  Compile the Java files using a Java compiler.
2.  Run the compiled class files.  You will likely interact with the classes by creating instances of them and calling their methods to calculate shipping costs.  For example, you might create a `Parcel` object and then call its `createQuote` method.

### Code Details
* `Freight.java`:
    * Abstract class that implements `PriceQuoter`.
    * Stores the address and date the freight was sent.
    * Provides getter and setter methods.
* `Parcel.java`:
    * Extends `Freight`.
    * Stores weight, width, length, and height.
    * Defines constants for maximum length, size, and weight.
    * Includes methods to:
        * Get side sizes.
        * Calculate parcel size.
        * Check if the parcel is within limits.
        * Calculate shipping cost using the `createQuote` method from the `PriceQuoter` interface.
        * Override the `equals()` and `toString()` methods.
* `PriceQuoter.java`:
    * Interface with a `createQuote(int unitPrice)` method.
* `Removal.java`:
    * Extends `Freight`.
    * Stores the volume of the removal.
    * Calculates shipping cost based on volume.
* `TrackedParcel.java`:
    * Extends `Parcel`.
    * Stores tracking number, value, and contents.
    * Adds a tracking fee to the shipping cost in the `createQuote` meth
