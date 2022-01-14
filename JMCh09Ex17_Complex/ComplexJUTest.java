import org.junit.*;
import org.xml.sax.ext.Attributes2Impl;
import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

/**
 * Test for the complex number class. testConstructor1Param - test the 1
 * parameter constructor testConstructor2Param - test the 2 parameter
 * constructor testAddRealAndComplexNum - addition of a complex number with a
 * real number testAdd2ComplexNums - addition of two complex numbers
 * testMultiply2ComplexNums - multiplication of two complex numbers
 * testMultiplyRealAndComplexNum - multiplication of a complex number with a
 * real number testAbsoluteValue - absolute value of a complex number
 *
 * @author TODO Your Name
 * @version TODO Date
 * @author Period: TODO Your Period
 * @author Assignment: JMCh09Ex17_Complex
 * @author Sources: TODO List collaborators
 */
public class ComplexJUTest
    extends junit.framework.TestCase
{
    @Test
    public void testConstructor1Param()
    {
        double a = 1;
        double b = 0;
        Complex c1 = new Complex(a);
        assertEquals(a, c1.getReal(), 0);
        assertEquals(b, c1.getImaginary(), 0);
    }


    @Test
    public void testConstructor2Param()
    {
        double a = 1;
        double b = 2;
        Complex c1 = new Complex(a, b);
        assertEquals(a, c1.getReal(), 0);
        assertEquals(b, c1.getImaginary(), 0);
    }


    @Test
    public void testAddRealAndComplexNum()
    {
        double a1 = 1;
        double a2 = 2;
        double b1 = 3;
        double b2 = 4;
        Complex c1 = new Complex(a1, b1);
        Complex c2 = c1.add(a2);
        assertEquals(a1 + a2, c2.getReal(), 0);
        assertEquals(b1, c2.getImaginary(), 0);
    }


    @Test
    public void testAdd2ComplexNums()
    {
        double a1 = 1;
        double a2 = 2;
        double b1 = 3;
        double b2 = 4;
        Complex c1 = new Complex(a1, b1);
        Complex c2 = new Complex(a2, b2);
        Complex c3 = c1.add(c2);
        assertEquals(a1 + a2, c3.getReal(), 0);
        assertEquals(b1 + b2, c3.getImaginary(), 0);
    }


    @Test
    public void testMultiply2ComplexNums()
    {
        double a1 = 1;
        double a2 = 2;
        double b1 = 3;
        double b2 = 4;
        Complex c1 = new Complex(a1, b1);
        Complex c2 = new Complex(a2, b2);
        Complex c3 = c1.multiply(c2);
        assertEquals(a1 * a2 - b1 * b2, c3.getReal(), 0);
        assertEquals(a1 * b2 + a2 * b1, c3.getImaginary(), 0);
    }


    @Test
    public void testMultiplyRealAndComplexNum()
    {
        double a1 = 1;
        double a2 = 2;
        double b1 = 3;
        Complex c1 = new Complex(a1, b1);
        Complex c3 = c1.multiply(a2);
        assertEquals(a1 * a2, c3.getReal(), 0);
        assertEquals(b1 * a2, c3.getImaginary(), 0);
    }


    @Test
    public void testAbsoluteValue()
    {
        double a1 = 1;
        double b1 = -3;
        Complex c1 = new Complex(a1, b1);
        assertEquals(Math.sqrt(a1 * a1 + b1 * b1), c1.abs(), 0);
    }


    @Test
    public void testToString()
    {
        double a1 = 1;
        double b1 = 1;
        Complex c1 = new Complex(a1, b1);
        assertEquals("1.0 + 1.0i", c1.toString());
    }


    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter(ComplexJUTest.class);
    }


    public static void main(String args[])
    {
        org.junit.runner.JUnitCore.main("ComplexJUTest");
    }
}
