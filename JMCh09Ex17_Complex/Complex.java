/**
 * Represents a complex number of the form a + bi. Provides methods for adding,
 * multiplying and calculating the absolute value.
 *
 * @author Aaron Shih
 * @version 10/3/2021
 * @author Period: 6
 * @author Assignment: JMCh09Ex17_Complex
 * @author Sources: Mark Kwong
 */
public class Complex
{
    private double real;
    private double imaginary;

    /**
     * This is a constructor that sets real to the input value of a
     * 
     * @param a
     *            the real value in a complex number
     */
    public Complex(double a)
    {
        this.real = a;
        this.imaginary = 0.0;
    }


    /**
     * This is a constructor that sets real to the input value of a
     * 
     * @param a
     *            the real value in a complex number
     * @param b
     *            the imaginary value in a complex number
     */
    public Complex(double a, double b)
    {
        this.real = a;
        this.imaginary = b;
    }


    /**
     * This is a setter that sets real
     * 
     * @param a
     *            the real value in a complex number
     */
    public void setReal(double a)
    {
        this.real = a;
    }


    /**
     * This is a setter that sets imaginary
     * 
     * @param b
     *            the imaginary value in a complex number
     */
    public void setImaginary(double b)
    {
        this.imaginary = b;
    }


    /**
     * This is a getter that returns real
     * 
     * @param none
     * @return real
     */
    public double getReal()
    {
        return real;
    }


    /**
     * This is a getter that returns imaginary
     * 
     * @param none
     * @return imaginary
     */
    public double getImaginary()
    {
        return imaginary;
    }


    /**
     * absolute value of a complex number
     * 
     * @param none
     * @return absolute value of a complex number
     */
    public double abs()
    {
        return Math.sqrt((real * real) + (imaginary * imaginary));
    }


    /**
     * adds two complex numbers together
     * 
     * @param other
     *            another complex number
     * @return a new object of the added complex numbers
     */
    public Complex add(Complex other)
    {
        double temp1 = this.real + other.real;
        double temp2 = this.imaginary + other.imaginary;
        Complex num = new Complex(temp1, temp2);
        return num;
    }


    /**
     * Multiplies the values of two complex numbers
     * 
     * @param other
     *            another complex number
     * @return complex number of two complex numbers multiplied
     */
    public Complex multiply(Complex other)
    {
        double temp1 = (real * other.real) - (imaginary * other.imaginary);
        double temp2 = (imaginary * other.real) + (real * other.imaginary);
        Complex num = new Complex(temp1, temp2);
        return num;
    }


    /**
     * Adds the values of a complex number and a real number
     * 
     * @param a
     *            an real number
     * @return the sum of a real number added to a complex number
     */
    public Complex add(double a)
    {
        Complex num = new Complex(this.real + a, this.imaginary);
        return num;
    }


    /**
     * Multiplies the values of a complex number and a real number
     * 
     * @param m
     *            a real number
     * @return the product of a real number multplied by a complex number
     */
    public Complex multiply(double m)
    {
        Complex num = new Complex((this.real * m), (this.imaginary * m));
        return num;
    }


    /**
     * Formats real and imaginary values into a complex number in the form of a
     * + bi Override
     * 
     * @param none
     * @return a string of a complex number in the form of a + bi
     */
    @Override
    public String toString()
    {
        return real + " + " + imaginary + "i";
    }
}
