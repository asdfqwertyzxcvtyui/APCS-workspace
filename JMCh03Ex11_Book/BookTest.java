/**
 *  This is a class that tests the Book class.
 *
 *  @author  TODO your name
 *  @version TODO date
 *  @author  Period: TODO your period
 *  @author  Assignment: JMCh03Ex11_Book
 *
 *  @author  Sources: TODO list collaborators
 */
public class BookTest
{
    /**
     * The main method in this class checks the Book operations for
     * consistency.
     * @param args is not used.
     */
    public static void main( String[] args )
    {
        /* TODO *** TO BE IMPLEMENTED *** */
        Book myBook = new Book(3);
        int numPages = myBook.getNumPages();
        System.out.println(numPages);
        int currentPage = myBook.getCurrentPage();
        System.out.println(currentPage);
        myBook.nextPage();
        currentPage = myBook.getCurrentPage();
        System.out.println(currentPage);
        myBook.nextPage();
        currentPage = myBook.getCurrentPage();
        System.out.println(currentPage);
        myBook.nextPage();
        currentPage = myBook.getCurrentPage();
        System.out.println(currentPage);
    }   
}
