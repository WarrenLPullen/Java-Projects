
/**
 * Interface that provides a quote of the cost of transporting parcels and tracked parcels 
 *
 * @Warren Pullen
 * @30/04/24
 */
public interface PriceQuoter
{
    double createQuote (int unitPrice);
}

