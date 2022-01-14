//TODO Add Comments
public class Student extends Person
{
    private String myIdNum; // Student Id Number
    private double myGPA;   // grade point average
    /**
     * Constructor
     * Initializes variables such as gpa, age, gender, etc
     * @param name
     * @param age
     * @param gender
     * @param idNum
     * @param gpa
     */
    public Student( String name, int age, String gender, String idNum,
                    double gpa )
    {
        // use the super class' constructor
        super( name, age, gender );
        // initialize what's new to Student
        myIdNum = idNum;
        myGPA = gpa;
    }
    /**
     * Gets the Id Number
     * @return myIdNum
     */
    public String getIdNum()
    {
        return myIdNum;
    }
    /**
     * Gets the GPA
     * @return myGPA
     */
    public double getGPA()
    {
        return myGPA;
    }
    /**
     * Sets the ID number
     * @param idNum
     */
    public void setIdNum( String idNum )
    {
        myIdNum = idNum;
    }
    /**
     * Sets the GPA
     * @param gpa
     */
    public void setGPA( double gpa )
    {
        myGPA = gpa;
    }

    /**
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", student id: " +
            myIdNum + ", gpa: " + myGPA;
    }
}
