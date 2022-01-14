import java.lang.reflect.*;

/**
   This class implements a vendor that sells one kind of item.
   A vendor carries out sales transactions.

   @author  TODO Your Name
   @version TODO Date

   @author Period - TODO Your Period
   @author Assignment - Java Methods Ch09 - SnackBar

   @author Sources - TODO list collaborators
 */
public class Vendor
{
    // Fields:
    private int stock;
    private int price;
    private int amount;
    private int change;
    private static double totalSales;

    //  Constructor
    //  Parameters:
    //    int price of a single item in cents
    //    int number of items to place in stock
    
    public Vendor (int price, int stock)
    {
        this.price = price;
        this.stock = stock;
    }

    public static void setTotalSales(double s){
        totalSales = s;
    }

    public static double getTotalSales(){
        double value = totalSales;
        totalSales = 0;
        return value;
    }
    //  Sets the quantity of items in stock.
    //  Parameters:
    //    int number of items to place in stock
    //  Return:
    //    None
    public void setStock (int s)
    {
        stock = s;
    }

    //  Returns the number of items currently in stock.
    //  Parameters:
    //    None
    //  Return:
    //    int number of items currently in stock
    public int getStock()
    {
        return stock;
    }

    //  Adds a specified amount (in cents) to the deposited amount.
    //  Parameters:
    //    int number of cents to add to the deposit
    //  Return:
    //    None
    public void addMoney(int cents)
    {
        if (stock > 0) {
            amount = amount + cents;
        }
    }

    //  Returns the currently deposited amount (in cents).
    //  Parameters:
    //    None
    //  Return:
    //    int number of cents in the current deposit
    public int getDeposit ()
    {
        return amount;
    }

    //  Implements a sale.  If there are items in stock and
    //  the deposited amount is greater than or equal to
    //  the single item price, then adjusts the stock
    //  and calculates and sets change and returns true;
    //  otherwise refunds the whole deposit (moves it into change)
    //  and returns false.
    //  Parameters:
    //    None
    //  Return:
    //    boolean successful sale (true) or failure (false)
    public boolean makeSale ()
    {
        if (stock > 0 && amount >= price) {
            change = amount - price;
            double value = (double) price / 100.0;
            setTotalSales(totalSales + value);
            setStock(getStock() - 1);
            amount = 0;
            return true;
        } else {
            change = amount;
            amount = 0;
            return false;
        }
    }

    //  Returns and zeroes out the amount of change (from the last
    //  sale or refund).
    //  Parameters:
    //    None
    //  Return:
    //    int number of cents in the current change
    public int getChange ()
    {
        int a = change;
        change = 0;
        return a;
    }

    /**
        Intended only for debugging.
        
        <p>A generic toString implementation that uses reflection to print
        names and values of all fields <em>declared in this class</em>.
        Note that superclass fields are left out of this implementation.</p>
        
        @return  a string representation of this Vendor.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                str += separator + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}
