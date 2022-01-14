/**
 * CollegeStudent extends Sudent The class returns that Age, Name, Gender, GPA,
 * Year, and ID number for a college student
 * @author Aaron Shih
 * @version 10/25/2021
 */
public class CollegeStudent extends Student {
    private String myMajor;
    private int myYear;

    /**
     * Constructor Initializes variables such as Age, Gender, Name, etc
     * 
     * @param myName   Name of of college student
     * @param myAge Age of the college student
     * @param myGender Gender of the college student
     * @param myIdNum Student's ID number
     * @param myGPA Student's GPA
     * @param year The current year 
     * @param major The major that the student is taking
     */
    public CollegeStudent(String myName, int myAge, String myGender, 
            String myIdNum, double myGPA, int year,
            String major) {
        super(myName, myAge, myGender, myIdNum, myGPA);
        myMajor = major;
        myYear = year;
    }

    /**
     * Returns Major
     * 
     * @return myMajor
     */
    public String getMajor() {
        return myMajor;
    }

    /**
     * returns year
     * 
     * @return myYear
     */
    public int getYear() {
        return myYear;
    }

    /**
     * Sets Major
     * 
     * @param major The major the student is taking
     */
    public void setMajor(String major) {
        myMajor = major;
    }

    /**
     * Sets year
     * 
     * @param year The current year
     */
    public void setYear(int year) {
        myYear = year;
    }

    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString() {
        return super.toString() + ", year: " + myYear + ", major: " + myMajor;
    }
}
