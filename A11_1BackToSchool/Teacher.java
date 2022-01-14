/**
 * The teacher class returns a teacher's age, name, subject, gender and salary
 * @author Aaron Shih
 * @version 10/25/2021
 */
public class Teacher extends Person {
    private String subject;
    private double salary;

    /**
     * Initializes input variables such as age, name, subject, etc
     * @param myName Name of the teacher
     * @param myAge Age of the teacher
     * @param myGender Gender of the teacher
     * @param mySubject Subject that the teacher teaches
     * @param mySalary The salary of the teacher
     */
    public Teacher(String myName, int myAge, String myGender, 
                String mySubject, double mySalary) {
        super(myName, myAge, myGender);
        this.subject = mySubject;
        this.salary = mySalary;
    }

    /**
     * returns salary
     * @return subject
     */
    public String getSubject() {
        return this.subject;
    }
    /**
     * returns salary
     * @return salary
     */
    public double getSalary() {
        return this.salary;
    }
    /**
     * Sets subject
     * @param subject The subject the teacher teaches
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }
    /**
     * Sets salary
     * @param salary Salary of a teacher
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString() {
        return super.toString() + ", subject: " 
            + subject + ", salary: " + salary;
    }
}
