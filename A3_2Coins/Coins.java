import java.lang.reflect.Field;
import java.util.Scanner;

/**
 * Coins: This class accepts a certain amount of monetary change (in cents).
 * The output is a list of the number of quarters, dimes, nickels, and
 * pennies that will make that amount of change with the least number of
 * coins possible.
 *
 * @author Aaron Shih
 * @version Version 1.0
 * @author Period: 6
 * 
 * @author Assignment: Lab Activity 3.2 - Coins
 * 
 * @author Sources: Aaron Shih
 */
public class Coins
{
    private int myChange;

    public Coins( int change )
    {
        myChange = change;
    }
    /**
     * Calculate the number of Quarters, dimes, nickels, and pennies in a given amount of money
     * Then prints out the amount for each type of coin
     * @param nothing
     * @return void
     */
    public void calculate()
    {
        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        int penny = 1;
        int value = myChange;
        int quarterCount = value/quarter;
        value = value - (quarterCount * 25);
        int dimeCount = (value/dime);
        value = value - (dimeCount * 10);
        int nickelCount = value/nickel;
        value = value - (nickelCount * 5);
        int pennyCount = value/penny;
        System.out.println("Quarter(s)\t" + quarterCount);
        System.out.println("Dimes(s)\t" + dimeCount);
        System.out.println("Nickels(s)\t" + nickelCount);
        System.out.println("Penny(s)\t" + pennyCount);

    }            

    
    /**
     * Intended only for debugging.
     * 
     * <p>A generic toString implementation that uses reflection to print
     * names and values of all fields <em>declared in this class</em>.
     * Note that superclass fields are left out of this implementation.</p>
     * 
     * @return a string representation of this Easter.
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
                str += separator + field.getType().getName() + " "
                    + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }
            separator = ", ";
        }
        return str + "]";
    }

    /**
     * Tester for the Coins class.
     * @param args command line arguments - not used
     * @return nothing
     */
    public static void main( String[] args )
    {
        Scanner console = new Scanner( System.in );

        System.out.print( "Please enter the number of cents --> " );
        int cents = console.nextInt();

        Coins change = new Coins( cents );
        change.calculate();
    }
}
