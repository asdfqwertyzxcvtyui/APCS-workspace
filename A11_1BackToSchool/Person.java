
public class Person
{
    private String myName;   // name of the person
    private int myAge;       // person's age
    private String myGender; // 'M' for male, 'F' for female
    /**
     * Constructor
     * Initializes variables name, age, and gender
     * @param name
     * @param age
     * @param gender
     */
     public Person( String name, int age, String gender )
    {
        myName = name;
        myAge = age;
        myGender = gender;
    }
    /**
     * Gets the name
     * @return myName
     */
    public String getName()
    {
        return myName;
    }
    /**
     * Returns the age
     * @return myAge
     */
    public int getAge()
    {
        return myAge;
    }
    /**
     * Returns the gender
     * @return myGender
     */
    public String getGender()
    {
        return myGender;
    }
    /**
     * Sets myName to the name
     * @param name
     */
    public void setName( String name )
    {
        myName = name;
    }
    /**
     * Sets myAge to age
     * @param age
     */
    public void setAge( int age )
    {
        myAge = age;
    }
    /**
     * Sets myGender to gender
     * @param gender
     */
    public void setGender( String gender )
    {
        myGender = gender;
    }

    /**
     * Returns a String representation of this class.
     * @return private instance data as a String
     */
    public String toString()
    {
        return myName + ", age: " + myAge + ", gender: " + myGender;
    }
}