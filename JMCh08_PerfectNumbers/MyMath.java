/**
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  TODO your name
 *  @version TODO the date
 *  @author  Period: TODO 
 *  @author  Assignment: JMCh08_PerfectNumbers
 *
 *  @author  Sources: TODO list collaborators
 */
public class MyMath
{
    /**
     * Returns true if n is a prime; otherwise returns false.
     * @param n  number to check if prime
     * @return  true if n is a prime; otherwise returns false
     */
    public static boolean isPrime( long n )
    {
        if ( n <= 1 )
            return false;

        int m = 2;

        while ( m * m <= n )
        {
            if ( n % m == 0 )
                return false;
            m++;
        }

        return true;
    }


    /**
     * Question 8-15 Returns the n-th Fibonacci number
     * 
     * Find and read a few informative websites dedicated to Fibonacci numbers.
     * The following recursive method returns the n-th Fibonacci number:
     * 
     *   // Returns the n-th Fibonacci number.
     *   // Precondition: n >= 1
     *   public static long fibonacci(int n)
     *   {
     *     if (n == 1 || n == 2)
     *       return 1;
     *     else
     *       return fibonacci(n - 1) + fibonacci(n - 2);
     *   }
     * Rewrite it without recursion, using one loop.
     *
     * @param n  Fibonacci number to find
     * @return  n-th Fibonacci number
     */
    public static long fibonacci( int n )
    {
        int a = 0;
        int b = 1;
        int c = 0;
        for (int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c; // ** FIX THIS
    }


    /**
     * Returns true if n is a perfect number, false otherwise.
     * 
     * @param n  number to test
     * @return   true if n is a perfect number, false otherwise.
     */
    public static boolean isPerfect( long n )
    {
        if (n < 2) {
            return false;
        }
        long sum = 1;
        long sqrt = (long)Math.sqrt(n);
        for (long i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                sum = sum + i + n / i;
                if (sum > n) {
                    return false;
                }
            }
        }
        return sum == n;

    }


    /**
     * Prints the first n perfect numbers
     * 
     * @param n number of perfect numbers to print
     */
    public static void printPerfectNums( int n )
    {
        System.out.println( "Perfect numbers: " );
        int count = 0;
        for ( int k = 1; count < n; k++ )
        {
            if ( isPerfect( k ) )
            {
                System.out.print( k + " " );
                count++;
            }
        }
        System.out.println();
    }


    /**
     * Prints the first n Mersenne primes
     * 
     * @param n number of Mersenne primes to print
     */
    public static void printMersennePrimes( long n )
    {
        System.out.println( "Mersenne primes: " );
        long value = 1;
        long count = 0;
        while(count < n) {
            value =  2 * value;
            if (isPrime(value - 1)){
                System.out.println(value - 1);
                count++;
            }
        }
    }
    

    /**
     * Prints the first n even perfect numbers
     */
    public static void printEvenPerfectNums( int n )
    {
        System.out.println( "Even perfect numbers: " );

        int count = 0;
        for (int i = 1; count < n; i++) {
                          // (2^(n-1))  * ((2^n) -1)
             long value = ((1L << (i - 1)) * ((1L << i) - 1));
            if (isPerfect(value)) {
                System.out.println(value);
                count++;
            }

            
        }   
    }


    /*********************************************************************/

    public static void main( String[] args )
    {
        int n = 19;
        System.out.println( n + "-th Fibonacci number = " + fibonacci( n ) );

        printPerfectNums( 4 );
        printMersennePrimes( 6 );
        printEvenPerfectNums( 6 );
    }
}
/*
19-th Fibonacci number = 4181
Perfect numbers: 
6 28 496 8128 
Mersenne primes: 
3 7 31 127 8191 131071
Even perfect numbers: 
6 28 496 8128 33550336 8589869056
*/
